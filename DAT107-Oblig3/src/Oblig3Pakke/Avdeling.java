package Oblig3Pakke;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Avdeling", schema = "DAT107Oblig3_jpa")

public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String AvdelingsNavn;
	private int sjefID;
	
	
	public Avdeling()  {
		ID = 0;
		AvdelingsNavn = null;
		this.sjefID = 0;
	}
	
	public Avdeling(int iD, String avdelingsNavn, int sjefID) {
		super();
		ID = iD;
		AvdelingsNavn = avdelingsNavn;
		this.sjefID = sjefID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAvdelingsNavn() {
		return AvdelingsNavn;
	}
	public void setAvdelingsNavn(String avdelingsNavn) {
		AvdelingsNavn = avdelingsNavn;
	}
	public int getSjefID() {
		return sjefID;
	}
	public void setSjefID(int sjefID) {
		this.sjefID = sjefID;
	}
	@Override
	public String toString() {
		return "Avdeling [ID=" + ID + ", AvdelingsNavn=" + AvdelingsNavn + ", sjefID=" + sjefID + "]";
	}
	
	
	
	
	
	
	

}
