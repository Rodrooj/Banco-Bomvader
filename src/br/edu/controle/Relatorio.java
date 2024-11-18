package br.edu.controle;

import java.time.LocalDate;
import java.util.List;

public class Relatorio {
    private String tipo;
    private LocalDate dataGeracao;
    private List<String> dados;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public List<String> getDados() {
        return dados;
    }

    public void setDados(List<String> dados) {
        this.dados = dados;
    }

    void gerarRelatorioGeral() {

    }

    void exportarParaExcel() {

    }
}
