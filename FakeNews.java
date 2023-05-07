public abstract class FakeNews extends Componente implements Movimento {
    protected boolean vivo;

    public FakeNews(String nome, int x, int y) {
        super(nome, x, y);
        vivo = true;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    /* public void verificaMovimento(Setor setor) {
        if (setor.getFakeNews() != null || setor.isRestrito()) {
            this.vivo = false;
        }
    } */

    /* public String getNome();
    public void movimenta();
    public void elimina(); */
}