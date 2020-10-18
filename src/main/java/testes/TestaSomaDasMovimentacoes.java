package testes;

import modelo.dao.MovimentacaoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TestaSomaDasMovimentacoes {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        BigDecimal somaDasMovimentacoes = new MovimentacaoDao(em).getSomaDasMovimentacoes();
        Double mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDasMovimentacoes();

        System.out.println("A soma das movimentações é: " + somaDasMovimentacoes);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("A média das movimentações é: " + mediaDasMovimentacoes);

    }

}
