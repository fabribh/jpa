package testes;

import modelo.Conta;
import modelo.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1L);

        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movi : resultList) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Descrição: " + movi.getDescricao());
            System.out.println("Tipo Movimentação: " + movi.getTipoMovimentacao());
            System.out.println("Valor: " + movi.getValor());
        }

    }
}
