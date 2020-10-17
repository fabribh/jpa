package testes;

import modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Juliano");
        conta.setAgencia(0001);
        conta.setNumero(12345);
        conta.setSaldo(500.0);

        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();
    }
}
