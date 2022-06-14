public interface SudokuTDA {
    int[][] InicializarSudoku();

    void Agregar(int numero, int x, int y); //siempre que exista sudoku

    void Sacar(int x, int y); //siempre que exista sudoku
                              //coordenadas validas
                              //debe haber un num en esa posicion

    boolean Resolver(int[][] tablero); //siempre que exista sudoku

    void Mostrar(int[][] tablero);

    void Revertir(int numero, int x, int y);

    void Limpiar(int[][] tablero);
}
