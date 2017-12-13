package tn.ministere.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.ministere.dao.facade.UtilisateurService;
import tn.ministere.entity.Utilisateur;

@ManagedBean
@Component
@Scope("session")
public class LoginManagedBean implements Serializable {

	private String login;
	private String psw;
	private Utilisateur connctedUser;
	@Autowired
	private UtilisateurService userService;

	@PostConstruct
	public void init() {
		connctedUser = new Utilisateur();
	}

	public void getUserName() {
		connctedUser = userService.findByCin(connctedUser.getCinUtilisateur());
		if (connctedUser == null)
			connctedUser = new Utilisateur();
	}

	public void connect() {
		if (psw.equals(connctedUser.getMdpUtilisateur())) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("accueil.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"mot des passe incorecte", login);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void logout() {
		try {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			session.invalidate();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public UtilisateurService getUserService() {
		return userService;
	}

	public void setUserService(UtilisateurService userService) {
		this.userService = userService;
	}

	public Utilisateur getConnctedUser() {
		return connctedUser;
	}

	public void setConnctedUser(Utilisateur connctedUser) {
		this.connctedUser = connctedUser;
	}

}
