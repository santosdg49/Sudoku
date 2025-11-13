import java.io.Serializable;

public class Celula implements Serializable {
    private int linha;
    private int coluna;
    private int valor;
    private boolean fixa;

    public Celula(int linha, int coluna, int valor) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }


    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public int getValor() {
        return valor;
    }

    public boolean isFixa() {
        return fixa;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setFixa(boolean fixa) {
        this.fixa = fixa;
    }


}
