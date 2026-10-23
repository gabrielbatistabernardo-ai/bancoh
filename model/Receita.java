// Luiz Gustavo
package model;

public class Receita {

    // Atributos
    private String origem;
    private double valor;

    // Construtor Padrão (Vazio)
    public Receita() {
    }

    // Construtor com Parâmetros
    public Receita(String origem, double valor) {
        this.origem = origem;
        this.valor = valor;
    }

    // Métodos Getters e Setters
    public String getOrigem() {
        return this.origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
