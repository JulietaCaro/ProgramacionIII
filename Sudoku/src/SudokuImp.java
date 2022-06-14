public class SudokuImp implements SudokuTDA{
    private static final int TAM_TABLERO =  9;
    int [][] tablero;

    @Override
    public int[][] InicializarSudoku() {
        tablero = new int[][]{
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        return tablero;
    }

    @Override
    public void Agregar(int numero, int x, int y) {
        tablero[x][y] = numero;
    }

    @Override
    public void Sacar(int x, int y) {
        tablero[x][y] = 0;
    }

    private static boolean HayNumEnFila(int[][] tablero, int numero, int fila){
        for(int i = 0; i < TAM_TABLERO; i++){
            if (tablero[fila][i] == numero)
                return true;
        }
        return  false;
    }

    private static boolean HayNumEnColumna(int[][] tablero, int numero, int columna){
        for (int i = 0; i < TAM_TABLERO; i++){
            if (tablero[i][columna] == numero)
                return true;
        }
        return false;
    }

    private static boolean HayNumEnCaja(int[][] tablero, int numero, int fila, int columna){
        int filaCaja = fila - fila % 3;
        int columnaCaja = columna - columna % 3;

        for (int i = filaCaja; i < filaCaja + 3; i++){
            for (int j = columnaCaja; j < columnaCaja + 3; j++){
                if (tablero[i][j] == numero)
                    return true;
            }
        }
        return false;
    }

    private static boolean EsPosicionValida(int[][] tablero, int numero, int fila, int columna){
        return !HayNumEnFila(tablero, numero, fila) &&
                !HayNumEnColumna(tablero, numero, columna) &&
                !HayNumEnCaja(tablero, numero, fila, columna);
    }

    @Override
    public boolean Resolver(int[][] tablero) {
        for(int fila = 0; fila < TAM_TABLERO; fila++){
            for (int columna = 0; columna < TAM_TABLERO; columna++){
                if(tablero[fila][columna] == 0){
                    for(int numIntentar = 1; numIntentar <= TAM_TABLERO; numIntentar++){
                        if(EsPosicionValida(tablero, numIntentar, fila, columna)){ //el num es valido en esa pos y hace bt
                            Agregar(numIntentar, fila, columna);

                            if(Resolver(tablero)){
                                return true;
                            }
                            //el numero no es valido
                            else{
                                Sacar(fila, columna);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void Mostrar(int[][] tablero){
        for(int fila = 0; fila < TAM_TABLERO; fila++){
            if(fila % 3 == 0 && fila != 0)
                System.out.println("-----------");
            for(int columna = 0; columna < TAM_TABLERO; columna++){
                if(columna % 3 == 0 && columna != 0)
                    System.out.println("|");
                //agregar if numero == 0
                System.out.println(tablero[fila][columna]);
            }
            System.out.println();
        }
    }

    @Override
    public void Revertir(int numero, int x, int y) {

    }

    public void Limpiar(int [][] tablero){
        for (int fila = 0; fila < TAM_TABLERO; fila++){
            for(int columna = 0; columna < TAM_TABLERO; columna++){
                Sacar(fila, columna);
            }
        }
    }
}
