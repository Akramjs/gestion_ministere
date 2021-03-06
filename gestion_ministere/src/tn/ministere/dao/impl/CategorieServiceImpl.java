package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.CategorieService;
import tn.ministere.entity.Categorie;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Categorie f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(Categorie f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public Categorie findById(String id) {

		return (Categorie) sessionFactory.getCurrentSession().get(
				Categorie.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Categorie a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Categorie f) {
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
