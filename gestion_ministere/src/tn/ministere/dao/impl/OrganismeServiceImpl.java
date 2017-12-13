package tn.ministere.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ministere.dao.facade.OrganismeService;
import tn.ministere.entity.Organisme;

@Service
@Transactional
public class OrganismeServiceImpl implements OrganismeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Organisme f) {
		sessionFactory.getCurrentSession().persist(f);

	}

	// method of updating a corporate
	@Override
	public void update(Organisme f) {
		sessionFactory.getCurrentSession().merge(f);

	}

	@Override
	public Organisme findById(String id) {

		return (Organisme) sessionFactory.getCurrentSession().get(
				Organisme.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organisme> findAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("select a from Organisme a").list();
	}

	// method of deleting a corporate
	@Override
	public boolean delete(Organisme f) {
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
	public String findMaxId() {
		try {
			Organisme o = (Organisme) sessionFactory.getCurrentSession()
					.createQuery("from Organisme a order by a.codeOrg").list()
					.get(0);
			String idTemp = "000000";
			String curId = "" + (Integer.parseInt(o.getCodeOrg()) + 1);
			String id = idTemp.substring(0, 6-curId.length()) + curId;
			return id;
		} catch (IndexOutOfBoundsException e) {
			return "000000";
		}

	}

}
