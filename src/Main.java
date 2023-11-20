import input.MioScanner;
import model.Robot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MioScanner tastiera = new MioScanner(); // importo la classe scanner custom
        ArrayList<Robot> listaRobot = new ArrayList<>();
        boolean fine = false;
        int selezione;
        int i;

        do{
            switch(tastiera.leggiStringa("\nSeleziona l'operazione da eseguire: \n*1: Aggiungi robot \n*2: Elimina robot \n*3: Test robot \n*4: Lista robot \n*5: esci")){

                // aggiungi robot
                case "1" -> {

                    boolean robotTrovato = false;
                    i=0;
                    selezione=tastiera.LeggiIntSeVero("Iserisci un codice numerico identificativo per il robot");

                    if(listaRobot.isEmpty()){
                        listaRobot.add(new Robot(selezione, tastiera.LeggiIntSeVero("Iserisci coordinate X di partenza"), tastiera.LeggiIntSeVero("Iserisci coordinate Y di partenza")));
                        System.out.println("Robot creato.");
                    }else{
                        do{
                            if (listaRobot.get(i).getCodice() == selezione) {
                                robotTrovato = true;
                            }
                            i++;
                        }while(!robotTrovato &&  i<listaRobot.size());

                        if (robotTrovato) {
                            System.out.println("Eiste gia un robot con questo codice");
                        } else {
                            listaRobot.add(new Robot(selezione, tastiera.LeggiIntSeVero("Iserisci coordinate X di partenza"),tastiera.LeggiIntSeVero("Iserisci coordinate Y di partenza")));
                            System.out.println("Robot creato.");
                        }
                    }
                }

                // elimina robot
                case "2" -> {

                    boolean robotTrovato = false;
                    i=0;

                    if(listaRobot.isEmpty()){
                        System.out.println("Non ci sono robot nella lista");
                    } else {
                        selezione = tastiera.LeggiIntSeVero("Iserisci codice robot da eliminare");
                        do{

                            if (listaRobot.get(i).getCodice() == selezione) {
                                listaRobot.remove(i);
                                robotTrovato = true;
                            }
                            i++;

                        }while(!robotTrovato &&  i<listaRobot.size());

                        if (robotTrovato) {
                            System.out.println("Robot eliminato");
                        } else {
                            System.out.println("Nessun robot trovato con il codice specificato.");
                        }
                    }
                }

                // test robot
                case "3" -> {

                    boolean robotTrovato = false;
                    i=0;
                    int indiceRobot = -1;

                    if(listaRobot.isEmpty()){
                        System.out.println("Non ci sono robot nella lista");
                    }else{
                        selezione = tastiera.LeggiIntSeVero("Iserisci codice robot da testare");
                        do{
                            if (listaRobot.get(i).getCodice() == selezione) {
                                robotTrovato = true;
                                indiceRobot = i;
                            }
                            i++;
                        }while(!robotTrovato &&  i<listaRobot.size());

                        if (robotTrovato) {
                            char[] comandi = tastiera.leggiStringaUp("Inserisci la serie di comandi per il robot (es: EENOOSN):\n* N: Nord \n* S: Sud\n* E: Est\n* O: Ovest").toCharArray();

                            for(int j=0;j<comandi.length;j++){

                                // muove il robot in base al char presente in i
                                switch (comandi[j]){
                                    case 'N' -> listaRobot.get(indiceRobot).nord();
                                    case 'S' -> listaRobot.get(indiceRobot).sud();
                                    case 'E' -> listaRobot.get(indiceRobot).est();
                                    case 'O' -> listaRobot.get(indiceRobot).ovest();
                                }

                            }
                            System.out.println(listaRobot.get(indiceRobot).toString());
                        } else {
                            System.out.println("Nessun robot trovato con il codice specificato.");
                        }
                    }
                }

                // stampa lista robot
                case "4" -> {
                    for(int j=0; j<listaRobot.size(); j++){
                        System.out.println(listaRobot.get(j));
                    }
                }

                // esci
                case "5" -> fine = true;

                // errore
                default -> System.out.println("Valore non valido");

            }
        }while(!fine);
    }
}