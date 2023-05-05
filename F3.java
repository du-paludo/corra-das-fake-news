public class F3 extends FakeNews {
    public F3(int x, int y) {
        super("F3", x, y);
    }

    public String getNome() {
        return nome;
    }

    public void elimina() {

    }

    public void movimenta(int movimento) {
        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();
        switch (movimento) {
            case 1: // noroeste
                if ((linha > 0) && (coluna > 0)) {
                    this.posicao.setLinha(linha - 1);
                    this.posicao.setColuna(coluna - 1);
                } else {
                    this.vivo = false;
                }
                System.out.println("F3 movimenta uma casa noroeste");
                break;
            case 2: // nordeste
                if ((linha > 0) && (coluna < 8)) {
                    this.posicao.setLinha(linha - 1);
                    this.posicao.setColuna(coluna + 1);
                } else {
                    this.vivo = false;
                }
                System.out.println("F3 movimenta uma casa nordeste");
                break;
            case 3: // sudoeste
                if ((linha < 8) && (coluna > 0)) {
                    this.posicao.setColuna(coluna + 1);
                    this.posicao.setLinha(linha + 1);
                } else {
                    this.vivo = false;
                }
                System.out.println("F3 movimenta uma casa sudoeste");
                break;
            case 4: // sudeste
                if ((linha < 8) && (coluna < 8)) {
                    this.posicao.setLinha(linha + 1);
                    this.posicao.setColuna(coluna - 1);
                } else {
                    this.vivo = false;
                }
                System.out.println("F3 movimenta uma casa sudeste");
                break;
            default:
                break;
        }
    }
}