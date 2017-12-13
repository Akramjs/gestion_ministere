package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.PaysDestinationService;
import tn.ministere.entity.PaysDestination;

@Service
@Transactional
public class PaysDestinationServiceImpl implements PaysDestinationService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(PaysDestination p) {
		sessionFactory.getCurrentSession().persist(p);

	}

	// method of updating a corporate
	@Override
	public void update(PaysDestination p) {
		sessionFactory.getCurrentSession().merge(p);

	}

	@Override
	public PaysDestination findById(String id) {

		return (PaysDestination) sessionFactory.getCurrentSession().get(
				PaysDestination.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PaysDestination> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from PaysDestination a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(PaysDestination p) {
		sessionFactory.getCurrentSession().delete(p);
		return true;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
