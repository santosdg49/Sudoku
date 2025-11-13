import java.io.*;

public class ArquivoSudoku {

    public void salvar(Tabuleiro t){
        try(FileOutputStream jogo = new FileOutputStream("Arquivo_Sudoku")){
            ObjectOutputStream out = new ObjectOutputStream(jogo);
            out.writeObject(t);
            System.out.println("Jogo salvo com sucesso!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Tabuleiro Carregar_jogo(){
        Tabuleiro tabuleiro = null;
        try(FileInputStream jogo = new FileInputStream("Arquivo_Sudoku")){
            ObjectInputStream in = new ObjectInputStream(jogo);
            tabuleiro = (Tabuleiro) in.readObject();
            System.out.println("Jogo carregado com sucesso!");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tabuleiro;
    }

}
