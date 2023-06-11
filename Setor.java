public class Setor {
    private Jogador jogador;
    private FakeNews fakeNews;
    private Item item;
    private boolean restrito;
    
    public Setor() {
        //this.setLinha(linha);
        //this.setColuna(coluna);
        this.setItem(null);
        this.setJogador(null);
        this.setFakeNews(null);
        this.setRestrito(false);
    }

    /* public int getLinha() {
        return linha;
    }

    public void setLinha(int novolinha) {
        if (linha >= 0 && linha <= 8) {
            this.linha = novolinha;
        }
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int novocoluna) {
        if (coluna >= 0 && coluna <= 8) {
            this.coluna = novocoluna;
        }
    } */

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public FakeNews getFakeNews() {
        return fakeNews;
    }

    public void setComponente(Componente componente) {
        if (componente instanceof Jogador) {
            this.setJogador((Jogador) componente);
        } else if (componente instanceof FakeNews) {
            this.setFakeNews((FakeNews) componente);
        } else if (componente instanceof Item) {
            this.setItem((Item) componente);
        }
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

    public boolean estaVazio() {
        if (this.getJogador() == null && this.getFakeNews() == null && this.getItem() == null && !this.isRestrito()) {
            return true;
        } else {
            return false;
        }
    }
}