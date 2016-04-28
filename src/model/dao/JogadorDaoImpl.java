package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Jogador;

public class JogadorDaoImpl implements JogadorDao {
	
	@PersistenceContext(unitName="TimeDeFutebolDS")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Jogador> getJogadores(Jogador jogador) {
		StringBuffer hql = new StringBuffer("from Jogador a"
				+ " where 1 = 1");		
		if (jogador.getCodigo() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (jogador.getCodigo() != null) {
			query.setParameter("codigo",jogador.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Jogador jogador) {
		jogador = entityManager.merge(jogador);
		entityManager.remove(jogador);
	}

	@Override
	@Transactional
	public Jogador salvar(Jogador jogador) {
		entityManager.persist(jogador);
		return jogador;
	}

	@Override
	@Transactional
	public void atualizar(Jogador jogador) {
		jogador = entityManager.merge(jogador);
		entityManager.persist(jogador);		
	}
	

}
