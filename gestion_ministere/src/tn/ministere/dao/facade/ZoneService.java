
	package tn.ministere.dao.facade;

	import java.util.List;

	import tn.ministere.entity.Zone;

	public interface ZoneService {

		void add(Zone z);

		void update(Zone z);

		Zone findById(String id);

		List<Zone> findAll();

		boolean delete(Zone z);

	}

