// Eduardo Stefanel Paludo - GRR20210581
// Lucas Neia Torres - GRR20210570
// Natael Pontarolo Gomes - GRR20211786

import java.util.Scanner;

public class Principal {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de jogadores: ");
        int numJogadores = scanner.nextInt();
        Jogo jogo = new Jogo(numJogadores);
        jogo.insereNoTabuleiro();
        jogo.tabuleiro.desenharTabuleiro();
        
        System.out.print("Escolha um movimento: ");
        int movimento = scanner.nextInt();
        jogo.tabuleiro.setores[0][4].setJogador(null);
        Jogador jogador = jogo.getJogadores().get(0);
        jogador.movimenta(movimento);
        int x = jogador.posicao.getX();
        int y = jogador.posicao.getY();
        jogo.tabuleiro.setores[x][y].setJogador(jogador);

        jogo.tabuleiro.desenharTabuleiro();

        for (int i = 0; i < 20; i++) {
            // jogador faz movimento
            // for fakeNews in fakenews
                // faz o movimento
                // espera 2 segundos
        }
        
        scanner.close();
    }
}