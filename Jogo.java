import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;

public class Jogo {
    private Setor[][] tabuleiro = new Setor[9][9];
    private ArrayList<Jogador> jogadores;
    private ArrayList<Item> itens;
    private ArrayList<FakeNews> fakeNews;
    private int numJogadores;
    // private int turno = 0;

    public Jogo(int numJogadores) {
        this.numJogadores = numJogadores;
        jogadores = new ArrayList<Jogador>();
        itens = new ArrayList<Item>();
        fakeNews = new ArrayList<FakeNews>();
        criaTabuleiro();
        criaJogadores();
        criaFakeNews();
        criaItens(10);
        insereSetoresRestritos();
    }

    public Setor getSetor(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public Setor[][] getTabuleiro() {
        return tabuleiro;
    }

    public ArrayList<FakeNews> getFakeNews() {
        return fakeNews;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public int getNumJogadoresVivos() {
        int numVivos = 0;
        for (Jogador jogador : jogadores) {
            if (jogador.isVivo()) {
                numVivos++;
            }
        }
        return numVivos;
    }

    public int getNumFakeNewsVivas() {
        int numVivos = 0;
        for (FakeNews fakeNew : fakeNews) {
            if (fakeNew.isVivo()) {
                numVivos++;
            }
        }
        return numVivos;
    }

    private void criaTabuleiro() {
        for (int linha = 0; linha < 9; linha++) {
            for (int coluna = 0; coluna < 9; coluna++) {
                tabuleiro[linha][coluna] = new Setor();
            }
        }
    }

    public void insereNoTabuleiro(Componente componente) {
        tabuleiro[componente.posicao.getLinha()][componente.posicao.getColuna()].setComponente(componente);
    }

    public void insereSetoresRestritos() {
        int linha, coluna;
        for (int i = 0; i < 4; i++) {
            linha = new Random().nextInt(9);
            coluna = new Random().nextInt(9);
            if (tabuleiro[linha][coluna].estaVazio()) {
                tabuleiro[linha][coluna].setRestrito(true);
            } else {
                i--;
            }
        }
    }

    public void desenharTabuleiro() {
        int linha, coluna;
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 9; j++) {
                linha = i/2;
                coluna = j;
                if (i % 2 == 0) {
                    System.out.print("+----");
                } else {
                    if (tabuleiro[linha][coluna].getJogador() != null) {
                        System.out.print("| " + Cores.ANSI_GREEN + tabuleiro[linha][coluna].getJogador().getNome() + Cores.ANSI_RESET + " ");
                    } else if (tabuleiro[linha][coluna].isRestrito()) {
                        System.out.print("| " + Cores.ANSI_WHITE + "XX" + Cores.ANSI_RESET + " ");
                    } else if (tabuleiro[linha][coluna].getFakeNews() != null) {
                        System.out.print("| " + Cores.ANSI_RED + tabuleiro[linha][coluna].getFakeNews().getNome() + Cores.ANSI_RESET + " ");
                    } else if (tabuleiro[linha][coluna].getItem() != null) {
                        System.out.print("| " + Cores.ANSI_YELLOW + "??" + Cores.ANSI_RESET + " ");
                    } else {
                        System.out.print("|    ");
                    }
                }
            }
            if (i % 2 == 0)
                System.out.println("+");
            else
                System.out.println("|");
        }
        System.out.println("+----+----+----+----+----+----+----+----+----+");
    }

    public void criaJogadores() {
        for (int i = 0; i < numJogadores; i++) {
            switch (i) {
                case 0:
                    jogadores.add(new Jogador("J1", 0, 4));
                    break;
                case 1:
                    jogadores.add(new Jogador("J2", 4, 8));
                    break;
                case 2:
                    jogadores.add(new Jogador("J3", 8, 4));
                    break;
                case 3:
                    jogadores.add(new Jogador("J4", 4, 0));
                    break;
                default:
                    System.out.println("Número de jogadores inválido.");
            }
            insereNoTabuleiro(jogadores.get(i));
        }
    }

    public void criaFakeNews() {
        int linha, coluna;
        FakeNews fakeNew;
        for (int i = 0; i < 2; i++) {
            linha = new Random().nextInt(7) + 1;
            coluna = new Random().nextInt(7) + 1;
            if (tabuleiro[linha][coluna].estaVazio()) {
                fakeNew = new F1(linha, coluna);
                fakeNews.add(fakeNew);
                insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            linha = new Random().nextInt(7) + 1;
            coluna = new Random().nextInt(7) + 1;
             if (tabuleiro[linha][coluna].estaVazio()) {
                fakeNew = new F2(linha, coluna);
                fakeNews.add(fakeNew);
                insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            linha = new Random().nextInt(7) + 1;
            coluna = new Random().nextInt(7) + 1;
            if (tabuleiro[linha][coluna].estaVazio())  {
                fakeNew = new F3(linha, coluna);
                fakeNews.add(fakeNew);
                insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
    }

    public void duplicaFakeNews(FakeNews fakeNew) {
        int linhaAntiga = fakeNew.getPosicao().getLinha();
        int colunaAntiga = fakeNew.getPosicao().getColuna();
        int linha = linhaAntiga;
        int coluna = colunaAntiga;

        while (true) {
            linha = new Random().nextInt(3) + linhaAntiga - 1;
            coluna = new Random().nextInt(3) + colunaAntiga - 1;
            if (linha >= 0 && linha <= 8 && coluna >= 0 && coluna <= 8)
                if (tabuleiro[linha][coluna].estaVazio())
                    break;
        }

        // while (!tabuleiro[linha][coluna].estaVazio()) {
        //     while ((linha > 0 && linha > 8 || coluna < 0 || coluna > 8)) {
        //         linha = new Random().nextInt(3) + linhaAntiga - 1;
        //         coluna = new Random().nextInt(3) + 'colunaAntiga' - 1;
        //         if (linha < 0 || linha > 8 || coluna < 0 || coluna > 8)
        //             continue;
        //     }
        // }
        
        // while ((linha < 0 || linha > 8 || coluna < 0 || coluna > 8) (!tabuleiro[linha][coluna].estaVazio())) {
        //     linha = new Random().nextInt(3) + linhaAntiga - 1;
        //     coluna = new Random().nextInt(3) + colunaAntiga - 1;
        //     if (linha < 0 || linha > 8 || coluna < 0 || coluna > 8)
        //         continue;
        // }

        if (fakeNew instanceof F1) {
            fakeNew = new F1(linha, coluna);
        } else if (fakeNew instanceof F2) {
            fakeNew = new F2(linha, coluna);
        } else if (fakeNew instanceof F3) {
            fakeNew = new F3(linha, coluna);
        }
        fakeNews.add(fakeNew);
        insereNoTabuleiro(fakeNew);
    }

    public void criaItens(int quantidade) {
        int linha, coluna;
        Item item;
        for (int i = 0; i < quantidade; i++) {
            linha = new Random().nextInt(9);
            coluna = new Random().nextInt(9);
            if (tabuleiro[linha][coluna].estaVazio()) {
                item = new Item(TipoDeItem.OUVIR, linha, coluna);
                // item = new Item(TipoDeItem.itemAleatorio(), linha, coluna);
                itens.add(item);
                insereNoTabuleiro(item);
            } else {
                i--;
            }
        }
    }

    public void verificaFakeNews(FakeNews fakeNew) {
        Setor setor = tabuleiro[fakeNew.posicao.getLinha()][fakeNew.posicao.getColuna()];

        if (setor.isRestrito()) {
            fakeNew.setVivo(false);
        } else if (setor.getItem() != null) {
            setor.setItem(null);
            duplicaFakeNews(fakeNew);
        } else if (setor.getJogador() != null) {
            setor.getJogador().setVivo(false);
            setor.setJogador(null);
        } else if (setor.getFakeNews() != null) {
            fakeNew.setVivo(false);            
        }

        if (fakeNew.isVivo()) {
            setor.setFakeNews(fakeNew);
        }
    }

    public void verificaJogador(Jogador jogador) {
        Setor setor = tabuleiro[jogador.posicao.getLinha()][jogador.posicao.getColuna()];

        if (setor.isRestrito() || setor.getFakeNews() != null) {
            jogador.setVivo(false);
            System.out.println("Você morreu!");
        }
        if (setor.getItem() != null) {
            jogador.setItem(setor.getItem());
            setor.setItem(null);
            criaItens(1);
        }

        if (jogador.isVivo()) {
            setor.setJogador(jogador);
        }
    }

    public void turnoDoJogador(Scanner scanner, Jogador jogador) {
        Item item;
        TipoDeItem tipoDeItem;
        int escolha; // Indica se o jogador deseja utilizar o item ou não (1 = sim, 2 = não)
        int movimento = 0; // Indica o movimento que o jogador deseja fazer
        boolean ehAleatorio = false; // Indica se o próximo movimento do jogador é aleatório ou não
        Setor setor;
        
        item = jogador.getItem();
        if (item != null) {
            tipoDeItem = item.getTipo();
            // Se o tipo do item não for ouvir, pergunta se o jogador deseja utilizá-lo
            if (tipoDeItem != TipoDeItem.OUVIR) {
                System.out.print(jogador.getNome() + ": Você deseja utilizar o item " + tipoDeItem + "? (1 - sim, 2 - não): ");
                escolha = scanner.nextInt();
            } else {
                escolha = 1;
            }
            // Se o jogador deseja utilizar o item, chama o método correspondente
            if (escolha == 1) {
                jogador.setItem(null);
                switch (tipoDeItem) {
                    case DENUNCIAR:
                        jogador.usarDenunciar(tabuleiro);
                        break;
                    case FUGIR:
                        int linha, coluna; 
                        // Pede para o jogador digitar uma posição válida para se teletransportar
                        while (true) {
                            System.out.print(jogador.getNome() + ": Digite uma posição (linha coluna) para se mover: ");
                            linha = scanner.nextInt();
                            coluna = scanner.nextInt();
                            if (linha < 1 || linha > 9 || coluna < 1 || coluna > 9) {
                                System.out.println("Posição inválida.");
                            } else {
                                jogador.usarFugir(tabuleiro, linha, coluna);
                                verificaJogador(jogador);
                                break;
                            }
                        }
                        break;
                    case LER:
                        jogador.usarLer(this);
                        break;
                    // Faz o jogador executar um movimento aleatório
                    case OUVIR:
                        System.out.println(jogador.getNome() + ": Você ouviu um boato e foi movimentado para uma posição aleatória");
                        movimento = new Random().nextInt(4) + 1;
                        ehAleatorio = true;
                        break;
                }
                desenharTabuleiro();
            }
        }
        // Exclui o jogador do setor antigo
        setor = tabuleiro[jogador.posicao.getLinha()][jogador.posicao.getColuna()];
        setor.setJogador(null);

        // Se o movimento não for aleatório, pede para o jogador escolher um movimento válido
        if (jogador.isVivo()) {
            if (!ehAleatorio) {
                System.out.print(jogador.getNome() + ": Escolha um movimento (1 - norte, 2 - sul, 3 - leste, 4 - oeste): ");
                movimento = scanner.nextInt();
            } else {
                ehAleatorio = false;
            }
            jogador.movimenta(movimento);
            // Após o jogador se movimentar, o jogo verifica se houve colisão entre o jogador e outro componente
            verificaJogador(jogador);
        }
    }
        
    public void turnoDaFakeNews(FakeNews fakeNews) {
        Setor setor;
        long startTime, elapsedTime;

        startTime = System.currentTimeMillis();
        elapsedTime = 0;
        while (elapsedTime < 1000) {
            elapsedTime = (new Date()).getTime() - startTime;
        }

        setor = tabuleiro[fakeNews.posicao.getLinha()][fakeNews.posicao.getColuna()];
        setor.setFakeNews(null);
        fakeNews.movimenta(new Random().nextInt(4) + 1);
        verificaFakeNews(fakeNews);
    }
}
