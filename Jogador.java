public class Jogador extends Personagem implements Movimento{
    private Item item;

    public Jogador(String nome, int x, int y) {
        super(nome, x, y);
        this.item = null;
    }

    public String getNome() {
        return nome;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

}