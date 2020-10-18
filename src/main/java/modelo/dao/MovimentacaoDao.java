package modelo.dao;

import modelo.MediaComData;
import modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    public List<Movimentacao> getMovimentacaoFiltradoPorData(Integer dia, Integer mes, Integer ano) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);

        Root<Movimentacao> root = query.from(Movimentacao.class);

        List<Predicate> predicates = new ArrayList<>();

        if (dia != null) {
            // day(m.data)
            Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
            predicates.add(predicate);
        }

        if (mes != null) {
            // month(m.data)
            Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
            predicates.add(predicate);
        }

        if (ano != null) {
            // year(m.data)
            Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
            predicates.add(predicate);
        }

        query.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Movimentacao> typedQuery = em.createQuery(query);

        return typedQuery.getResultList();
    }
}
