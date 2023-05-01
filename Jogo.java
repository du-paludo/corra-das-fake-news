import java.util.ArrayList;

public class Jogo {
    private Tabuleiro tabuleiro;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Item> itens;
    private ArrayList<FakeNews> fakeNews;
    private int numJogadores;
    private int turno = 0;

    public Jogo(int numJogadores) {
        this.numJogadores = numJogadores;
        tabuleiro = new Tabuleiro();
        criaJogadores();
    }

    public void insereNoTabuleiro() {
        tabuleiro.insereJogadores(jogadores);
        tabuleiro.insereSetoresRestritos();
        tabuleiro.insereFakeNews();
        tabuleiro.insereItens();
        //tabuleiro.desenharTabuleiro();
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
        }
    }

    public void criaFakeNews() {
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

    public void criaItens() {

    }

    /* public void fazJogadas() {
        if vezDoJogador() {
            
        } else {
            // ...
        }
    } */
}
