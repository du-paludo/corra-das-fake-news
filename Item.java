public class Item extends Personagem {
    private TipoDeItem tipo;

    public Item(TipoDeItem tipo, int x, int y) {
        super("Item", x, y);
        this.tipo = tipo;
    }

    public TipoDeItem getTipo() {
        return tipo;
    }
}