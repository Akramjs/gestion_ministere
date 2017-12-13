package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.ZoneService;
import tn.ministere.entity.Zone;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Zone z) {
		sessionFactory.getCurrentSession().persist(z);

	}

	// method of updating a corporate
	@Override
	public void update(Zone z) {
		sessionFactory.getCurrentSession().merge(z);

	}

	@Override
	public Zone findById(String id) {

		return (Zone) sessionFactory.getCurrentSession().get(
				Zone.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Zone> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Zone a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Zone z) {
		sessionFactory.getCurrentSession().delete(z);
		return true;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
