import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    public Tabuleiro tabuleiro;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Item> itens;
    private ArrayList<FakeNews> fakeNews;
    private int numJogadores;
    private int turno = 0;

    public Jogo(int numJogadores) {
        this.numJogadores = numJogadores;
        tabuleiro = new Tabuleiro();
        jogadores = new ArrayList<Jogador>();
        itens = new ArrayList<Item>();
        fakeNews = new ArrayList<FakeNews>();
        criaJogadores();
        criaFakeNews();
        criaItens();
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void insereNoTabuleiro() {
        //tabuleiro.insereJogadores(jogadores);
        tabuleiro.insereSetoresRestritos();
        //tabuleiro.insereFakeNews(fakeNews);
        //tabuleiro.insereItens(itens);
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
            tabuleiro.insereNoTabuleiro(jogadores.get(i));
        }
    }

    public void criaFakeNews() {
        int x, y;
        FakeNews fakeNew;
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
            if (tabuleiro.setores[x][y].estaVazio()) {
                fakeNew = new F1(x, y);
                fakeNews.add(fakeNew);
                tabuleiro.insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
             if (tabuleiro.setores[x][y].estaVazio()) {
                fakeNew = new F2(x, y);
                fakeNews.add(fakeNew);
                tabuleiro.insereNoTabuleiro(fakeNew);
            } else {
                i--;
            }
        }
        for (int i = 0; i < 2; i++) {
            x = new Random().nextInt(7) + 1;
            y = new Random().nextInt(7) + 1;
            if (tabuleiro.setores[x][y].estaVazio())  {
                fakeNew = new F3(x, y);
                fakeNews.add(fakeNew);
                tabuleiro.insereNoTabuleiro(fakeNew);
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
            if (tabuleiro.setores[x][y].estaVazio()) {
                item = new Item(TipoDeItem.itemAleatorio(), x, y);
                itens.add(item);
                tabuleiro.insereNoTabuleiro(item);
            } else {
                i--;
            }
        }
    }
}
