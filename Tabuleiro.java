/* import java.util.Random;
import java.util.ArrayList;

public class Tabuleiro {
    public Setor[][] setores = new Setor[9][9]; 

    public Tabuleiro() {
        criarTabuleiro();
    }

    public void criarTabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                setores[i][j] = new Setor(i, j);
            }
        }
    }

    public void insereNoTabuleiro(Componente componente) {
        setores[componente.posicao.getX()][componente.posicao.getY()].setComponente(componente);
    }

    public void insereSetoresRestritos() {
        int x, y;
        for (int i = 0; i < 4; i++) {
            x = new Random().nextInt(9);
            y = new Random().nextInt(9);
            if (setores[x][y].estaVazio()) {
                setores[x][y].setRestrito(true);
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
                    if (setores[i/2][j].getJogador() != null) {
                        System.out.print("| " + Cores.ANSI_GREEN + setores[i/2][j].getJogador().getNome() + Cores.ANSI_RESET + " ");
                    } else if (setores[i/2][j].isRestrito()) {
                        System.out.print("| " + Cores.ANSI_WHITE + "XX" + Cores.ANSI_RESET + " ");
                    } else if (setores[i/2][j].getFakeNews() != null) {
                        System.out.print("| " + Cores.ANSI_RED + setores[i/2][j].getFakeNews().getNome() + Cores.ANSI_RESET + " ");
                    } else if (setores[i/2][j].getItem() != null) {
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
} */