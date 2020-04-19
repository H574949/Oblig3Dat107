package Oblig3Pakke;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class klientTest {
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");

		EntityManager em = emf.createEntityManager();
		
		AnsattDAO dao = new AnsattDAO();
		AvdelingDAO daoAvd = new AvdelingDAO();
		System.out.println(em.find(Ansatt.class, 3));
		Avdeling avd = new Avdeling();
		avd.setAvdelingsNavn("Badebaseng Avdeling");
		avd.setSjefID(3);
		daoAvd.leggTilAvdeling(avd,3);
		System.out.println(em.find(Ansatt.class, 3));
		System.out.println(em.find(Avdeling.class, 3));
		
		ProsjektDAO pdao = new ProsjektDAO();
		pdao.skrivUtAlleAnsattemedId(1);
		pdao.skrivUtAlleProsjekt();
		
		
		
		//
//		t(String fornavn, String etternavn, String brukernavn, LocalDate datoAnsatt, String stilling,
//				int lonn, String avdeling, String prosjekt)
		//TypedQuery<Ansatt> query = em.createQuery(
		//SELECT t FROM Ansatt t WHERE t.Brukernavn = :brukernavn", Ansatt.class);
		
	

	}
}
