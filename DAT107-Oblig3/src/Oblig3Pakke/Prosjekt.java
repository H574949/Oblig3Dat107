package Oblig3Pakke;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prosjekt", schema = "DAT107Oblig3_jpa")


	
public class Prosjekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)


	private int ID;
	private String prosjektNavn;
	private String prosjektBeskrivelse;
	private int antallTimer;
	
	
	public Prosjekt() {
		ID = 0;
		prosjektNavn = null;
		prosjektBeskrivelse = null;
		antallTimer = 0;
	}
	
	public Prosjekt(int iD, String prosjektNavn, String prosjektBeskrivelse, int antallTimer) {
		super();
		ID = iD;
		this.prosjektNavn = prosjektNavn;
		this.prosjektBeskrivelse = prosjektBeskrivelse;
		this.antallTimer = antallTimer;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	public String getProsjektNavn() {
		return prosjektNavn;
	}


	public void setProsjektNavn(String prosjektNavn) {
		this.prosjektNavn = prosjektNavn;
	}




	public String getProsjektBeskrivelse() {
		return prosjektBeskrivelse;
	}




	public void setProsjektBeskrivelse(String prosjektBeskrivelse) {
		this.prosjektBeskrivelse = prosjektBeskrivelse;
	}




	public int getAntallTimer() {
		return antallTimer;
	}




	public void setAntallTimer(int antallTimer) {
		this.antallTimer = antallTimer;
	}


	public void okAntallTimer(int timer) {
		antallTimer = antallTimer+timer;
	}

	@Override
	public String toString() {
		return "Prosjekt [ID=" + ID + ", prosjektNavn=" + prosjektNavn + ", prosjektBeskrivelse=" + prosjektBeskrivelse
				+ ", antallTimer=" + antallTimer + "]";
	}
	
	
}
