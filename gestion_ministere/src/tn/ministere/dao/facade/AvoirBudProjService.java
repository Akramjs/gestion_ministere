package tn.ministere.dao.facade;

import java.util.Date;
import java.util.List;

import tn.ministere.entity.AvoirBudproj;
import tn.ministere.entity.AvoirBudprojId;
import tn.ministere.entity.DateAvoirBudproj;

public interface AvoirBudProjService {

	void add(AvoirBudproj g);

	void update(AvoirBudproj g);

	AvoirBudproj findById(AvoirBudprojId id);

	List<AvoirBudproj> findAll();
	
	List<AvoirBudproj> findAllNotValidated();

	boolean delete(AvoirBudproj g);

	void add(DateAvoirBudproj d);

	DateAvoirBudproj findById(Date id);

}
