package tn.ministere.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.PaysDestinationService;
import tn.ministere.dao.facade.ZoneService;

import tn.ministere.entity.Fonction;
import tn.ministere.entity.PaysDestination;
import tn.ministere.entity.Zone;

@ManagedBean
@Component
@URLMapping(id="pays",pattern="/edit_pays.xhtml",viewId="/edit/edit_pays.xhtml")

public class PaysDestinationManagedBean implements Serializable {

	private PaysDestination selectedPaysDestination;
	private Zone zone;
	private List<Zone> zones;
	private List<PaysDestination> paysDestinations;
	private PaysDestination paysdestination;

	@Autowired
	private ZoneService zoneService;
	@Autowired
	private PaysDestinationService paysdestinationService;

	@PostConstruct
	public void init() {

		zone = new Zone();
		zones = zoneService.findAll();

		paysdestination = new PaysDestination();
		selectedPaysDestination = new PaysDestination();

		paysDestinations = paysdestinationService.findAll();

	}

	public void add() {

		System.out.println(paysdestination.getCodePaysDes());

		Zone z = zoneService.findById(zone.getCodeZone());

		paysdestination.setZone(z);

		paysdestinationService.add(paysdestination);
		paysdestination = new PaysDestination();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"pays ajouté avec succée", null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void delete() {
		paysdestinationService.delete(paysdestinationService
				.findById(selectedPaysDestination.getCodePaysDes()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("paysdestination.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_pays.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		paysdestinationService.update(selectedPaysDestination);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("paysdestination.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PaysDestination getPaysDestination() {
		return paysdestination;
	}

	public void setPaysDestination(PaysDestination paysdestination) {
		this.paysdestination = paysdestination;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<PaysDestination> getPaysDestinations() {
		return paysDestinations;
	}

	public void setPaysDestinations(List<PaysDestination> paysDestinations) {
		this.paysDestinations = paysDestinations;
	}

	public PaysDestination getSelectedPaysDestination() {
		return selectedPaysDestination;
	}

	public void setSelectedPaysDestination(
			PaysDestination selectedPaysDestination) {
		this.selectedPaysDestination = selectedPaysDestination;
	}

}