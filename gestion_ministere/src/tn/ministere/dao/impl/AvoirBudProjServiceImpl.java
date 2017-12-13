package tn.ministere.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.AvoirBudProjService;
import tn.ministere.entity.AvoirBudproj;
import tn.ministere.entity.AvoirBudprojId;
import tn.ministere.entity.DateAvoirBudproj;

@Service
@Transactional
public class AvoirBudProjServiceImpl implements AvoirBudProjService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(AvoirBudproj f) {
		List<AvoirBudproj> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select a from AvoirBudproj a where a.id.codeProj='"
								+ f.getId().getCodeProj()
								+ "' order by a.id.numeroOrdreBudProj desc")
				.list();
		if (list.size() == 0)
			f.getId().setNumeroOrdreBudProj(0);
		else
			f.getId().setNumeroOrdreBudProj(
					list.get(0).getId().getNumeroOrdreBudProj() + 1);
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(AvoirBudproj f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public AvoirBudproj findById(AvoirBudprojId id) {

		return (AvoirBudproj) sessionFactory.getCurrentSession().get(
				AvoirBudproj.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AvoirBudproj> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from AvoirBudproj a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(AvoirBudproj f) {
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
	public void add(DateAvoirBudproj d) {
		sessionFactory.getCurrentSession().persist(d);

	}

	@Override
	public DateAvoirBudproj findById(Date id) {
		return (DateAvoirBudproj) sessionFactory.getCurrentSession().get(
				DateAvoirBudproj.class, id);
	}

	@Override
	public List<AvoirBudproj> findAllNotValidated() {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"select a from AvoirBudproj a where a.id.codeUtil='I'")
				.list();
	}

}
