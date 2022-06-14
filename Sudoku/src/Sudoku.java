public class Sudoku {
    public static void main(String[] args){
        SudokuImp tablero = new SudokuImp();
        tablero.InicializarSudoku();
        tablero.Resolver(tablero);
    }
}
