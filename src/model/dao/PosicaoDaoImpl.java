package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Posicao;

public class PosicaoDaoImpl implements PosicaoDao {
	
	@PersistenceContext(unitName="TimeDeFutebolDS")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Posicao> getPosicoes(Posicao posicao) {
		StringBuffer hql = new StringBuffer("from Posicao a"
				+ " where 1 = 1");		
		if (posicao.getCodigo() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (posicao.getCodigo() != null) {
			query.setParameter("codigo",posicao.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Posicao posicao) {
		posicao = entityManager.merge(posicao);
		entityManager.remove(posicao);
	}

	@Override
	@Transactional
	public Posicao salvar(Posicao posicao) {
		entityManager.persist(posicao);
		return posicao;
	}

	@Override
	@Transactional
	public void atualizar(Posicao posicao) {
		posicao = entityManager.merge(posicao);
		entityManager.persist(posicao);		
	}
	

}
