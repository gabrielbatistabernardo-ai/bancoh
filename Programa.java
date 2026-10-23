import java.util.Scanner;
import model.Conta;
import model.Despesa;
import model.Meta;
import model.Receita;

public class Programa {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=== CADASTRO DE CONTAS ===");

        // Cadastro da Conta 1
        System.out.println("\n--- Conta 1 ---");
        System.out.print("Número da Conta: ");
        int num1 = entrada.nextInt();
        entrada.nextLine(); // Consumir quebra de linha
        System.out.print("Nome do Cliente: ");
        String cliente1 = entrada.nextLine();
        System.out.print("Saldo Inicial: R$ ");
        double saldo1 = entrada.nextDouble();
        System.out.print("Limite de Crédito: R$ ");
        double limite1 = entrada.nextDouble();
        entrada.nextLine();

        Conta conta1 = new Conta(num1, cliente1, saldo1, limite1);

        // Cadastro da Conta 2
        System.out.println("\n--- Conta 2 ---");
        System.out.print("Número da Conta: ");
        int num2 = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Nome do Cliente: ");
        String cliente2 = entrada.nextLine();
        System.out.print("Saldo Inicial: R$ ");
        double saldo2 = entrada.nextDouble();
        System.out.print("Limite de Crédito: R$ ");
        double limite2 = entrada.nextDouble();
        entrada.nextLine();

        Conta conta2 = new Conta(num2, cliente2, saldo2, limite2);

        // Cadastro de Receita
        System.out.println("\n=== CADASTRO DE RECEITA ===");
        System.out.print("Origem da Receita: ");
        String origemReceita = entrada.nextLine();
        System.out.print("Valor da Receita: R$ ");
        double valorReceita = entrada.nextDouble();
        entrada.nextLine();

        Receita receita1 = new Receita(origemReceita, valorReceita);

        // Cadastro de 3 Despesas
        System.out.println("\n=== CADASTRO DE DESPESAS ===");
        
        System.out.print("Descrição Despesa 1: ");
        String d1Desc = entrada.nextLine();
        System.out.print("Valor Despesa 1: R$ ");
        double d1Valor = entrada.nextDouble();
        entrada.nextLine();
        Despesa despesa1 = new Despesa(d1Desc, d1Valor);

        System.out.print("Descrição Despesa 2: ");
        String d2Desc = entrada.nextLine();
        System.out.print("Valor Despesa 2: R$ ");
        double d2Valor = entrada.nextDouble();
        entrada.nextLine();
        Despesa despesa2 = new Despesa(d2Desc, d2Valor);

        System.out.print("Descrição Despesa 3: ");
        String d3Desc = entrada.nextLine();
        System.out.print("Valor Despesa 3: R$ ");
        double d3Valor = entrada.nextDouble();
        entrada.nextLine();
        Despesa despesa3 = new Despesa(d3Desc, d3Valor);

        // Cadastro de Meta
        System.out.println("\n=== CADASTRO DE META ===");
        System.out.print("Objetivo da Meta: ");
        String objetivoMeta = entrada.nextLine();
        System.out.print("Valor Alvo da Meta: R$ ");
        double valorAlvoMeta = entrada.nextDouble();

        Meta meta1 = new Meta(objetivoMeta, valorAlvoMeta);

        // --- EXECUÇÃO DE OPERAÇÕES ---
        System.out.println("\n=== EXECUTANDO OPERAÇÕES FINANCEIRAS ===");

        // Depositar Receita na Conta 1
        System.out.print("\nDeseja depositar a receita '" + receita1.getOrigem() + "' na Conta 1? (1-Sim / 2-Não): ");
        if (entrada.nextInt() == 1) {
            conta1.depositar(receita1.getValor());
        }

        // Pagar Despesas (usando os métodos encapsulados da classe Conta)
        System.out.print("\nDeseja pagar a despesa [" + despesa1.getDescricao() + "] na Conta 1? (1-Sim / 2-Não): ");
        if (entrada.nextInt() == 1) {
            conta1.pagarDespesa(despesa1);
        }

        System.out.print("\nDeseja pagar a despesa [" + despesa2.getDescricao() + "] na Conta 1? (1-Sim / 2-Não): ");
        if (entrada.nextInt() == 1) {
            conta1.pagarDespesa(despesa2);
        }

        System.out.print("\nDeseja pagar a despesa [" + despesa3.getDescricao() + "] na Conta 2? (1-Sim / 2-Não): ");
        if (entrada.nextInt() == 1) {
            conta2.pagarDespesa(despesa3);
        }

        // Poupar para a Meta
        System.out.print("\nDigite o valor que deseja poupar da Conta 1 para a Meta [" + meta1.getObjetivo() + "]: R$ ");
        double valorPoupar = entrada.nextDouble();
        conta1.poupar(meta1, valorPoupar);

        // --- RELATÓRIO FINAL ---
        System.out.println("\n========================================");
        System.out.println("          RELATÓRIO FINANCEIRO          ");
        System.out.println("========================================");

        System.out.println("\n[ SITUAÇÃO DAS CONTAS ]");
        System.out.printf("Conta %d (%s): Saldo = R$ %.2f | Limite = R$ %.2f | Disponível = R$ %.2f\n",
                conta1.getNumero(), conta1.getCliente(), conta1.getSaldo(), conta1.getLimite(), (conta1.getSaldo() + conta1.getLimite()));
        System.out.printf("Conta %d (%s): Saldo = R$ %.2f | Limite = R$ %.2f | Disponível = R$ %.2f\n",
                conta2.getNumero(), conta2.getCliente(), conta2.getSaldo(), conta2.getLimite(), (conta2.getSaldo() + conta2.getLimite()));

        System.out.println("\n[ STATUS DAS DESPESAS ]");
        System.out.printf("- %s: R$ %.2f [%s]\n", despesa1.getDescricao(), despesa1.getValor(), despesa1.getStatus());
        System.out.printf("- %s: R$ %.2f [%s]\n", despesa2.getDescricao(), despesa2.getValor(), despesa2.getStatus());
        System.out.printf("- %s: R$ %.2f [%s]\n", despesa3.getDescricao(), despesa3.getValor(), despesa3.getStatus());

        System.out.println("\n[ PROGRESSO DAS METAS ]");
        double percentual = (meta1.getValorPoupado() / meta1.getValorAlvo()) * 100;
        System.out.printf("Meta [%s]: R$ %.2f poupados de R$ %.2f (%.1f%% concluído)\n",
                meta1.getObjetivo(), meta1.getValorPoupado(), meta1.getValorAlvo(), percentual);

        System.out.println("========================================");

        entrada.close();
    }
}
