
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        
        final int nAlumnos = 6;
        final int nUfs = 4;

        int [][] notes = new int[nAlumnos][nUfs+1];
        String[] noms = new String[nAlumnos];

        leerNotasyNombrePorUfs(nAlumnos, nUfs, notes, noms);

    }


    static void leerNotasyNombrePorUfs (int nAlumnos, int nUfs, int[][] notes, String []noms){
        for (int i = 0; i < nAlumnos; i++) {
            noms[i] = scan.next();
            leerNotasPorAlumno(nUfs, notes, i);
            notes[i][4] = (int) calcularMedia(nUfs, notes,i);


        }
        System.out.println("noms = " + Arrays.toString(noms));
        System.out.println("notes = " + Arrays.deepToString(notes));
    }

    static void leerNotasPorAlumno(int nUfs, int [][] notes, int i){
        for (int j = 0; j < nUfs; j++) {
            notes[i][j]= scan.nextInt();
        }
    }


    static double calcularMedia(int nUfs, int [][] notes, int j){
        double notaMedia=0;

        for (int i = 0; i < nUfs; i++) {
            notaMedia = notaMedia + notes[i][j];
        }
        if (notaMedia >=5){
            notaMedia = Math.round(notaMedia /nUfs);
        } else {
            notaMedia = Math.floor(notaMedia /nUfs);
        }

        return  notaMedia;
    }

    static void mostrarNotasFormato(int nAlumnos, int nUfs, int[][] notes, String []noms){
        for (int i = 0; i < nAlumnos; i++) {
            for (int j = 0; j < nUfs; j++) {
            }
        }
    }

}