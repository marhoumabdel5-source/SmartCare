package model;

public class RendezVous {
	private int id;
	private String dateRdv, heureRdv;
	private boolean disponible = true;
	private String patient = null;
	
	public RendezVous() {
		
	}
	
	public RendezVous(int id, String dateRdv, String heureRdv,
			boolean disponible,String patient) {
		this.id = id;
		this.dateRdv = dateRdv;
		this.heureRdv = heureRdv;
		this.disponible = disponible;
		this.patient = patient;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDateRdv() {
		return dateRdv;
	}


	public void setDateRdv(String dateRdv) {
		this.dateRdv = dateRdv;
	}


	public String getHeureRdv() {
		return heureRdv;
	}


	public void setHeureRdv(String heureRdv) {
		this.heureRdv = heureRdv;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public String getPatient() {
		return patient;
	}


	public void setPatient(String patient) {
		this.patient = patient;
	}
	
	
}
