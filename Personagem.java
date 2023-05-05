public abstract class Personagem {
    protected final String nome;
    protected Posicao posicao;

    public Personagem(String nome, int x, int y) {
        this.nome = nome;
        this.posicao = new Posicao(x, y);
    }

    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(int linha, int coluna) {
        this.posicao.setLinha(linha);
        this.posicao.setColuna(coluna);
    }
}
