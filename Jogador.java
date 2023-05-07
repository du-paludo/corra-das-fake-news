public class Jogador extends Componente implements Movimento {
    private boolean vivo;
    private Item item;

    public Jogador(String nome, int linha, int coluna) {
        super(nome, linha, coluna);
        this.item = null;
        this.vivo = true;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getNome() {
        return nome;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void movimenta(int movimento) {
        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();
        switch (movimento) {
            case 1: // norte
                if (linha > 0) {
                    this.posicao.setLinha(linha - 1);
                } else {
                    this.vivo = false;
                }
                break;
            case 2: // sul
                if (linha < 8) {
                    this.posicao.setLinha(linha + 1);
                } else {
                    this.vivo = false;
                }
                break;
            case 3: // leste
                if (coluna < 8) {
                    this.posicao.setColuna(coluna + 1);
                } else {
                    this.vivo = false;
                }
                break;
            case 4: // oeste
                if (coluna > 0) {
                    this.posicao.setColuna(coluna - 1);
                } else {
                    this.vivo = false;
                }
                break;
            default:
                break;
        }
    }

    public void verificaMovimento(Setor setor) {
        if (setor.isRestrito() || setor.getFakeNews() != null) {
            this.vivo = false;
            System.out.println("Você morreu!");
        }
        if (setor.getItem() != null) {
            this.item = setor.getItem();
            setor.setItem(null);
        }
    }

    public void usarDenunciar(Setor[][] tabuleiro) {
        int linhaJogador = getPosicao().getLinha();
        int colunaJogador = getPosicao().getColuna();

        for (int linha = linhaJogador - 1; linha <= linhaJogador + 1; linha++) {
            if (linha > 8 || linha < 0) {
                continue;
            }
            for (int coluna = colunaJogador - 1; coluna <= colunaJogador + 1; coluna++) {
                if (coluna > 8 || coluna < 0) {
                    continue;
                }
                if (tabuleiro[linha][coluna].getFakeNews() != null) {
                    tabuleiro[linha][coluna].getFakeNews().setVivo(false);
                    tabuleiro[linha][coluna].setFakeNews(null);
                }
            }
        }
    }

    public void usarFugir(int linha, int coluna) {
        this.posicao.setLinha(linha - 1);
        this.posicao.setColuna(coluna - 1);
    }
}