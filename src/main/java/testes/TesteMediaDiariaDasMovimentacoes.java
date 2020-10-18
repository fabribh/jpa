package testes;

import modelo.MediaComData;
import modelo.dao.MovimentacaoDao;

import javax.persistence.*;
import java.util.List;

public class TesteMediaDiariaDasMovimentacoes {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimentacoes();
        for (MediaComData resultado : mediaDasMovimentacoes) {
            System.out.println("A média de movimentações do dia " + resultado.getDia() + "/"
                    + resultado.getMes() + "/" + resultado.getAno() + " é: " + resultado.getValor());
        }

    }
}
