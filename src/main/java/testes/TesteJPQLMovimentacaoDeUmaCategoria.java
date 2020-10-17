package testes;

import modelo.Categoria;
import modelo.Conta;
import modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQLMovimentacaoDeUmaCategoria {
    public static void main(String[] args) {

        Categoria categoria = new Categoria();
        categoria.setId(1L);

        String jpql = "select m from Movimentacao m " +
                "join m.categorias c " +
                "where c = :pCategoria";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);
        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movi : resultList) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Categorias: " + movi.getCategorias());
            System.out.println("Descrição: " + movi.getDescricao());
            System.out.println("Tipo Movimentação: " + movi.getTipoMovimentacao());
            System.out.println("Valor: " + movi.getValor());
        }

    }
}
