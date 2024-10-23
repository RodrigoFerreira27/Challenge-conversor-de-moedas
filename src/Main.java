import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double valorDigitado = 0;
        int moedaBase = 0;
        double cotacao = 0;
        double valorConvertido = 0;
        String escritaMoedaBase = "";
        String escritaMoedaConvertida = "";

        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("***** Bem-vindo ao Conversor de Moedas *****");

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1: Converter Moeda");
            System.out.println("2: Sair");
            opcao = scanner.nextInt();

            if (opcao == 1) {

                double valorMenu = 0;

                Scanner digitaMoeda = new Scanner(System.in);
                System.out.println("*****Digite a moeda a ser convertida");
                System.out.println("1 Real para Dolar");
                System.out.println("2 Dolar para Real");
                System.out.println("3 Real para peso Argentino");
                System.out.println("4 Real para Euro");
                System.out.println("5 Real para Libra");
                System.out.println("6 Real para Yuan");

                while (true) {
                    moedaBase = scanner.nextInt();
                    if (moedaBase >= 1 && moedaBase <= 6) {
                        break; // Saia do loop se a entrada for válida
                    } else {
                        System.out.println("Opção inválida, tente novamente:");
                    }
                }
                    Scanner digitaValor = new Scanner(System.in);
                    System.out.println("Digite o valor a ser convertido:");
                    valorMenu = digitaValor.nextDouble();

                    BuscaCotacao buscaCotacao = new BuscaCotacao();
                    Cotacao cotacaoAtual = buscaCotacao.buscaValor(valorMenu);

                    switch (moedaBase) {
                        case 1: // Real para Dólar
                            valorConvertido = valorMenu / cotacaoAtual.conversion_rates().BRL() * cotacaoAtual.conversion_rates().USD();
                            escritaMoedaBase = "reais";
                            escritaMoedaConvertida = "dólares";
                            break;
                        case 2: // Dólar para Real
                            valorConvertido = valorMenu / cotacaoAtual.conversion_rates().USD() * cotacaoAtual.conversion_rates().BRL();
                            escritaMoedaBase = "dólares";
                            escritaMoedaConvertida = "reais";
                            break;
                        case 3: // Real para Peso Argentino
                            valorConvertido = valorMenu / cotacaoAtual.conversion_rates().BRL() * cotacaoAtual.conversion_rates().ARS();
                            escritaMoedaBase = "reais";
                            escritaMoedaConvertida = "pesos argentinos";
                            break;
                        case 4: // Real para Euro
                            valorConvertido = valorMenu / cotacaoAtual.conversion_rates().BRL() * cotacaoAtual.conversion_rates().EUR();
                            escritaMoedaBase = "reais";
                            escritaMoedaConvertida = "euros";
                            break;
                        case 5: // Real para Libra
                            valorConvertido = valorMenu / cotacaoAtual.conversion_rates().BRL() * cotacaoAtual.conversion_rates().GBP();
                            escritaMoedaBase = "reais";
                            escritaMoedaConvertida = "libras";
                            break;
                        case 6: // Real para Yuan
                            valorConvertido = valorMenu / cotacaoAtual.conversion_rates().BRL() * cotacaoAtual.conversion_rates().CNY();
                            escritaMoedaBase = "reais";
                            escritaMoedaConvertida = "yuans";
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            return;
                }

                System.out.println(+valorMenu + " " + escritaMoedaBase + " " + " são " + valorConvertido + " " + escritaMoedaConvertida + " na cotação atual.");
            } else if (opcao != 2) {

                System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 2);

        System.out.println("Obrigado por usar o conversor de moedas! Até a próxima!");
        scanner.close();
    }
}


