package testes;

import modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Pedro");
        conta.setAgencia(0001);
        conta.setNumero(254268);

        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();
    }
}
