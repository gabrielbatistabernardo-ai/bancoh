// Max e Yudy
package model;

public class Conta {

    private int numero;
    private String cliente;
    private double saldo;
    private double limite;

    // Construtor Padrão (Vazio)
    public Conta() {
    }

    // Construtor com Parâmetros
    public Conta(int numero, String cliente, double saldo, double limite) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limite = limite;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    // O método setSaldo() foi removido para proteger o saldo (Encapsulamento)

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    // --- MÉTODOS DE COMPORTAMENTO DA CONTA ---

    // Aumenta o saldo da conta
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso na conta de " + cliente + "!");
        } else {
            System.out.println("Erro: O valor do depósito deve ser positivo.");
        }
    }

    // Valida se o valor respeita a soma do saldo + limite
    public boolean sacar(double valor) {
        if (this.saldo + this.limite >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso na conta de " + cliente + "!");
            return true;
        } else {
            System.out.println("Erro: Saldo e limite insuficientes para o saque de R$ " + valor + " na conta de " + cliente + ".");
            return false;
        }
    }

    // Efetua o débito na conta e altera o status da despesa para "Paga"
    public boolean pagarDespesa(Despesa despesa) {
        if (despesa.isPaga()) {
            System.out.println("A despesa '" + despesa.getDescricao() + "' já foi paga.");
            return false;
        }

        if (this.saldo + this.limite >= despesa.getValor()) {
            this.saldo -= despesa.getValor();
            despesa.marcarComoPaga();
            System.out.println("Despesa '" + despesa.getDescricao() + "' de R$ " + despesa.getValor() + " paga com sucesso por " + cliente + "!");
            return true;
        } else {
            System.out.println("Erro: Saldo e limite insuficientes para pagar a despesa '" + despesa.getDescricao() + "'.");
            return false;
        }
    }

    // Transfere o valor do saldo da conta para a meta, se houver saldo/limite
    public boolean poupar(Meta meta, double valor) {
        if (this.saldo + this.limite >= valor) {
            this.saldo -= valor;
            meta.setValorPoupado(meta.getValorPoupado() + valor);
            System.out.println("Valor de R$ " + valor + " poupado com sucesso para a meta '" + meta.getDescricao() + "'!");
            return true;
        } else {
            System.out.println("Erro: Saldo e limite insuficientes para poupar R$ " + valor + ".");
            return false;
        }
    }
}
