public class F3 extends Personagem implements FakeNews, Movimento {
    public F3(int x, int y) {
        super("F3", x, y);
    }

    public String getNome() {
        return nome;
    }

    public void elimina() {

    }

    @Override
    public void goUp() {
        // implementação do movimento para cima
    }

    @Override
    public void goDown() {
        // implementação do movimento para baixo
    }

    @Override
    public void goLeft() {
        // implementação do movimento para esquerda
    }

    @Override
    public void goRight() {
        // implementação do movimento para direita
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