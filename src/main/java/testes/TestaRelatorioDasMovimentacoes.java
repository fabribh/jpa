package testes;

import modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestaRelatorioDasMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
        TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

        List<Conta> contas = query.getResultList();
        for (Conta conta: contas) {
            System.out.println("Conta: " + conta.getTitular());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Número: " + conta.getNumero());
            System.out.println("Movimentações: " + conta.getMovimentacoes());
        }
    }
}
