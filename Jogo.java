import java.util.ArrayList;
import java.util.Random;

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
        for (int i = 0; i < 3; i++) {
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
        for (int i = 0; i < 3; i++) {
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
        for (int i = 0; i < 3; i++) {
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
        int linha, coluna;
        linha = new Random().nextInt(9);
        coluna = new Random().nextInt(9);
        while (!tabuleiro[linha][coluna].estaVazio()) {
            linha = new Random().nextInt(9);
            coluna = new Random().nextInt(9);
        }

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
                item = new Item(TipoDeItem.itemAleatorio(), linha, coluna);
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

    public void eliminaFakeNews() {
        FakeNews fakeNew;
        // elimina fake news aleatória do tabuleiro
        for (int i = 0; i < fakeNews.size(); i++) {
            fakeNew = fakeNews.get(i);
            if (fakeNew.isVivo()) {
                tabuleiro[fakeNew.posicao.getLinha()][fakeNew.posicao.getColuna()].setFakeNews(null);
                fakeNew.setVivo(false);
                break;
            }
        }
    }
}
