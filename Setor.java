public class Setor {
    private int x;
    private int y;
    private Jogador jogador;
    private FakeNews fakeNews;
    private Item item;
    private boolean restrito;
    
    public Setor(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.setJogador(null);
        this.setFakeNews(null);
        this.setRestrito(false);
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

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public FakeNews getFakeNews() {
        return fakeNews;
    }

    public void setFakeNews(FakeNews fakeNews) {
        this.fakeNews = fakeNews;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public boolean isRestrito() {
        return restrito;
    }

    public void setRestrito(boolean novoRestrito) {
        this.restrito = novoRestrito;
    }
}