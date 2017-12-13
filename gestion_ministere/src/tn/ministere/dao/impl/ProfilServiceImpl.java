package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.ProfilService;
import tn.ministere.entity.Profil;


@Service
@Transactional
public class ProfilServiceImpl implements ProfilService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Profil p) {
		sessionFactory.getCurrentSession().persist(p);

	}

	// method of updating a corporate
	@Override
	public void update(Profil p) {
		sessionFactory.getCurrentSession().merge(p);

	}

	@Override
	public Profil findById(String id) {

		return (Profil) sessionFactory.getCurrentSession().get(
				Profil.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profil> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Profil a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Profil p) {
		sessionFactory.getCurrentSession().delete(p);
		return true;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Profil> findAllProfil() {
		return sessionFactory.getCurrentSession()
				.createQuery("select a from Profil a").list();
	}

	@Override
	public Profil findProfilById(String id) {
		return (Profil) sessionFactory.getCurrentSession()
				.get(Profil.class, id);
	}

}
