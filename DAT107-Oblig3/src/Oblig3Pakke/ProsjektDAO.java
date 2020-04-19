package Oblig3Pakke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektDAO {
	private EntityManagerFactory emf;

	public ProsjektDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}
	
	public void skrivUtAlleProsjekt() {
		EntityManager em = emf.createEntityManager();
		int i = 1;
		Prosjekt prosj = em.find(Prosjekt.class, i);
				
		while(prosj != null) {
			System.out.println(prosj);
			i++;
			prosj = em.find(Prosjekt.class, i);

		}
	}
	public void skrivUtAlleAnsattemedId(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Ansatt ans = em.find(Ansatt.class, 1);
			int i = 1;
			while(ans != null) {
				if(ans.getProsjekt() == id) {
					System.out.println(ans.toString());
				}
				i++;
				ans = em.find(Ansatt.class, i); 
			}
		}
		
		finally {
			em.close();
		}
		

	}
	
	public boolean leggTilProsjekt(Prosjekt prosj) {
		
			boolean lagttil = false;
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				em.merge(prosj);
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
