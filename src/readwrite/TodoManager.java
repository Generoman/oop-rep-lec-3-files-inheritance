package readwrite;

import java.io.IOException;
import java.util.ArrayList;

public class TodoManager {

    public static void main(String[] args) {

        // Siden vi har to metoder som kaster exceptions, må vi enten ha en
        // try/catch-blokk, eller bruke nøkkelordet "throws" i metodesignaturen.
        // Her har jeg valgt å bruke try/catch. Hvis jeg hadde brukt "throws"-
        // nøkkelordet, her hadde programmet kræsjet når den støtte på en
        // exception i main-metoden
        try {

            // Henter inn en ArrayList av TodoItems fra fil.
            // Legg merke til at denne metoden kaster en FileNotFoundException.
            // Siden FileNotFoundException arver fra IOException, trenger vi bare
            // å fange IOException i vår catch-blokk senere
            ArrayList<TodoItem> todoList = TodoFileHandler.readFromFile();

            // Oppretter et TodoMenuHandler-objekt med todoList i konstruktøren
            TodoMenuHandler menu = new TodoMenuHandler(todoList);

            // Kjører showMenu-metoden
            menu.showMenu();

            // Skriver endringer tilbake til fil når showMenu-metoden er ferdig å
            // kjøre. writeToFile-metoden kaster en IOException, som fanges i catch-blokka
            TodoFileHandler.writeToFile(menu.getTodoList());

        // Legg merke til at det er fullstendig uviktig hva vi kaller våre eceptions
        } catch (IOException ohGodEveryThingIsOnFire) {

            System.out.println("Fil ikke funnet");

            // Printer ut feilmeldingen generert av IOException
            ohGodEveryThingIsOnFire.printStackTrace();
        }
    }
}
