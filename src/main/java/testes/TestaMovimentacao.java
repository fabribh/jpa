package testes;

import modelo.Conta;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaMovimentacao {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Pedro");
        conta.setAgencia(0001);
        conta.setNumero(463152);
        conta.setSaldo(300.0);

        Movimentacao mov = new Movimentacao();
        mov.setData(LocalDateTime.now());
        mov.setDescricao("Churrascaria");
        mov.setValor(new BigDecimal(200.0));
        mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        mov.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(mov);
        em.getTransaction().commit();

        em.close();
    }
}
