import java.util.Random;

public class F1 extends Personagem implements FakeNews, Movimento {
    public F1(int x, int y) {
        super("F1", x, y);
    }

    public String getNome() {
        return nome;
    }

    public void elimina() {

    }

    @Override
    public void goUp(Personagem p) {
        // implementação do movimento para cima na matriz
        p.posicao.setY(p.posicao.getY() - 1);
    }

    @Override
    public void goDown(Personagem p) {
        // implementação do movimento para baixo
        p.posicao.setY(p.posicao.getY() + 1);
    }

    @Override
    public void goLeft(Personagem p) {
        // implementação do movimento para esquerda
        p.posicao.setX(p.posicao.getX() - 1);
    }

    @Override
    public void goRight(Personagem p) {
        // implementação do movimento para direita
        p.posicao.setX(p.posicao.getX() + 1);
    }

    public void movimenta(Personagem p) {
        int num = new Random().nextInt(4);
        switch (num) {
            case 0:
                goUp(p);
                break;
            case 1:
                goDown(p);
                break;
            case 2:
                goLeft(p);
                break;
            case 3:
                goRight(p);
                break;
        }
    }
}
