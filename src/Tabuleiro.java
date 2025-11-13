import java.io.Serializable;

public class Tabuleiro implements Serializable {
    private Celula[][] grid = new  Celula[9][9];

    public Tabuleiro() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Celula(i, j, -1);
            }
        }
    }


    public void imprimir_tabuleiro(){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j].getValor()!=-1){
                    System.out.print("[" + grid[i][j].getValor()+"]" + "\t");
                }
                else{
                    System.out.print("[-]" + "\t");
                }
            }
            System.out.println();
        }
    }

    public boolean Valido(int valor, int linha, int coluna){
        // checa em cada linha se tem algum número igual ao valor da célula
        for (int i = 0; i<grid.length; i++) {
            if(grid[i][coluna].getValor() == valor){
                return false;
            }
        }
        // checa cada coluna se tem algum valor igual ao da célula
        for (int i = 0; i<grid[linha].length; i++){
            if(grid[linha][i].getValor() == valor){
                return false;
            }
        }

        // checando os blocos 3x3
        int inicioLinha = (linha / 3) * 3;
        int inicioColuna = (coluna / 3) * 3;

        for (int i = inicioLinha; i < inicioLinha + 3; i++) {
            for (int j = inicioColuna; j < inicioColuna + 3; j++) {
                if (grid[i][j].getValor() == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean Completo(){
        for (int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j].getValor() == -1){
                    return false;
                }
            }
        }
        return true;
    }

    public void setValorUsuario(int linha, int coluna, int valor){
        grid[linha][coluna].setValor(valor);
        grid[linha][coluna].setFixa(true);
    }

    public void setValorMaquina(int linha, int coluna, int valor){
        grid[linha][coluna].setValor(valor);
        grid[linha][coluna].setFixa(false);
    }

    public void  Limpar(){
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j].setValor(-1);
                grid[i][j].setFixa(false);
            }
        }
    }

    public Celula[][] getGrid() {
        return grid;
    }

}
