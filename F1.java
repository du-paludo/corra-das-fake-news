// import java.util.Random;

public class F1 extends Personagem implements FakeNews {
    public F1(int x, int y) {
        super("F1", x, y);
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
