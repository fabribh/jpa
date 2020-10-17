package testes;

import modelo.Categoria;
import modelo.Conta;
import modelo.Movimentacao;
import modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TesteRelacionamentoMovimentacaoCategoria {
    public static void main(String[] args) {
        Categoria c1 = new Categoria("Viagem");
        Categoria c2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setId(1L);

        Movimentacao mov = new Movimentacao();
        mov.setDescricao("Viagem à SP");
        mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        mov.setData(LocalDateTime.now());
        mov.setValor(new BigDecimal(300.0));
        mov.setCategorias(Arrays.asList(c1, c2));
        mov.setConta(conta);

        Movimentacao mov2 = new Movimentacao();
        mov2.setDescricao("Viagem à BH");
        mov2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        mov2.setData(LocalDateTime.now());
        mov2.setValor(new BigDecimal(400.0));
        mov2.setCategorias(Arrays.asList(c1, c2));
        mov2.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(mov);
        em.persist(mov2);
        em.getTransaction().commit();
        em.close();
    }
}
