package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.TypeOrganismeService;
import tn.ministere.entity.TypeOrganisme;

@Service
@Transactional
public class TypeOrganismeServiceImpl implements TypeOrganismeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(TypeOrganisme f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(TypeOrganisme f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public TypeOrganisme findById(String id) {

		return (TypeOrganisme) sessionFactory.getCurrentSession().get(
				TypeOrganisme.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeOrganisme> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from TypeOrganisme a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(TypeOrganisme f) {
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
