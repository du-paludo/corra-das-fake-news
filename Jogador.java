public class Jogador extends Componente {
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

    public void movimenta(int movimento) {
        switch (movimento) {
            case 1:
                movimentoUm();
                break;
            case 2:
                movimentoDois();
                break;
            case 3:
                movimentoTres();
                break;
            case 4:
                movimentoQuatro();
                break;
            default:
                break;
        }
    }

    public void movimentoUm() {
        if (this.posicao.getY() > 1) {
            this.posicao.setY(this.posicao.getY() - 1);
        }
    }

    public void movimentoDois() {
        if (this.posicao.getY() < 8) {
            this.posicao.setY(this.posicao.getY() + 1);
        }
    }

    public void movimentoTres() {
        if (this.posicao.getX() > 1) {
            this.posicao.setX(this.posicao.getX() - 1);
        }
    }

    public void movimentoQuatro() {
        if (this.posicao.getX() < 8) {
            this.posicao.setX(this.posicao.getX() + 1);
        }
    }
}