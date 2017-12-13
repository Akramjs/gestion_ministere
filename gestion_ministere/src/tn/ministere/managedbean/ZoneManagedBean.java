package tn.ministere.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import tn.ministere.dao.facade.ZoneService;

import tn.ministere.entity.Zone;


@ManagedBean
@Component
@URLMapping(id="zone",pattern="/edit_zones.xhtml",viewId="/edit/edit_zones.xhtml")

public class ZoneManagedBean {
	private List<Zone> listZones;
	private Zone newZone;
	private Zone selectedZone;

	@Autowired
	private ZoneService zoneService;

	@PostConstruct
	public void init() {
		newZone = new Zone();
		selectedZone = new Zone();
		listZones = zoneService.findAll();
	}

	public void add() {
		System.out.println(newZone.getCodeZone());
		zoneService.add(newZone);
		newZone = new Zone();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("zone.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		zoneService.delete(zoneService.findById(selectedZone
				.getCodeZone()));
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("zone.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void goToEdit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("edit_zones.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		zoneService.update(selectedZone);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("zone.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Zone> getListZones() {
		return zoneService.findAll();
	}

	public void setListZones(List<Zone> listZones) {
		this.listZones = listZones;
	}

	public ZoneService getZoneService() {
		return zoneService;
	}

	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	public Zone getNewZone() {
		return newZone;
	}

	public void setNewZone(Zone newZone) {
		this.newZone = newZone;
	}

	public Zone getSelectedZone() {
		return selectedZone;
	}

	public void setSelectedZone(Zone selectedZone) {
		this.selectedZone = selectedZone;
	}

}
