public abstract class FakeNews extends Componente implements Movimento {
    protected boolean vivo;

    public FakeNews(String nome, int x, int y) {
        super(nome, x, y);
        vivo = true;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void verificaMovimento(Setor setor) {
        if (setor.getJogador() == null || setor.getFakeNews() != null || setor.isRestrito()) {
            this.vivo = false;
        } else if (setor.getItem() != null) {
            setor.setItem(null);
        }
    }

    /* public String getNome();
    public void movimenta();
    public void elimina(); */
}