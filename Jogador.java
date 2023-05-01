public class Jogador extends Personagem {
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
}