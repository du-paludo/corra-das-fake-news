import java.util.Random;
import java.util.ArrayList;

public class Tabuleiro {
    private Setor[][] tabuleiro = new Setor[9][9]; 

    public Tabuleiro() {
        criarTabuleiro();
    }

    public void criarTabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabuleiro[i][j] = new Setor(i, j);
            }
        }
    }

    /* public void inserirJogadores(int nmrJogadores) {
        int i;
        
        switch (numJogadores) {
            case 1:
                tabuleiro[4][8].setJogador(new Jogador("J1"));
                break;
            case 2:
                tabuleiro[4][8].setJogador(new Jogador("J1"));
                tabuleiro[8][4].setJogador(new Jogador("J2"));
                break;
            case 3:
                tabuleiro[4][8].setJogador(new Jogador("J1"));
                tabuleiro[8][4].setJogador(new Jogador("J2"));
                tabuleiro[4][0].setJogador(new Jogador("J3"));
                posicoes[2] = new int[]{4, 0};
                break;
            case 4:
                tabuleiro[4][8].setJogador(new Jogador("J1"));
                tabuleiro[8][4].setJogador(new Jogador("J2"));
                tabuleiro[4][0].setJogador(new Jogador("J3"));
                tabuleiro[0][4].setJogador(new Jogador("J4"));
                break;
            default:
                System.out.println("Número de jogadores inválido.");
    } */

    public void insereJogadores(ArrayList<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            tabuleiro[jogador.posicao.getX()][jogador.posicao.getY()].setJogador(jogador);
        }    
    }

    public void inserirSetoresRestritos() {
        int x, y;
        for (int i = 0; i < 4; i++) {
            x = new Random().nextInt(9);
            y = new Random().nextInt(9);
            if (tabuleiro[x][y].getJogador() == null) {
                tabuleiro[x][y].setRestrito(true);
            } else {
                i--;
            }
        }
    }

    public void inserirFakeNews() {
        int x, y;
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
            if (tabuleiro[x][y].getJogador() == null && !tabuleiro[x][y].isRestrito()) {
                tabuleiro[x][y].setFakeNews(new F1(x, y));
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
            if (tabuleiro[x][y].getJogador() == null && !tabuleiro[x][y].isRestrito()) {
                tabuleiro[x][y].setFakeNews(new F2(x, y));
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
            if (tabuleiro[x][y].getJogador() == null && !tabuleiro[x][y].isRestrito()) {
                tabuleiro[x][y].setFakeNews(new F3(x, y));
            } else {
                i--;
            }
        }
    }

    public void inserirItens() {
        int x, y;
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(9);
            y = new Random().nextInt(9);
            if (tabuleiro[x][y].getJogador() == null && !tabuleiro[x][y].isRestrito() && tabuleiro[x][y].getFakeNews() == null && tabuleiro[x][y].getItem() == null) {
                tabuleiro[x][y].setItem(new Item(TipoDeItem.itemAleatorio(), x, y));
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
}

