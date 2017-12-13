package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.FonctionService;
import tn.ministere.entity.Fonction;

@Service
@Transactional
public class FonctionServiceImpl implements FonctionService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Fonction f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(Fonction f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public Fonction findById(String id) {

		return (Fonction) sessionFactory.getCurrentSession().get(
				Fonction.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fonction> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Fonction a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Fonction f) {
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
