public abstract class FakeNews extends Componente implements Movimento {
    public FakeNews(String nome, int x, int y) {
        super(nome, x, y);
        vivo = true;
    }
}