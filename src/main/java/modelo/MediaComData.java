package modelo;

public class MediaComData {

    private Double valor;
    private Integer dia;
    private Integer mes;
    private Integer ano;

    public MediaComData(Double valor, Integer dia, Integer mes, Integer ano) {
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAno() {
        return ano;
    }
}
