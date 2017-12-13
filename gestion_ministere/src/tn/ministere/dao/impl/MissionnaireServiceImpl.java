package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.MissionnaireService;
import tn.ministere.entity.Missionnaire;

@Service
@Transactional
public class MissionnaireServiceImpl implements MissionnaireService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Missionnaire m) {
		sessionFactory.getCurrentSession().persist(m);

	}

	// method of updating a corporate
	@Override
	public void update(Missionnaire m) {
		sessionFactory.getCurrentSession().merge(m);

	}

	@Override
	public Missionnaire findById(String cinMissionnaire) {

		return (Missionnaire) sessionFactory.getCurrentSession().get(Missionnaire.class, cinMissionnaire);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Missionnaire> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select m from Missionnaire m").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Missionnaire m) {
		sessionFactory.getCurrentSession().delete(m);
		return true;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
