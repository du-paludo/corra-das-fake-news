// Eduardo Stefanel Paludo - GRR20210581
// Lucas Neia Torres - GRR20210570
// Natael Pontarolo Gomes - GRR20211786

import java.util.Scanner;

public class Principal {
    public static void iniciaJogo() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.criarTabuleiro();
        //tabuleiro.insereJogadores();
        tabuleiro.inserirSetoresRestritos();
        tabuleiro.inserirFakeNews();
        tabuleiro.inserirItens();
        tabuleiro.desenharTabuleiro();
    }
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de jogadores: ");
        int numJogadores = scanner.nextInt();
        Jogo jogo = new Jogo(numJogadores);
    }
}