package readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoFileHandler {

    // Et field som holder på filen som brukes til lesing/skriving.
    // Fieldet er static fordi jeg har to static metoder som bruker det -
    // om en static metode skal bruke et field, må fieldet også være static
    private static File file = new File("resources/todolist.txt");

    // En static metode som returnerer en ArrayList av TodoItems fra fil.
    // Metoden kaster en exception som blir fanget opp i main-metoden.
    // Til tross for at main-metoden bare fanger IOExceptions, vil dette
    // fortsatt fungere, siden FileNotFoundException arver fra IOException
    public static ArrayList<TodoItem> readFromFile() throws FileNotFoundException {

        // Oppretter en tom ArrayList av TodoItems
        ArrayList<TodoItem> todoList =  new ArrayList<>();

        // Oppretter et scanner-objekt som skal lese fra fil
        Scanner scanner = new Scanner(file);

        // En while-loop som kjører så lenge scanneren har en linje å lese
        while (scanner.hasNextLine()) {

            // Utifra strukturen på .txt-filen vi leser fra, vet vi at den første
            // linja er navnet på gjøremålet vi skal lagre i ArrayLista
            String itemName = scanner.nextLine();

            // Andre linje er informasjon om gjøremålet er gjort eller ikke.
            // Fordi dette lagres som en boolean, må vi omgjøre det fra String,
            // siden nextLine-metoden bare returnerer strings
            boolean isDone = Boolean.parseBoolean(scanner.nextLine());

            // Til slutt har vi en linje med tre bindestreker. Denne skal ikke
            // lagres, men må leses for at det ikke skal havne på feil sted
            scanner.nextLine();

            // Deretter legger vi til en ny TodoItem i ArrayLista basert på
            // informasjonen vi har hentet inn fra fila
            todoList.add(new TodoItem(itemName, isDone));
        }

        // Lukker scanneren for å unngå ressurslekkasje
        scanner.close();

        // Returnerer til slutt ArrayLista
        return todoList;
    }

    // En static metode som skriver informasjon til fil fra en ArrayList av TodoItems.
    // Metoden kaster en exception som blir fanget opp i main-metoden
    public static void writeToFile(ArrayList<TodoItem> todoList) throws IOException {

        // Oppretter et FileWriter-objekt som skal brukes til å skrive til fil
        FileWriter writer = new FileWriter(file);

        // En forEach-loop som går gjennom alle elementer i ArrayLista vår
        for (TodoItem item : todoList) {

            // Skriver en linje for navnet på gjøremålet.
            // "\n" er på slutten av hver linje for at alt ikke skal havne
            // på en og samme linje. Prøv å fjerne "\n" for å se hva som skjer
            writer.write(item.getItemName() + "\n");

            // Skriver en linje for om gjøremålet er gjort
            writer.write(item.isDone() + "\n");

            // Skriver tre bindestreker
            writer.write("---\n");
        }

        // Lukker writeren - om dette ikke gjøres, vil ikke endringene bli lagret,
        // og vi vil ende opp med en tom fil
        writer.close();
    }
}
