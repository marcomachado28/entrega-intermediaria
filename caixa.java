import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CaixaEletronico {

    public static void buscarCEP(String cep) {

        try {

            String urlString =
                    "https://viacep.com.br/ws/" + cep + "/json/";

            URL url = new URL(urlString);

            HttpURLConnection conexao =
                    (HttpURLConnection) url.openConnection();

            conexao.setRequestMethod("GET");

            BufferedReader leitor =
                    new BufferedReader(
                            new InputStreamReader(
                                    conexao.getInputStream()
                            )
                    );

            String linha;
            StringBuilder resposta = new StringBuilder();

            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }

            leitor.close();

            System.out.println("\nDados do CEP:");
            System.out.println(resposta);

        } catch (Exception e) {
            System.out.println("Erro ao consultar CEP.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double saldo = 500.00;
        int opcao;

        do {

            System.out.println("\n----- Caixa Eletrônico -----\n");

            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Consultar CEP");
            System.out.println("5 - Sair");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    System.out.printf(
                            "\nSeu saldo atual é: R$%.2f\n",
                            saldo
                    );

                    break;

                case 2:

                    System.out.print(
                            "Digite o valor para depósito: R$ "
                    );

                    double deposito = scanner.nextDouble();

                    if (deposito > 0) {

                        saldo += deposito;

                        System.out.println(
                                "Depósito realizado com sucesso!"
                        );

                    } else {

                        System.out.println("Valor inválido.");
                    }

                    break;

                case 3:

                    System.out.print(
                            "Digite o valor para saque: R$ "
                    );

                    double saque = scanner.nextDouble();

                    if (saque > 0 && saque <= saldo) {

                        saldo -= saque;

                        System.out.println(
                                "Saque realizado com sucesso!"
                        );

                    } else {

                        System.out.println(
                                "Saldo insuficiente ou valor inválido."
                        );
                    }

                    break;

                case 4:

                    System.out.print("Digite o CEP: ");

                    String cep = scanner.next();

                    buscarCEP(cep);

                    break;

                case 5:

                    System.out.println(
                            "Obrigado por usar o caixa eletrônico!"
                    );

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}