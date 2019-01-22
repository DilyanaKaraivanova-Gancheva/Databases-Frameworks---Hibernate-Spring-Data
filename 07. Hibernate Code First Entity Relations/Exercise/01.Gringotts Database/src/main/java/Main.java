import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gringotts");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Wizzard wizzard = new Wizzard();
        wizzard.setLastName("Vasko");
        wizzard.setAge(-1);

        em.persist(wizzard);
        em.getTransaction().commit();
        em.close();
    }
}
