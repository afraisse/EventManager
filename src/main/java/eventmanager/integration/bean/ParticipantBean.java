package eventmanager.integration.bean;

import java.util.List;

public class ParticipantBean extends AbstractBean {

	/**
	 * SerialID
	 */
	private static final long serialVersionUID = -4872909996952632899L;

	/**
	 * 
	 */
	private String nom;
	/**
	 * 
	 */
	private String prenom;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String societe;
	/**
	 * La liste des Úvenements auquels la personne participe.
	 */
	private List<EventBean> listEvents;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSociete() {
		return societe;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<EventBean> getListEvents() {
		return listEvents;
	}
	public void setListEvents(List<EventBean> listEvents) {
		this.listEvents = listEvents;
	}

}
