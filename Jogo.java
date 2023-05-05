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
        criaItens();
        insereSetoresRestritos();
    }

    public Setor[][] getTabuleiro() {
        return tabuleiro;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    private void criaTabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabuleiro[i][j] = new Setor(i, j);
            }
        }
    }

    public void insereNoTabuleiro(Componente componente) {
        tabuleiro[componente.posicao.getX()][componente.posicao.getY()].setComponente(componente);
    }

    public void insereSetoresRestritos() {
        int x, y;
        for (int i = 0; i < 4; i++) {
            x = new Random().nextInt(9);
            y = new Random().nextInt(9);
            if (tabuleiro[x][y].estaVazio()) {
                tabuleiro[x][y].setRestrito(true);
            } else {
                i--;
            }
        }
    }

    public void desenharTabuleiro() {
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 9; j++) {
                if (i % 2 == 0) {
                    System.out.print("+----");
                } else {
                    if (tabuleiro[i/2][j].getJogador() != null) {
                        System.out.print("| " + Cores.ANSI_GREEN + tabuleiro[i/2][j].getJogador().getNome() + Cores.ANSI_RESET + " ");
                    } else if (tabuleiro[i/2][j].isRestrito()) {
                        System.out.print("| " + Cores.ANSI_WHITE + "XX" + Cores.ANSI_RESET + " ");
                    } else if (tabuleiro[i/2][j].getFakeNews() != null) {
                        System.out.print("| " + Cores.ANSI_RED + tabuleiro[i/2][j].getFakeNews().getNome() + Cores.ANSI_RESET + " ");
                    } else if (tabuleiro[i/2][j].getItem() != null) {
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
        int x, y;
        FakeNews fakeNew;
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
            if (tabuleiro[x][y].estaVazio()) {
                fakeNew = new F1(x, y);
                fakeNews.add(fakeNew);
                insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
             if (tabuleiro[x][y].estaVazio()) {
                fakeNew = new F2(x, y);
                fakeNews.add(fakeNew);
                insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
            if (tabuleiro[x][y].estaVazio())  {
                fakeNew = new F3(x, y);
                fakeNews.add(fakeNew);
                insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
    }

    public void criaItens() {
        int x, y;
        Item item;
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(9);
            y = new Random().nextInt(9);
            if (tabuleiro[x][y].estaVazio()) {
                item = new Item(TipoDeItem.itemAleatorio(), x, y);
                itens.add(item);
                insereNoTabuleiro(item);
            } else {
                i--;
            }
        }
    }
}
