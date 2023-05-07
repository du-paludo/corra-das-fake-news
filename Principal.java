// Eduardo Stefanel Paludo - GRR20210581
// Lucas Neia Torres - GRR20210570
// Natael Pontarolo Gomes - GRR20211786

import java.util.Scanner;
import java.util.Iterator;
import java.util.*;

public class Principal {
    public static void main(String[] arg) {
        int numJogadores, escolha;
        int movimento = 0;
        boolean ehAleatorio = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de jogadores: ");
        numJogadores = scanner.nextInt();

        Jogo jogo = new Jogo(numJogadores);

        Iterator<Jogador> jogadores = jogo.getJogadores().iterator();
        Jogador jogador;
        Item item;
        TipoDeItem tipoDeItem;

        ArrayList<FakeNews> fakeNews = jogo.getFakeNews();
        FakeNews fakeNew;
        Setor setorAntigo, setorNovo;

        long startTime, elapsedTime;

        jogo.desenharTabuleiro();

        // Faz
        for (int i = 0; i < 20; i++) {
            if (!jogadores.hasNext()) {
                jogadores = jogo.getJogadores().iterator();
            }
            jogador = jogadores.next();
            if (jogador.isVivo()) {
                item = jogador.getItem();
                if (item != null) {
                    tipoDeItem = item.getTipo();
                    if (tipoDeItem != TipoDeItem.OUVIR) {
                        System.out.print(jogador.getNome() + ": Você deseja utilizar o item " + tipoDeItem + "? (1 - sim, 2 - não): ");
                        escolha = scanner.nextInt();
                    } else {
                        escolha = 1;
                    }
                    if (escolha == 1) {
                        switch (tipoDeItem) {
                            case DENUNCIAR:
                                jogador.usarDenunciar(jogo.getTabuleiro());
                                break;
                            case FUGIR:
                                int linha, coluna; 
                                while (true) {
                                    System.out.print(jogador.getNome() + ": Digite uma posição (linha coluna) para se mover: ");
                                    linha = scanner.nextInt();
                                    coluna = scanner.nextInt();
                                    if (linha < 1 || linha > 9 || coluna < 1 || coluna > 9) {
                                        System.out.println("Posição inválida.");
                                    } else {
                                        jogo.getSetor(jogador.posicao.getLinha(), jogador.posicao.getColuna()).setJogador(null);;
                                        jogador.usarFugir(linha, coluna);
                                        // jogador.verificaMovimento(setorNovo);
                                        if (jogador.isVivo()) {
                                            jogo.getSetor(linha - 1, coluna - 1).setJogador(jogador);
                                        }
                                        break;
                                    }
                                }
                                break;
                            case LER:
                                jogo.eliminaFakeNews();
                                break;
                            case OUVIR:
                                // movimento aleatório
                                System.out.println(jogador.getNome() + ": Você ouviu um boato e foi movimentado para uma posição aleatória" + tipoDeItem);
                                movimento = new Random().nextInt(4) + 1;
                                ehAleatorio = true;
                                break;
                        }
                        jogador.setItem(null);
                        jogo.desenharTabuleiro();
                    }
                }
                setorAntigo = jogo.getSetor(jogador.posicao.getLinha(), jogador.posicao.getColuna());
                if (!ehAleatorio) {
                    System.out.print(jogador.getNome() + ": Escolha um movimento (1 - norte, 2 - sul, 3 - leste, 4 - oeste): ");
                    movimento = scanner.nextInt();
                } else {
                    ehAleatorio = false;
                }
                setorAntigo.setJogador(null);
                jogador.movimenta(movimento);
                setorNovo = jogo.getSetor(jogador.posicao.getLinha(), jogador.posicao.getColuna());
                if (setorNovo.getItem() != null) {
                    jogador.setItem(setorNovo.getItem());
                    setorNovo.setItem(null);
                    jogo.criaItens(1);
                }
                jogador.verificaMovimento(setorNovo);
                if (jogador.isVivo()) {
                    setorNovo.setJogador(jogador);
                } else {
                    // jogo.getJogadores().remove(jogador);
                }
            }
            jogo.desenharTabuleiro();


            for (int j = 0; j < fakeNews.size(); j++) {
                // System.out.println("j: " + j);
                // System.out.println("fakeNews.size(): " + fakeNews.size());
                fakeNew = fakeNews.get(j);
                if (fakeNew.isVivo()) {
                    startTime = System.currentTimeMillis();
                    elapsedTime = 0;
                    /* while (elapsedTime < 1000) {
                        elapsedTime = (new Date()).getTime() - startTime;
                    } */
                    setorAntigo = jogo.getSetor(fakeNew.posicao.getLinha(), fakeNew.posicao.getColuna());
                    setorAntigo.setFakeNews(null);
                    //fakeNew.movimenta(new Random().nextInt(4) + 1);
                    jogo.verificaFakeNews(fakeNew);
                    jogo.desenharTabuleiro();
                }
            }
        }
        scanner.close();
    }
}