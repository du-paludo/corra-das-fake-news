// import java.util.Random;

public class F1 extends FakeNews {
    public F1(int x, int y) {
        super("F1", x, y);
    }

    public String getNome() {
        return nome;
    }

    public void movimenta(int movimento) {
        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();
        switch (movimento) {
            case 1: // norte
                if (linha > 0) {
                    this.posicao.setLinha(linha - 1);
                } else {
                    //this.vivo = false;
                }
                System.out.println("F1 movimenta uma casa norte");
                break;
            case 2: // sul
                if (linha < 8) {
                    this.posicao.setLinha(linha + 1);
                } else {
                    //this.vivo = false;
                }
                System.out.println("F1 movimenta uma casa sul");
                break;
            case 3: // leste
                if (coluna < 8) {
                    this.posicao.setColuna(coluna + 1);
                } else {
                    //this.vivo = false;
                }
                System.out.println("F1 movimenta uma casa leste");
                break;
            case 4: // oeste
                if (coluna > 0) {
                    this.posicao.setColuna(coluna - 1);
                } else {
                    this.vivo = false;
                }
                System.out.println("F1 movimenta uma casa oeste");
                break;
            default:
                break;
        }
    }
}
