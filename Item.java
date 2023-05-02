public class Item extends Componente {
    private TipoDeItem tipo;

    public Item(TipoDeItem tipo, int x, int y) {
        super("??", x, y);
        this.tipo = tipo;
    }

    public TipoDeItem getTipo() {
        return tipo;
    }
}