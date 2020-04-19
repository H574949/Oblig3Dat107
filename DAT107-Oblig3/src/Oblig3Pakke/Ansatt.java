package Oblig3Pakke;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ansatt", schema = "DAT107Oblig3_jpa")

public class Ansatt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String Fornavn;
	private String Etternavn;
	private String Brukernavn;
	private LocalDate DatoAnsatt; // DDMMYYYY
	private String Stilling;
	private int Lonn;
	private int Avdeling;
	private int Prosjekt;
	private String ProsjektsRolle;
	private int ProsjektTimer;

	

	
	public Ansatt() {
		Fornavn = null;
		Etternavn = null;
		Brukernavn = null;
		DatoAnsatt = null;
		Stilling = null;
		Lonn = -1;
		Avdeling = 0;
		Prosjekt = 0;
		ProsjektsRolle = null;
		ProsjektTimer = 0;
		
	}




	public Ansatt(int iD, String fornavn, String etternavn, String brukernavn, LocalDate datoAnsatt, String stilling,
			int lonn, int avdeling, int prosjekt, String prosjektsRolle, int prosjektTimer) {
		super();
		ID = iD;
		Fornavn = fornavn;
		Etternavn = etternavn;
		Brukernavn = brukernavn;
		DatoAnsatt = datoAnsatt;
		Stilling = stilling;
		Lonn = lonn;
		Avdeling = avdeling;
		Prosjekt = prosjekt;
		ProsjektsRolle = prosjektsRolle;
		ProsjektTimer = prosjektTimer;
	}




	public int getID() {
		return ID;
	}




	public void setID(int iD) {
		ID = iD;
	}




	public String getFornavn() {
		return Fornavn;
	}




	public void setFornavn(String fornavn) {
		Fornavn = fornavn;
	}




	public String getEtternavn() {
		return Etternavn;
	}




	public void setEtternavn(String etternavn) {
		Etternavn = etternavn;
	}




	public String getBrukernavn() {
		return Brukernavn;
	}




	public void setBrukernavn(String brukernavn) {
		Brukernavn = brukernavn;
	}




	public LocalDate getDatoAnsatt() {
		return DatoAnsatt;
	}




	public void setDatoAnsatt(LocalDate datoAnsatt) {
		DatoAnsatt = datoAnsatt;
	}




	public String getStilling() {
		return Stilling;
	}




	public void setStilling(String stilling) {
		Stilling = stilling;
	}




	public int getLonn() {
		return Lonn;
	}




	public void setLonn(int lonn) {
		Lonn = lonn;
	}




	public int getAvdeling() {
		return Avdeling;
	}




	public void setAvdeling(int avdeling) {
		Avdeling = avdeling;
	}




	public int getProsjekt() {
		return Prosjekt;
	}




	public void setProsjekt(int prosjekt) {
		Prosjekt = prosjekt;
	}




	public String getProsjektsRolle() {
		return ProsjektsRolle;
	}




	public void setProsjektsRolle(String prosjektsRolle) {
		ProsjektsRolle = prosjektsRolle;
	}




	public int getProsjektTimer() {
		return ProsjektTimer;
	}




	public void setProsjektTimer(int prosjektTimer) {
		ProsjektTimer = prosjektTimer;
	}




	@Override
	public String toString() {
		return "Ansatt [ID=" + ID + ", Fornavn=" + Fornavn + ", Etternavn=" + Etternavn + ", Brukernavn=" + Brukernavn
				+ ", DatoAnsatt=" + DatoAnsatt + ", Stilling=" + Stilling + ", Lonn=" + Lonn + ", Avdeling=" + Avdeling
				+ ", Prosjekt=" + Prosjekt + ", ProsjektsRolle=" + ProsjektsRolle + ", ProsjektTimer=" + ProsjektTimer
				+ "]";
	}



	

}
