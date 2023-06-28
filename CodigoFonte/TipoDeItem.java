import java.util.Random;

public enum TipoDeItem {
    DENUNCIAR, FUGIR, LER, OUVIR;

    private static final Random random = new Random();

    public static TipoDeItem itemAleatorio()  {
        TipoDeItem[] tipoDeItens = values();
        return tipoDeItens[random.nextInt(tipoDeItens.length)];
    }
}
