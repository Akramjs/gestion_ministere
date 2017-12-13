package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.AvoirBudOrgService;
import tn.ministere.entity.AvoirBudorg;
import tn.ministere.entity.AvoirBudorgId;

@Service
@Transactional
public class AvoirBudOrgServiceImpl implements AvoirBudOrgService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(AvoirBudorg f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(AvoirBudorg f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public AvoirBudorg findById(AvoirBudorgId id) {

		return (AvoirBudorg) sessionFactory.getCurrentSession().get(
				AvoirBudorg.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AvoirBudorg> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from AvoirBudorg a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(AvoirBudorg f) {
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
	public List<AvoirBudorg> findAllNotValidated() {
		// TODO Auto-generated method stub
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"select a from AvoirBudorg a where a.id.codeUtil='I'")
				.list();
	}

}
