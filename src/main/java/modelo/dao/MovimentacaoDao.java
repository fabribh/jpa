package modelo.dao;

import modelo.MediaComData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentacaoDao {
    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<MediaComData> getMediaDiariaDasMovimentacoes() {
        TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
        return query.getResultList();
    }

    public BigDecimal getSomaDasMovimentacoes() {
        String jpql = "select sum(m.valor) from Movimentacao m";
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        return query.getSingleResult();
    }

    public Double getMediaDasMovimentacoes() {
        String jpqlMedia = "select avg(m.valor) from Movimentacao m";
        TypedQuery<Double> queryMedia = em.createQuery(jpqlMedia, Double.class);
        return queryMedia.getSingleResult();
    }
}
