public abstract class Componente {
    protected final String nome;
    protected Posicao posicao;
    protected boolean vivo;

    public Componente(String nome, int x, int y) {
        this.nome = nome;
        this.posicao = new Posicao(x, y);
    }

    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setPosicao(int linha, int coluna) {
        this.posicao.setLinha(linha);
        this.posicao.setColuna(coluna);
    }
}
