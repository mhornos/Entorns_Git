import java.util.Scanner;

public class Main2 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int filas = 0, columnas=0, opcio;
        String [][] tablero = new String[0][];

        do {
            System.out.println("MENU");
            System.out.println("   1. Pedir filas y columnas\n" +
                    "   2. Borrar tablero\n" +
                    "   3. Rellenar diagonal\n" +
                    "   4. Rellenar doble diagonal\n" +
                    "   3. Rellenar fila N\n" +
                    "   6. Rellenar columna N\n" +
                    "   7. Dibujar tablero\n" +
                    "   0. Acabar");

            System.out.println("Que quieres hacer? ");
            opcio = scan.nextInt();
            switch (opcio) {
                case 1: {
                    pedirFC(filas, columnas);
                    System.out.println("filas=" + filas);
                    System.out.println("columnas=" + columnas);
                    break;
                }
                case 2: {
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            tablero[i][j] = "";
                        }
                    }
                }
                case 3: {
                    //diagonal simple
                    tablero = new String[filas][columnas];
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            if (i == j) tablero[i][j] = "*";
                            else tablero[i][j] = " ";
                        }
                    }
                    break;
                }

                case 4: {
                    //diagonal doble
                    tablero = new String[filas][columnas];
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            if (true) tablero[i][j] = "*";
                            else tablero[i][j] = " ";
                        }
                    }
                    dibujarTodasLasFilas(tablero, filas);
                    break;
                }

                case 7: {
                    dibujarTodasLasFilas(tablero, filas);
                    break;
                }
                case 0: System.exit(0);

                default: {
                    System.out.println("error");
                    break;
                }
            }
        } while(opcio != 0);




        //System.out.print("Que fila quieres mostrar? ");
        //int fila = scan.nextInt();
        //fila = fila - 1;
        //System.out.print("Cual será el caracter de separación? ");
        //char separador = scan.next().charAt(0);


        //dibujarFila(tablero, fila, separador);
        //dibujarFilaJoin(tablero,fila);

    }

    /*static void dibujarFila (String [][] tablero, int fila, char separador){
        for (int i = 0; i < tablero[fila].length-1; i++) {
            System.out.print(tablero[fila][i]);
            System.out.print(separador);
        }
        System.out.print(tablero[fila][tablero[fila].length-1]);
    }*/

    static void dibujarFilaJoin (String [][] tablero, int fila){
        String sFila = String.join("  ", tablero[fila]);
        System.out.println(sFila);
    }

    static void dibujarTodasLasFilas(String [][] tablero, int filas){
        for (int i = 0; i < filas; i++) {
            dibujarFilaJoin(tablero,i);
        }
    }

    static void pedirFC(int filas, int columnas){
        System.out.print("Cuantas filas? ");
        filas = scan.nextInt();
        System.out.print("Cuantas columnas? ");
        columnas = scan.nextInt();
    } 
}
