package Oblig3Pakke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AvdelingDAO {
	private EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}

	public Avdeling finnAvdelingMedId(int id) {
		Avdeling ut = null;

		EntityManager em = emf.createEntityManager();

		try {
			ut = em.find(Avdeling.class, id);

		} finally {
			em.close();
		}

		return ut;
	}

	public boolean leggTilAvdeling(Avdeling avd, int sjefID) {

		boolean lagttil = false;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Avdeling temp = em.find(Avdeling.class, 1);
		int teller = 1;

		while (temp != null) {
			teller++;
			String navn = temp.getAvdelingsNavn();
			if (avd.getAvdelingsNavn().equals(navn))
				return false;
			temp = em.find(Avdeling.class, teller);
		}

		Avdeling avdel = em.find(Avdeling.class, 1);
		int id = 1;

		if (avd.getID() == 0) {

			while (avdel != null) {
				id++;
				avdel = em.find(Avdeling.class, id);
			}
			avd.setID(id);
		}
		

		try {
			tx.begin();
			em.merge(avd);
			tx.commit();

			Ansatt ans = em.find(Ansatt.class, sjefID);
			ans.setAvdeling(id);
			
			tx.begin();
			em.merge(ans);
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

}
