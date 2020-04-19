package Oblig3Pakke;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {
	private EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}


	public Ansatt finnAnsattMedId(int id) {
		Ansatt ut = null;

		EntityManager em = emf.createEntityManager();

		try {
			ut = em.find(Ansatt.class, id);

		} finally {
			em.close();
		}

		return ut;
	}
	
	public void skrivUtAlleAnsatte() {
		EntityManager em = emf.createEntityManager();

		try {
			Ansatt ans = em.find(Ansatt.class, 1);
			int x = 2;
			while(ans != null) {
				System.out.println(ans);
				ans = em.find(Ansatt.class, x);
				x++;
				
			}
		}
		finally {
			em.close();
		}
	}
	
	
	public void skrivUtAlleAnsattePÂAvdeling(int avdelingsID) {
		EntityManager em = emf.createEntityManager();

		try {
			Ansatt ans = em.find(Ansatt.class, 1);
			int x = 2;
			while(ans != null) {
				if(ans.getAvdeling() == avdelingsID) {
				System.out.println(ans);
				}
				ans = em.find(Ansatt.class, x);
				x++;
				
			}
		}
		finally {
			em.close();
		}
	}

	public Ansatt finnAnsattMedBruker(String brukernavn) {
		Ansatt ans = null;

		EntityManager em = emf.createEntityManager();
		String sok = "SELECT t FROM Ansatt t " + "WHERE t.Brukernavn = :brukernavn";
		try {
			TypedQuery<Ansatt> query = em.createQuery(sok, Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			ans = query.getSingleResult();
		}

		finally {
			em.close();

		}
		return ans;

	}

	public boolean leggTilAnsatt(Ansatt ansatt) {
		boolean lagttil = false;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(ansatt);
			tx.commit();
			lagttil = true;
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return lagttil;
	}

	public boolean oppdaterStilling(String stilling, int id) {
		boolean oppdatert = false;
		EntityManager em = emf.createEntityManager();
		
		try {
			Ansatt ans = em.find(Ansatt.class, id);
			em.getTransaction().begin();
			ans.setStilling(stilling);
			em.getTransaction().commit();
			oppdatert = true;
		}
		finally {
			em.close();
		}
		
		
		return oppdatert;
	}
	
	public boolean oppdaterAvdeling(int avd, int id) {
		boolean oppdatert = false;
		EntityManager em = emf.createEntityManager();
		
		try {
			Ansatt ans = em.find(Ansatt.class, id);
			Avdeling avdeling = em.find(Avdeling.class, avd);
			em.getTransaction().begin();
			ans.setAvdeling(avd);
			em.getTransaction().commit();
			oppdatert = true;
		}
		finally {
			em.close();
		}
		
		
		return oppdatert;
	}
}// Class
