package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.ThemeService;
import tn.ministere.entity.Theme;
import tn.ministere.entity.Zone;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Theme z) {
		sessionFactory.getCurrentSession().persist(z);

	}

	// method of updating a corporate
	@Override
	public void update(Theme z) {
		sessionFactory.getCurrentSession().merge(z);

	}

	@Override
	public Theme findById(String id) {

		return (Theme) sessionFactory.getCurrentSession().get(
				Theme.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Theme> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Theme a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Theme z) {
		sessionFactory.getCurrentSession().delete(z);
		return true;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
