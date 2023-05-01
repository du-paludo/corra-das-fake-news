public class F3 extends Personagem implements FakeNews {
    public F3(int x, int y) {
        super("F3", x, y);
    }

    public String getNome() {
        return nome;
    }

    public void elimina() {

    }

    public void movimenta() {
        /* int num = new Random().nextInt(4);
        switch (num) {
            case 0:
                Movimento.umaCasaNorte(this);
                break;
            case 1:
                Movimento.umaCasaSul(this);
                break;
            case 2:
                Movimento.umaCasaLeste(this);
                break;
            case 3:
                Movimento.umaCasaOeste(this);
                break;
        } */
    }
}