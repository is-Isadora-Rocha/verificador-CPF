package LógicaProgramação;
import java.util.Scanner;
public class VerificaCPF {
    //ISADORA ROCHA DA SILVA 1-2022122994
    public static void main(String[] args) {
        System.out.println("BEM VINDO AO VERIFICADOR DE CADASTRO DE PESSOA FÍSICA (CPF)!");
        telaDeMenu(); //CHAMAR O MÉTODO TELA DE MENU
    }
    public static void telaDeMenu() {
        //VARIÁVEIS DE MENU
        Scanner menu = new Scanner(System.in);
        int opcao = 0;

        //TELA DE MENU
        do {
            System.out.println("\nEscolha umas das opções abaixo da tela de menu: ");
            System.out.println("\t---- TELA DE MENU ----\nOpção [1]: VERIFICADOR DO DIGÍTO DO CPF. \nOpção [2]: INFORMAÇÕES DO DESENVOLVEDOR. \nOpção [3]: SAIR DO ALGORITMO.");
            opcao = menu.nextInt(); //RECEBE A OPÇÃO DO USUÁRIO

            //RECEBE O CPF
            if (opcao == 1) {
                System.out.println("OPÇÃO 1 SELECIONADO: VERFIFICAR DIGÍTOS DO CPF.\nPor favor, digite SOMENTE os 9 números do CPF: ");
                validaCpf(); //CHAMA O MÉTODO PARA VALIDAR O CPF
            }

            //INFORMAÇÕES DO DESENVOLVEDOR
            else if (opcao == 2) {
                System.out.println("OPÇÃO 2 SELECIONADO: INFORMAÇÕES DO DESENVOLVEDOR.\nALUNO(A): Isadora Rocha da Silva\nMATRÍCULA: 1-2022122994\nINSTITUIÇÃO: Unifametro Fortaleza");
                telaDeMenu(); //RETORNA A TELA DE MENU
            }

            //SAÍDA DO ALGORITMO
            else if (opcao == 3) {
                System.out.println("OPÇÃO 3: SAIR DO ALGORITMO.\nATÉ LOGO!");
            }
            //OPÇÃO INVÁLIDA
            else if (opcao != 1 && opcao != 2 && opcao != 3) {
                System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE"); //EXIBIR MENSAGEM DE ERRO
                telaDeMenu(); //RETORNA A TELA DE MENU
            }
        }
        while (opcao != 1 && opcao != 2 && opcao != 3); //OPÇÕES INVÁLIDAS
    }


    //VERIFICAR SE O CPF FOI DIGITADO CORRETAMENTE
    public static boolean validaCpf() {

        Scanner scan = new Scanner(System.in);
        String cpfEmTexto = scan.nextLine();
        boolean cpfValido = true;

        //CPF DIGITADO CORRETAMENTE;
        if (cpfEmTexto.length() == 9) {  //TAMANHO DA STRING (.length)
            System.out.println("O seu CPF é: " + cpfEmTexto+ "\n");

            //VARIÁVEL(cpf) OBTÉM UM TIPO INT DE UMA STRING
            int cpf = Integer.parseInt(cpfEmTexto);

            //CHAMA O MÉTODO CALCULAR O DIGITO 1
            calcularDigito(cpfEmTexto);
        }

        //ERRO NO CPF (digitos < 9 < digitos)
        else if (cpfEmTexto.length() != 9) {
            System.out.println("CPF inválido! Por favor, digite novamente.");
            validaCpf(); //RETORNA PARA DIGITAR O CPF NOVAMENTE
        }

        //ERRO NO CPF (LETRAS)
        else if (cpfEmTexto.substring(0, 10).matches("[A-a-Z-z]*")) {
            System.out.println("CPF inválido! Por favor, digite novamente.");
            validaCpf(); //RETORNA PARA DIGITAR O CPF NOVAMENTE

            //(.substring) RETOMA O VALOR DAS POSIÇÕES, INICIAL E FINAL, RESPECTIVAMENTE
            //(.matches) LOCALIZA O OBJETO NA STRING

        }
        return cpfValido = false;
    }

    //CONTADOR DO PRIMEIRO DÍGITO
    public static void calcularDigito(String cpfEmTexto) {    //MÉTODO QUE RECEBE O CPF QUE O USUÁRIO DIGITOU
        System.out.println("CONTADOR DO PRIMEIRO DÍGITO: ");
        int soma = 0;
        int valorTotalD1;
        int digitoCpf = 0;
        int auxiliar = 11;

        for (int i = 0; i < cpfEmTexto.length(); i++) {
            digitoCpf = Character.getNumericValue(cpfEmTexto.charAt(i));
            auxiliar--;
//            System.out.println(digitoCpf + " * " + auxiliar + " = " + (digitoCpf * (auxiliar)));
            soma = (digitoCpf * (auxiliar)) + soma;

        } //fora do loop

        System.out.println("A soma dos digitos é: " + soma + "\n");
        valorTotalD1  = (10 * soma) % 11;
        System.out.println("O seu PRIMEIRO digito verificador é: " + valorTotalD1+ "\n");


        //CONTADOR DO SEGUNDO DÍGITO
        System.out.println("CONTADOR DO SEGUNDO DÍGITO: ");
        int soma2 = 0, valorTotalD2;
        int auxiliar2 = 12;
        for (int i = 0; i < cpfEmTexto.length(); i++) {
            digitoCpf = Character.getNumericValue(cpfEmTexto.charAt(i));
            auxiliar2--;
//            System.out.println(digitoCpf + " * " + auxiliar2 + " = " + (digitoCpf * (auxiliar2)));
            soma2 = ((digitoCpf * auxiliar2) + soma2);

        } //fora do loop

        System.out.println("A soma dos digitos é: " + soma2 + "\n"); //EXIBIR RESULTADO DA SOMA

        valorTotalD2 = (((valorTotalD1 * 2) + soma2) * 10) % 11;
        System.out.println("O seu SEGUNDO digito verificador é: " + valorTotalD2+ "\n");

        System.out.println("O seu CPF completo é: " +cpfEmTexto+ "-" +valorTotalD1+ valorTotalD2);

    }
}
//######O CALCULO DO CPF OCULTADO DO USUÁRIO########//

// EXEMPLO: O CPF DIGITADO FOI: 147852369
//    CONTADOR DO PRIMEIRO DÍGITO:
//        1 * 10 = 10
//        4 * 9 = 36
//        7 * 8 = 56
//        8 * 7 = 56
//        5 * 6 = 30
//        2 * 5 = 10
//        3 * 4 = 12
//        6 * 3 = 18
//        9 * 2 = 18
//        A soma dos digitos é: 246
//
//        O seu PRIMEIRO digito verificador é: 7
//
//        CONTADOR DO SEGUNDO DÍGITO:
//        1 * 11 = 11
//        4 * 10 = 40
//        7 * 9 = 63
//        8 * 8 = 64
//        5 * 7 = 35
//        2 * 6 = 12
//        3 * 5 = 15
//        6 * 4 = 24
//        9 * 3 = 27
//        A soma dos digitos é: 291
//
//        O seu SEGUNDO digito verificador é: 3
//
//        O seu CPF completo é: 147852369-73