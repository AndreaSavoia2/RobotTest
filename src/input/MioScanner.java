package input;

import java.util.Scanner;

public class MioScanner {

    private static Scanner tastiera = new Scanner(System.in);

    public String leggiStringa(String domanda){
        System.out.println(domanda);
        String risposta = tastiera.nextLine();
        return risposta;
    }

    public String leggiStringaLow(String domanda){
        System.out.println(domanda);
        String risposta = tastiera.nextLine().toLowerCase();
        return risposta;
    }

    public String leggiStringaUp(String domanda){
        System.out.println(domanda);
        String risposta = tastiera.nextLine().toUpperCase();
        return risposta;
    }

    public char leggiChar(String domanda){
        System.out.println(domanda);
        char risposta = tastiera.next().charAt(0);
        return risposta;
    }

    public int LeggiInt(String domanda){
        System.out.println(domanda);
        int intero = tastiera.nextInt();
        tastiera.nextLine();
        return intero;
    }

    public int LeggiIntSeVero(String domanda){
        System.out.println(domanda);
        while(!tastiera.hasNextInt()){
            System.out.println("Inserisci un numero intero valido");
            System.out.println(domanda);
            tastiera.nextLine();
        }
        int intero = tastiera.nextInt();
        tastiera.nextLine();
        return intero;
    }

    public double LeggiDouble(String domanda){
        System.out.println(domanda);
        double doppio = tastiera.nextDouble();
        tastiera.nextLine();
        return doppio;
    }

    public double LeggiDoubleSeVero(String domanda){
        System.out.println(domanda);
        while(!tastiera.hasNextDouble()){
            System.out.println("Inserisci un numero decimale valido");
            System.out.println(domanda);
            tastiera.nextDouble();
        }
        double doppio = tastiera.nextDouble();
        tastiera.nextLine();
        return doppio;
    }
}