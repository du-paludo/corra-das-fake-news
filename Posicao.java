public class Posicao {
    private int x;
    private int y;

    public Posicao(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int novoX) {
        if (x >= 0 && x <= 8) {
            this.x = novoX;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int novoY) {
        if (y >= 0 && y <= 8) {
            this.y = novoY;
        }
    }
}
