package banco;


 import java.util.Scanner;
/**
 *
 * @author franciele Lira
 */
public class Conta {

 private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public Conta (String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }
    
    public void consultarSaldo() {
        System.out.println("O saldo atual da sua conta é: " + saldo);
    }

    public void fazerDeposito(double valor) {
        saldo += valor; // Acresentar o valor digitado pelo cliente ao saldo. 
        System.out.println("Depósito de R$" + valor + " efetuado com sucesso!");
    }

    public void fazerSaque(double valor) {
        //se o saldo for menor ao valor digitado então:
        if (valor <= saldo) {
            saldo -= valor; // Retirar valor digitado do saldo. 
            System.out.println("Saque de R$" + valor + " efetuado com sucesso!");
        } else {
            System.out.println("Poxa, verifiquei aqui que o seu saldo é "
                    + "insuficiente para realizar o saque.");
        }
    }
    
    // Parte do cliente
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // inicializando o scanner. 

        System.out.println("Olá, Bem-vindo ao nosso Banco!");
        System.out.print("Para começar por favor Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Certo "+ nome + ". Digite também o seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Legal " + nome + " " + sobrenome + 
                ". É um prazer receber você aqui! :)");
        System.out.print("\nAgora por favor Digite seu CPF: ");
        String cpf = scanner.nextLine();
            
        Conta conta = new Conta(nome, sobrenome, cpf);

        while (true) {
            System.out.println("\n certo, para continuar escolha uma opção:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depósito");
            System.out.println("3. Saque");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt(); // ler a opção digitada pelo cliente. 
            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                   try {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.fazerDeposito(valorDeposito);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Valor de depósito está inválido. "
                                + "Certifique-se de usar o formato correto (por exemplo, 585,20).");
                        scanner.nextLine(); // Limpar o buffer do scanner
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.fazerSaque(valorSaque);
                    break;
                case 4:
                    System.out.println("Obrigada pela preferencia, será sempre um prazer atender você " + 
                            nome 
                            + ". Até breve! :) ");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção digitada está inválida. Tente novamente.");
            }
        }
}
}





