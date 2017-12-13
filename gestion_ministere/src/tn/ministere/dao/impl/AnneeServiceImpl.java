package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.AnneeService;
import tn.ministere.entity.Annee;

@Service
@Transactional
public class AnneeServiceImpl implements AnneeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Annee findById(int id) {

		return (Annee) sessionFactory.getCurrentSession().get(Annee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annee> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Annee a").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
