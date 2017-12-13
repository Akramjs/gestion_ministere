
	package tn.ministere.dao.facade;

	import java.util.List;

import tn.ministere.entity.Theme;

	public interface ThemeService {

		void add(Theme z);

		void update(Theme z);

		Theme findById(String id);

		List<Theme> findAll();

		boolean delete(Theme z);

	}

