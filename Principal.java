// Eduardo Stefanel Paludo - GRR20210581
// Lucas Neia Torres - GRR20210570
// Natael Pontarolo Gomes - GRR20211786

public class Principal {
    public static void main(String[] arg) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.criarTabuleiro();
        tabuleiro.inserirJogadores();
        tabuleiro.inserirSetoresRestritos();
        tabuleiro.inserirFakeNews();
        tabuleiro.inserirItens();
        tabuleiro.desenharTabuleiro();
    }
}