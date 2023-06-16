public class Jogador extends Componente implements Movimento {
    private Item item;

    public Jogador(String nome, int linha, int coluna) {
        super(nome, linha, coluna);
        this.item = null;
        this.vivo = true;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean movimenta(int movimento) {
        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();
        switch (movimento) {
            case 1: // norte
                if (linha > 0) {
                    this.posicao.setLinha(linha - 1);
                } else {
                    return false;
                }
                break;
            case 2: // sul
                if (linha < 8) {
                    this.posicao.setLinha(linha + 1);
                } else {
                    return false;
                }
                break;
            case 3: // leste
                if (coluna < 8) {
                    this.posicao.setColuna(coluna + 1);
                } else {
                    return false;
                }
                break;
            case 4: // oeste
                if (coluna > 0) {
                    this.posicao.setColuna(coluna - 1);
                } else {
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
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
                    System.out.println("A fake news " + tabuleiro[linha][coluna].getFakeNews().getNome() + " morreu!");
                    tabuleiro[linha][coluna].getFakeNews().setVivo(false);
                    tabuleiro[linha][coluna].setFakeNews(null);
                }
            }
        }
    }

    public void usarFugir(Setor[][] tabuleiro, int linha, int coluna) {
        tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()].setJogador(null);
        this.posicao.setLinha(linha - 1);
        this.posicao.setColuna(coluna - 1);
        tabuleiro[this.posicao.getLinha()][this.posicao.getColuna()].setJogador(this);
    }

    public void usarLer(Jogo jogo) {
        FakeNews fakeNew;
        // elimina fake news aleatória do tabuleiro
        for (int i = 0; i < jogo.getFakeNews().size(); i++) {
            fakeNew = jogo.getFakeNews().get(i);
            if (fakeNew.isVivo()) {
                System.out.println("A fake news " + fakeNew.getNome() + " morreu!");
                jogo.getSetor(fakeNew.posicao.getLinha(), fakeNew.posicao.getColuna()).setFakeNews(null);
                fakeNew.setVivo(false);
                break;
            }
        }
    }
}