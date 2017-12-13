package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.GroupeService;
import tn.ministere.entity.Groupe;

@Service
@Transactional
public class GroupeServiceImpl implements GroupeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Groupe f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(Groupe f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public Groupe findById(String id) {

		return (Groupe) sessionFactory.getCurrentSession()
				.get(Groupe.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Groupe a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Groupe f) {
		sessionFactory.getCurrentSession().delete(f);
		return true;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
