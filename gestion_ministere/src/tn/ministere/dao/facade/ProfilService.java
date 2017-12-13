package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Profil;


public interface ProfilService {

	void add(Profil p);

	void update(Profil p);

	Profil findById(String id);

	List<Profil> findAll();

	boolean delete(Profil p);

	Profil findProfilById(String id);

	List<Profil> findAllProfil();

}
