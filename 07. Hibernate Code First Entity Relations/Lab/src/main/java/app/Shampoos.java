package app;

import ingredients.impl.BasicIngredient;
import ingredients.models.AmmoniumChloride;
import ingredients.models.Mint;
import ingredients.models.Nettle;
import ingredients.models.Strawberry;
import shampoos.impl.BasicLabel;
import shampoos.impl.BasicShampoo;
import shampoos.interfaces.Label;
import shampoos.models.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Shampoos {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShampooCompany");
        EntityManager em = emf.createEntityManager();

        BasicIngredient sw = new Strawberry();
        BasicLabel label = new BasicLabel("AD","asd");
        em.getTransaction().begin();

        em.persist(sw);
        em.persist(label);

        BasicIngredient basicIngredient = em.find(BasicIngredient.class, 1L);
        System.out.println(basicIngredient.getName());
        em.getTransaction().commit();
        em.close();
    }
}
