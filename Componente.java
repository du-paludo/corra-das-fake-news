public abstract class Componente {
    protected final String nome;
    protected Posicao posicao;

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

    public void setPosicao(int x, int y) {
        this.posicao.setX(x);
        this.posicao.setY(y);
    }
}
