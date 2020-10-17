package testes;

import modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoContaFabio {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = em.find(Conta.class, 1L);
        System.out.println("Conta do Fabio -> " + conta.getTitular());

        em.getTransaction().begin();
        conta.setSaldo(20.0);
        em.getTransaction().commit();

    }
}
