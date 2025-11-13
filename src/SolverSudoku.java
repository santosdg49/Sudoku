public class SolverSudoku {
    private static boolean encontrou;

    public void resolver(Tabuleiro t, int linha, int coluna){
        if(encontrou){
            return;
        }

        if(linha == 9){
            t.imprimir_tabuleiro();
            encontrou = true;
            return;
        }

        int proxima_linha = linha;

        if(coluna == 8){
            proxima_linha = linha + 1;
        }

         int proxima_coluna =(coluna + 1) % 9;

        if(t.getGrid()[linha][coluna].isFixa()){
            resolver(t, proxima_linha, proxima_coluna);
            return;
        }

        for(int i = 1; i <= 9; i++){
            if(t.Valido(i, linha, coluna)){
                t.setValorMaquina(linha, coluna, i);
                resolver(t, proxima_linha, proxima_coluna);
                if(encontrou) return;
                t.getGrid()[linha][coluna].setValor(-1);

            }
        }
    }
}
