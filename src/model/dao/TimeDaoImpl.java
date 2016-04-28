package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Time;

public class TimeDaoImpl implements TimeDao {
	
	@PersistenceContext(unitName="TimeDeMusicas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Time> getTimes(Time time) {
		StringBuffer hql = new StringBuffer("from Time a"
				+ " where 1 = 1");		
		if (time.getCodigo() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (time.getCodigo() != null) {
			query.setParameter("codigo",time.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Time time) {
		time = entityManager.merge(time);
		entityManager.remove(time);
	}

	@Override
	@Transactional
	public Time salvar(Time time) {
		entityManager.persist(time);
		return time;
	}

	@Override
	@Transactional
	public void atualizar(Time time) {
		time = entityManager.merge(time);
	}
	

}
