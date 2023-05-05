// Eduardo Stefanel Paludo - GRR20210581
// Lucas Neia Torres - GRR20210570
// Natael Pontarolo Gomes - GRR20211786

import java.util.Scanner;
import java.util.Iterator;
import java.util.*;

public class Principal {
    public static void main(String[] arg) {
        int numJogadores, movimento;
        //int linha, coluna;
        Jogador jogador;
        FakeNews fakeNew;
        Setor setorAntigo, setorNovo;

        long startTime, elapsedTime;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de jogadores: ");
        numJogadores = scanner.nextInt();
        Jogo jogo = new Jogo(numJogadores);
        jogo.desenharTabuleiro();

        Iterator<Jogador> jogadores = jogo.getJogadores().iterator();
        Iterator<FakeNews> fakeNews = jogo.getFakeNews().iterator();

        for (int i = 0; i < 20; i++) {
            if (!jogadores.hasNext()) {
                jogadores = jogo.getJogadores().iterator();
            }
            jogador = jogadores.next();
            if (jogador.isVivo()) {
                setorAntigo = jogo.getSetor(jogador.posicao.getLinha(), jogador.posicao.getColuna());
                System.out.print(jogador.getNome() + ": Escolha um movimento (1 - norte, 2 - sul, 3 - leste, 4 - oeste): ");
                movimento = scanner.nextInt();
                setorAntigo.setJogador(null);
                jogador.movimenta(movimento);
                setorNovo = jogo.getSetor(jogador.posicao.getLinha(), jogador.posicao.getColuna());
                jogador.verificaMovimento(setorNovo);
                if (jogador.isVivo()) {
                    setorNovo.setJogador(jogador);
                }
            }
            jogo.desenharTabuleiro();

            fakeNews = jogo.getFakeNews().iterator();
            while (fakeNews.hasNext()) {
                fakeNew = fakeNews.next();
                if (fakeNew.isVivo()) {
                    startTime = System.currentTimeMillis();
                    elapsedTime = 0;
                    while (elapsedTime < 2*1000) {
                        elapsedTime = (new Date()).getTime() - startTime;
                    }
                    setorAntigo = jogo.getSetor(fakeNew.posicao.getLinha(), fakeNew.posicao.getColuna());
                    setorAntigo.setFakeNews(null);
                    fakeNew.movimenta(new Random().nextInt(4) + 1);
                    setorNovo = jogo.getSetor(fakeNew.posicao.getLinha(), fakeNew.posicao.getColuna());
                    if (setorNovo.getItem() != null) {;
                        setorNovo.setItem(null);
                        jogo.duplicaFakeNews(fakeNew);
                    }
                    fakeNew.verificaMovimento(setorNovo);
                    setorNovo.setFakeNews(fakeNew);
                    jogo.desenharTabuleiro();
                }
            }
        }
        
        scanner.close();
    }
}