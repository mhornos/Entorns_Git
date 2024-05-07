import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main0 {
    static Scanner scan = new Scanner(System.in);

    /*
    1. Preguntar quants alumnes
    2. Demanar noms de cada alumne
    3. Demanar notes
    4. Quin alumne te la nota mes alta?
    5. Quins alumnes han suspes?
    */

    public static void main(String[] args) {
        int[] nota = new int[0];
        String[] nom = new String[0];
        boolean nAlumnesDemanat = false;
        boolean nomsDemanats = false;
        boolean notesDemanades = false;
        int nAlumnes = 0;

        int opcio;
        do {
            System.out.println(
                    "\n    1. Preguntar quants alumnes\n" +
                            "    2. Demanar noms\n" +
                            "    3. Demanar notes\n" +
                            "    4. Quin alumne te la nota mes alta?\n" +
                            "    5. Posicó dels alumnes han suspes?\n" +
                            "    6. Noms dels alumnes supesos\n" +
                            "    0. Acabar");
            System.out.print("Entra una opció (0-5): ");
            opcio = scan.nextInt();
            scan.nextLine();
            switch (opcio) {
                case 1:
                    nAlumnes = demanarnAlumnes(nAlumnes);
                    nota = new int[nAlumnes];
                    nom = new String[nAlumnes];
                    nAlumnesDemanat = true;
                    break;
                case 2:
                    if (nAlumnesDemanat) {
                        demanarNoms(nAlumnes, nom);
                        nomsDemanats = true;
                    } else System.out.println("No has omplert la quantitat d'alumnes");
                    break;
                case 3:
                    if (nAlumnesDemanat) {
                        demanarNotes(nAlumnes, nota);
                        notesDemanades = true;
                    } else System.out.println("No has omplert la quantitat d'alumnes");
                    break;
                case 4:
                    if (nAlumnesDemanat){
                        if (nomsDemanats & notesDemanades){
                            notaMesAlta(nAlumnes, nota, nom);
                        } else System.out.println("No has omplert els noms i les notes");
                    }
                    else System.out.println("No has omplert la quantitat d'alumnes");
                    break;
                case 5:
                    if (nAlumnesDemanat) {
                        if (nomsDemanats & notesDemanades) {
                            alumnesSuspesos(nAlumnes, nota, nom);
                        } else System.out.println("No has omplert els noms i les notes");
                    } else System.out.println("No has omplert la quantitat d'alumnes");
                    break;
                case 6:
                    if (nAlumnesDemanat) {
                        if (nomsDemanats & notesDemanades) {
                            nomsDeSuspesos(nAlumnes, nota, nom);
                        } else System.out.println("No has omplert els noms i les notes");
                    } else System.out.println("No has omplert la quantitat d'alumnes");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 5");
            }
        } while (opcio != 0);
    }


    static boolean notaCorrecte(int nota) {
        return nota >= 0 && nota <= 10;

    }

    static int demanarnAlumnes(int nAlumnes){
        //demanar quants alumnes
        System.out.println("\n(1) Quants alumnes? ");
        nAlumnes = scan.nextInt();

        while (nAlumnes <= 0){
            System.out.println("Quantitat d'alumnes incorrecte");
            System.out.print("Quants alumnes? ");
            nAlumnes = scan.nextInt();
        }
        return nAlumnes;
    }

    static void demanarNoms(int nAlumnes, String [] nom){
        //demanar noms
        for (int i = 0; i < nAlumnes;) {
            System.out.println("\n(2) Introudeix el nom de l'alumne "  + (i+1) + ": ");
            nom[i] = scan.next();
            i++;
        }

    }

    static void demanarNotes(int nAlumnes, int[] nota){
        //demanar notas
        for (int i = 0; i < nAlumnes;) {
            System.out.println("\n(3)Introudeix la nota de l'alumne "  + (i+1) + ": ");
            nota[i] = scan.nextInt();
            while (!notaCorrecte(nota[i])) {
                System.out.println("Nota incorrecta. Torna a introudir la nota de l'alumne " + (i+1) + ":");
                nota[i] = scan.nextInt();
            }
            i++;
        }

    }

    static int notaMesAlta (int nAlumnes, int[] nota, String[] nom){
        //nota mes alta
        int notaMesAlta=0;
        for (int i = 0; i < nAlumnes; i++) {
            if (nota[i]>notaMesAlta) notaMesAlta=nota[i];
        }
        System.out.println("\n(4) Nota mes alta = " + notaMesAlta);

        System.out.println("Alumnes amb aquesta nota: ");
        for (int i = 0; i < nAlumnes; i++) {
            if(nota[i]==notaMesAlta) System.out.println("· " + nom[i]);
        }

        System.out.println();
        return notaMesAlta;
    }

    static ArrayList<Integer> alumnesSuspesos(int nAlumnes, int[] nota, String[] nom){

        ArrayList<Integer> idxAlumnesSuspesos = new ArrayList<>();

        System.out.println("\n(5) Posició d'alumnes que han suspès: ");
        for (int i = 0; i < nAlumnes; i++) {
            if (nota[i] < 5) {
                idxAlumnesSuspesos.add(i);
            }
        }

        System.out.println((idxAlumnesSuspesos));
        System.out.println();
        return  idxAlumnesSuspesos;
    }

    static void nomsDeSuspesos(int nAlumnes, int[] nota, String[] nom){
        System.out.println("\n(6) Noms d'alumnes que han suspès: ");
        for (int i = 0; i < nAlumnes ; i++) {
            if (nota[i]<5) {
                System.out.println("· " + nom[i] + " amb un " + nota[i]);
            }
        }
    }


}