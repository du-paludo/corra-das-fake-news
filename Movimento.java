public class Movimento {
    public static void umaCasaNorte(Personagem personagem) {
        if (personagem.posicao.getY() < 8) {
            personagem.posicao.setY(personagem.posicao.getY() + 1);
        }
    }
}