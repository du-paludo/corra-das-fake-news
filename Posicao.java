public class Posicao {
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.setLinha(linha);
        this.setColuna(coluna);
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        if (linha >= 0 && linha <= 8) {
            this.linha = linha;
        }
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        if (coluna >= 0 && coluna <= 8) {
            this.coluna = coluna;
        }
    }
}
