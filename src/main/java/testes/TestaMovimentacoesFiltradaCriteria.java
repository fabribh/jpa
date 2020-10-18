package testes;

import modelo.Movimentacao;
import modelo.dao.MovimentacaoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestaMovimentacoesFiltradaCriteria {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        MovimentacaoDao dao = new MovimentacaoDao(em);
        List<Movimentacao> movimentacaoFiltradoPorData = dao.getMovimentacaoFiltradoPorData(null, 05, null);

        for (Movimentacao mov : movimentacaoFiltradoPorData) {
            System.out.println("Descrição: " + mov.getDescricao());
            System.out.println("Valor: " + mov.getValor());
            System.out.println("------------------------------------");
        }

    }
}
