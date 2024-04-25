
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        
        final int nAlumnos = 6;
        final int nUfs = 4;

        int [][] notes = new int[nAlumnos][nUfs];

        llegirTot(nAlumnos, nUfs, notes);

    }

    static void llegirTot (int nAlumnos, int nUfs, int[][] notes){
        leerNotasUfs(nAlumnos, nUfs, notes);
    }


    static int[][] leerNotasUfs (int nAlumnos, int nUfs, int[][] notes){
        for (int i = 0; i < nAlumnos; i++) {
                leerNotasPorAlumno(nUfs, notes, i);
        }
        System.out.println("notes = " + Arrays.deepToString(notes));
        return notes;
    }

    static void leerNotasPorAlumno(int nUfs, int [][] notes, int i){
        for (int j = 0; j < nUfs; j++) {
            notes[i][j]= scan.nextInt();
        }
    }
}