package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Posicao;

public class ArtistaDaoImpl implements ArtistaDao {
	
	@PersistenceContext(unitName="AlbumDeMusicas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Posicao> getArtistas(Posicao artista) {
		StringBuffer hql = new StringBuffer("from Artista a"
				+ " where 1 = 1");		
		if (artista.getCodigo() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (artista.getCodigo() != null) {
			query.setParameter("codigo",artista.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Posicao artista) {
		artista = entityManager.merge(artista);
		entityManager.remove(artista);
	}

	@Override
	@Transactional
	public Posicao salvar(Posicao artista) {
		entityManager.persist(artista);
		return artista;
	}

	@Override
	@Transactional
	public void atualizar(Posicao artista) {
		artista = entityManager.merge(artista);
		entityManager.persist(artista);		
	}
	

}
