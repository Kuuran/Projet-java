package Tv_parse;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


/**
 * Main class
 */
public class Main {

    /**
     * Main loop of the application.
     * @param args Arguments given to the application (might be used to toggle the GUI).
     * @throws FileNotFoundException In case {@link Parser#Parser(String)} throws an exception.
     * @throws XMLStreamException In case {@link Parser#run(Tv)} throws an exception.
     * @throws ParseException In case {@link Parser#run(Tv)} throws an exception.
     */
    public static  void main(String[] args) throws XMLStreamException, ParseException, InterruptedException, IOException {




        Parser parser = new Parser("input/tvguide.xml");
        Tv tv = new Tv();
        parser.run(tv);

        System.out.println("################################################################\nTest d'affichage de la liste des chaines : \n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_channel_list();

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();


        System.out.println("################################################################\nTest d'affichage de la liste des programmes : \n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_program_list();

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();

        System.out.println("################################################################\nTest d'affichage d'un programme :\n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_program("Cosmos : une odyssée à travers l'univers");

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();

        System.out.println("################################################################\nTest d'affichage de la programmation d'une chaine :\n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_channel_programmation("C119.api.telerama.fr");

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();

        System.out.println("################################################################\nTest d'affichage des jours contenant des diffusions :\n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_days_with_broadcast();

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();

        System.out.println("################################################################\nTest d'affichage des diffusions à une date précise :\n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        Date date = new Date(2018, 1, 1);
        tv.print_broadcasts_at_date(date);

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();

        System.out.println("################################################################\nTest d'affichage des films dans lesquels un artiste joue :\n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_films_from_actor("Mauricio Dias");

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();

        System.out.println("################################################################\nTest d'affichage des catégories CSA par chaine :\n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_CSA_per_channel();

        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();

        System.out.println("################################################################\nTest d'affichage de la liste des acteurs :\n################################################################");
        System.out.println("\nAppuyez sur une touche pour continuer.");
        System.in.read();
        tv.print_actors();

        System.out.println("\nAppuyez sur une touche pour continuer. (fin)");
        System.in.read();


    }

}
