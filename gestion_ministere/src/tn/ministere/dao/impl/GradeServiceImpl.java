package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.GradeService;
import tn.ministere.entity.Grade;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Grade f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(Grade f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public Grade findById(String id) {

		return (Grade) sessionFactory.getCurrentSession().get(Grade.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grade> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Grade a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Grade f) {
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
