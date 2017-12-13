package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.UtilisateurService;
import tn.ministere.entity.Profil;
import tn.ministere.entity.Utilisateur;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Utilisateur f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(Utilisateur f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public Utilisateur findById(String id) {

		return (Utilisateur) sessionFactory.getCurrentSession().get(
				Utilisateur.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Utilisateur a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Utilisateur f) {
		sessionFactory.getCurrentSession().delete(f);
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

	@SuppressWarnings("unchecked")
	@Override
	public Utilisateur findByCin(String cin) {
		List<Utilisateur> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select a from Utilisateur a where a.cinUtilisateur='"
								+ cin + "'").list();
		if (list.size() == 0)
			return null;
		return list.get(0);
	}

}
