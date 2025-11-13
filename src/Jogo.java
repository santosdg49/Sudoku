import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private static SolverSudoku  solver =  new SolverSudoku();
    private static ArquivoSudoku arquivo =  new ArquivoSudoku();

    public void Menu(Scanner sc) {
        int escolha;

        System.out.println("Bem vindo ao Sudoku!");
        System.out.println("Escolha uma dessas opções:");
        System.out.println("1. Novo jogo\n2. Carregar jogo\n3. Sair");
        System.out.print("Escolha: ");
        escolha = sc.nextInt();
        System.out.println();

        switch (escolha) {
            case 1:
                iniciarNovoJogo();
                break;

            case 2:
                CarregarJogo();
                break;

            case 3:
                System.out.println("Encerrando...");
                return;
        }


    }

    public void iniciarNovoJogo() {
        Scanner sc = new Scanner(System.in);
        int numero;
        int escolha;
        int linha;
        int coluna;
        this.tabuleiro = new Tabuleiro();

        System.out.println("Iniciando novo jogo\n");
        tabuleiro.imprimir_tabuleiro();
        System.out.println();


        while (!tabuleiro.Completo()) {

            System.out.println("1. Inserir numero\n2. Salvar jogo e sair\n3. Preencher tabuleiro");
            System.out.print("Escolha: ");
            escolha = sc.nextInt();
            System.out.println();

            switch(escolha) {
                case 1:

                    System.out.print("Escolha um número de 1 a 9: ");
                    numero = sc.nextInt();

                    System.out.println("Insira a posição em que deseja inserir");
                    System.out.print("Insira a linha: ");
                    linha = sc.nextInt();
                    System.out.print("Insira a coluna: ");
                    coluna = sc.nextInt();
                    System.out.println();

                    tabuleiro.setValorUsuario(linha, coluna, numero);
                    tabuleiro.imprimir_tabuleiro();
                    System.out.println();
                    break;

                case 2:
                    arquivo.salvar(tabuleiro);
                    System.out.println();
                    return;

                case 3:
                    solver.resolver(tabuleiro, 0, 0);
                    System.out.println("Jogo resolvido com sucesso!");
                    tabuleiro.imprimir_tabuleiro();
                    System.out.println();
                    break;
            }
        }
    }

    public void CarregarJogo() {
        Scanner sc =  new Scanner(System.in);
        tabuleiro = arquivo.Carregar_jogo();
        tabuleiro.imprimir_tabuleiro();
        System.out.println();

        int numero;
        int escolha;
        int linha;
        int coluna;

        while (!tabuleiro.Completo()) {

            System.out.println("1. Inserir numero\n2. Salvar jogo e sair\n3. Preencher tabuleiro");
            System.out.print("Escolha: ");
            escolha = sc.nextInt();
            System.out.println();

            switch(escolha) {
                case 1:

                    System.out.print("Escolha um número de 1 a 9: ");
                    numero = sc.nextInt();


                    System.out.println("Insira a posição em que deseja inserir");
                    System.out.print("Insira a linha: ");
                    linha = sc.nextInt();
                    System.out.print("Insira a coluna: ");
                    coluna = sc.nextInt();
                    System.out.println();

                    tabuleiro.setValorUsuario(linha, coluna, numero);
                    tabuleiro.imprimir_tabuleiro();
                    System.out.println();
                    break;

                case 2:
                    arquivo.salvar(tabuleiro);
                    System.out.println();
                    return;

                case 3:
                    solver.resolver(tabuleiro, 0, 0);
                    System.out.println("Jogo resolvido com sucesso!");
                    tabuleiro.imprimir_tabuleiro();
                    System.out.println();
                    break;
            }
        }
    }
}

