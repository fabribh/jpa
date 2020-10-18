package modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@NamedQuery(name ="mediaDiariaMovimentacoes",
        query="select new modelo.MediaComData(avg(m.valor), day(m.data), month(m.data),year(m.data))" +
        " from Movimentacao m group by day(m.data), month(m.data), year(m.data)")

public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime data;
    private String descricao;
    private BigDecimal valor;

    @ManyToOne
    private Conta conta;

    @ManyToMany
    private List<Categoria> categorias = new ArrayList<>();

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "id=" + id +
                ", tipoMovimentacao=" + tipoMovimentacao +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
