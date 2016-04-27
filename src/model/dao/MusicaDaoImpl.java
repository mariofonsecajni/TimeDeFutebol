package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Musica;

public class MusicaDaoImpl implements MusicaDao {
	
	@PersistenceContext(unitName="AlbumDeMusicas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Musica> getMusicas(Musica musica) {
		StringBuffer hql = new StringBuffer("from Musica a"
				+ " where 1 = 1");		
		if (musica.getCodigo() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (musica.getCodigo() != null) {
			query.setParameter("codigo",musica.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Musica musica) {
		musica = entityManager.merge(musica);
		entityManager.remove(musica);
	}

	@Override
	@Transactional
	public Musica salvar(Musica musica) {
		entityManager.persist(musica);
		return musica;
	}

	@Override
	@Transactional
	public void atualizar(Musica musica) {
		musica = entityManager.merge(musica);
		entityManager.persist(musica);		
	}
	

}
