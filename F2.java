public class F2 extends FakeNews {
    public F2(int x, int y) {
        super("F2", x, y);
    }

    public boolean movimenta(int movimento) {
        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();
        switch (movimento) {
            case 1: // norte
                if (linha > 1) {
                    this.posicao.setLinha(linha - 2);
                } else {
                    // this.vivo = false;
                    return false;
                }
                System.out.println("F2 movimenta duas casas norte");
                break;
            case 2: // sul
                if (linha < 7) {
                    this.posicao.setLinha(linha + 2);
                } else {
                    // this.vivo = false;
                    return false;
                }
                System.out.println("F2 movimenta duas casas sul");
                break;
            case 3: // leste
                if (coluna < 7) {
                    this.posicao.setColuna(coluna + 2);
                } else {
                    // this.vivo = false;
                    return false;
                }
                System.out.println("F2 movimenta duas casas leste");
                break;
            case 4: // oeste
                if (coluna > 1) {
                    this.posicao.setColuna(coluna - 2);
                } else {
                    // this.vivo = false;
                    return false;
                }
                System.out.println("F2 movimenta duas casas oeste");
                break;
            default:
                break;
        }
        return true;
    }
}