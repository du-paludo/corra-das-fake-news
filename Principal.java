// Eduardo Stefanel Paludo - GRR20210581
// Lucas Neia Torres - GRR20210570
// Natael Pontarolo Gomes - GRR20211786

import java.util.Scanner;
import java.util.Iterator;
import java.util.*;

public class Principal {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int numJogadores;

        System.out.print("Digite o número de jogadores: ");
        numJogadores = scanner.nextInt();

        Jogo jogo = new Jogo(numJogadores);

        Iterator<Jogador> jogadores = jogo.getJogadores().iterator();
        Jogador jogador;
  
        ArrayList<FakeNews> fakeNews = jogo.getFakeNews();
        FakeNews fakeNew;

        jogo.desenharTabuleiro();

        // Cada iteração é um turno do jogo
        for (int i = 0; i < 20; i++) {
            // Se o iterador dos jogadores não possuir mais elementos, reinicia o iterador
            if (!jogadores.hasNext()) {
                jogadores = jogo.getJogadores().iterator();
            }
            jogador = jogadores.next();

            if (jogador.isVivo()) {
                jogo.turnoDoJogador(scanner, jogador);
                jogo.desenharTabuleiro();
                // Para cada fake news, verifica se ela está viva e, se estiver, executa seu turno
                for (int j = 0; j < fakeNews.size(); j++) {
                    fakeNew = fakeNews.get(j);
                    if (fakeNew.isVivo()) {
                        jogo.turnoDaFakeNews(fakeNew);
                        jogo.desenharTabuleiro();
                    }
                }
            } else {
                i--;
            }

            // Se o número de jogadores vivos for 0, o jogo acaba
            if (jogo.getNumJogadoresVivos() == 0) {
                System.out.println("Todos os jogadores morreram. O jogo acabou.");
                break;
            }
            // Se o número de fake news vivas for 0, o jogo acaba
            if (jogo.getNumFakeNewsVivas() == 0) {
                System.out.println("Todas as fake news morreram. O jogo acabou.");
                break;
            }
        }
        scanner.close();
    }
}