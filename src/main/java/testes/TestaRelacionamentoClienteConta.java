package testes;

import modelo.Cliente;
import modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaRelacionamentoClienteConta {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(2L);

        Cliente cli = new Cliente();
        cli.setNome("Pedro");
        cli.setEndereco("Rua Jose Cleto 521");
        cli.setProfissao("Atleta Profissional");
        cli.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
        em.close();
    }
}
