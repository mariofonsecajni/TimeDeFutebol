package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Time;

public class TimeDaoImpl implements TimeDao {
	
	@PersistenceContext(unitName="AlbumDeMusicas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Time> getAlbums(Time album) {
		StringBuffer hql = new StringBuffer("from Album a"
				+ " where 1 = 1");		
		if (album.getNumero() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (album.getNumero() != null) {
			query.setParameter("codigo",album.getNumero());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Time album) {
		album = entityManager.merge(album);
		entityManager.remove(album);
	}

	@Override
	@Transactional
	public Time salvar(Time album) {
		entityManager.persist(album);
		return album;
	}

	@Override
	@Transactional
	public void atualizar(Time album) {
		album = entityManager.merge(album);
	}
	

}
