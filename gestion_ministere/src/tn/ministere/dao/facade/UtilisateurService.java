package tn.ministere.dao.facade;

import java.util.List;

import tn.ministere.entity.Profil;
import tn.ministere.entity.Utilisateur;

public interface UtilisateurService {

	void add(Utilisateur f);

	void update(Utilisateur f);

	Utilisateur findById(String id);
	
	Utilisateur findByCin(String cin);

	List<Utilisateur> findAll();

	boolean delete(Utilisateur f);

	Profil findProfilById(String id);

	List<Profil> findAllProfil();

}
