package readwrite;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoMenuHandler {

    // FIELDS

    private ArrayList<TodoItem> todoList;



    // CONSTRUCTOR

    public TodoMenuHandler(ArrayList<TodoItem> todoList) {
        this.todoList = todoList;
    }



    // GETTERS/SETTERS

    public ArrayList<TodoItem> getTodoList() {
        return todoList;
    }



    // PUBLIC METHODS

    // En metode for å vise menyen, og for å behandle menyvalg
    public void showMenu() {

        // En boolean-verdi som avgjør om while-loopen på linje 45
        // skal fortsette å kjøre
        boolean running = true;

        // Et scanner-objekt som skal lese brukerinput fra konsollen.
        // Denne brukes igjen i flere andre metoder
        Scanner scanner = new Scanner(System.in);

        // En while-loop som kjører så lenge bruker ikke har valgt å avslutte
        // applikasjonen
        while (running) {

            // Printer en liste over menyalternativ til konsollen
            System.out.println("\n1 - Vis liste over gjøremål");
            System.out.println("2 - Legg til nytt gjøremål");
            System.out.println("3 - Sett et gjøremål som gjort");
            System.out.println("4 - Fjern et gjøremål");
            System.out.println("5 - Avslutt");

            // Tar vare på brukerinput for å kjøre riktig menyvalg i switch-
            // statement på linje 59
            String choice = scanner.nextLine();

            // Switch-statement som kjører menyvalg utifra brukerinput
            switch (choice) {
                case "1" -> showFullList();
                // Legg merke til at jeg sender inn scanner-objektet som
                // argument til de tre neste metodene, siden de også er
                // avhengig av brukerinput. Dette gjør jeg for å unngå
                // en egen scanner for hver eneste metode, som potensielt
                // kan føre til en del problemer
                case "2" -> addItem(scanner);
                case "3" -> setItemAsDone(scanner);
                case "4" -> removeItem(scanner);
                case "5" -> {
                    // Når bruker har valgt å avslutte, settes running til
                    // false, sånn at loopen slutter å kjøre
                    running = false;
                    System.out.println("Ha en fin dag!");
                }
                // Hvis brukeren velger et ugyldig menyalternativ, bruker vi
                // default-nøkkelordet på samme måte som en else på slutten av
                // en rekke if/else if-statements
                default -> System.out.println("Velg et gyldig menyalternativ");
            }
        }

        // Når loopen har kjørt ferdig, lukker vi scanner-objektet
        scanner.close();
    }



    // PRIVATE METHODS

    // Siden alle disse metodene bare blir kalt inne i denne klassen,
    // kan de like greit være private

    // En metode som printer ut lista over gjøremål til konsollen
    private void showFullList() {

        // Standard for-loop for å gå gjennom alle elementer i en ArrayList
        for (int i = 0; i < todoList.size(); i++) {

            // Her bruker jeg StringBuilder istedenfor String, siden
            // StringBuilder er mindre ressurskrevende enn å endre
            // en String flere ganger
            StringBuilder itemString = new StringBuilder();

            // Legger til tallet i+1 (0+1 for første gjennomkjøring,
            // 1+1 for andre, osv) og et mellomrom for å få et tall
            // ved siden av navnet på gjøremålet. Om jeg hadde brukt
            // bare i, ville jeg fått indeksen, som starter på 0. Jeg
            // ønsker en liste som er lettere å forstå for mennesker -
            // derfor bruker jeg i+1.
            // StringBuilder sin append-metode brukes for å legge til
            // noe på slutten av teksten vi skal sette sammen
            itemString.append(i + 1);
            itemString.append(" ");

            // Legger til en boks etter tallet. Boksen er enten avkrysset
            // eller ikke, avhengig av om done-fieldet er true eller ikke
            if (todoList.get(i).isDone()) {
                itemString.append("[x] ");
            } else {
                itemString.append("[ ] ");
            }

            // Legger til navnet på gjøremålet på slutten av teksten
            itemString.append(todoList.get(i).getItemName());

            // Gjør StringBuilder-objektet om til en vanlig String
            String itemStringResult = itemString.toString();

            // Printer ut stringen
            System.out.println(itemStringResult);
        }
    }

    // Printer ut alle ikke-gjorte gjøremål
    private void showNotDoneList() {

        // Standard for-loop for å gå gjennom alle elementer i en ArrayList
        for (int i = 0; i< todoList.size(); i++) {

            // Hvis done-fieldet er satt til å være false, skal elementet
            // printes på nesten samme måte som i showFullList-metoden.
            // Kunne også vært skrevet som dette:
            // if (todolist.get(i).isDone() == false) ...
            if (!todoList.get(i).isDone()) {

                // Bruker String istedenfor StringBuilder her for
                // enkelthetens skyld
                String itemString = (i+1) + " [ ] " + todoList.get(i).getItemName();

                // Printer stringen til konsollen
                System.out.println(itemString);
            }
        }
    }

    // Metode for å legge til nytt element i lista.
    // Legg merke til at denne metoden tar inn et scanner-objekt. Som nevnt
    // er dette for å spare trøbbel og ressurser
    private void addItem(Scanner scanner) {

        System.out.println("Skriv inn navn på gjøremål:");

        // Tar inn input fra bruker for å opprette et navn på et gjøremål
        String name = scanner.nextLine();

        // Oppretter et nytt TodoItem-objekt med navnet hentet fra bruker
        TodoItem newItem = new TodoItem(name, false);

        // Legger til det nye objektet i lista vår
        todoList.add(newItem);

        // Printer ut tilbakemelding til bruker, med navn på gjøremål
        System.out.println(name + " lagt til!");
    }

    // Metode for å sette et gjøremål som gjort.
    // Tar også inn et scanner-objekt, siden det er avhengig av brukerinput
    private void setItemAsDone(Scanner scanner) {

        System.out.println("Skriv inn nummer på gjøremål:");

        // Printer lista over ikke-gjorte gjøremål
        showNotDoneList();

        // Tar inn input fra brukeren for å velge hvilket gjøremål som
        // skal settes som gjort
        String itemIndexString = scanner.nextLine();

        // Gjør om brukerinput til en index (int) som kan brukes av
        // ArrayLista vår. -1 er der fordi brukerinput tar utgangspunkt
        // i lista som er skrevet ut i konsollen, hvor alle indekser er
        // økt med 1
        int itemIndex = Integer.parseInt(itemIndexString) - 1;

        // Hvis itemIndex er større enn antall elementer i todolist minus 1,
        // er mindre enn 0, eller refererer til et gjøremål som allerede er gjort,
        // sørger denne while-loopen for å få inn et nytt brukerinput til itemIndex
        // er en gyldig verdi
        while (itemIndex > todoList.size()-1 || itemIndex < 0 || todoList.get(itemIndex).isDone()) {
            System.out.println("Velg et gyldig nummer");
            itemIndexString = scanner.nextLine();
            itemIndex = Integer.parseInt(itemIndexString) - 1;
        }

        // Setter et gjøremål som gjort, utifra itemIndex-variabelen
        todoList.get(itemIndex).setDone(true);

        // Tilbakemelding til bruker
        System.out.println(todoList.get(itemIndex).getItemName() + " satt som gjort!");
    }

    // Metode for å fjerne et gjøremål fra lista.
    // Tar også inn et scanner-objekt, siden det er avhengig av brukerinput
    private void removeItem(Scanner scanner) {

        System.out.println("Skriv inn nummer på gjøremål:");

        // Printer hele lista til konsollen
        showFullList();

        // Tar inn brukerinput og sjekker om det er gyldig på samme måte som
        // i setItemAsDone-metoden
        String itemIndexString = scanner.nextLine();
        int itemIndex = Integer.parseInt(itemIndexString) - 1;
        while (itemIndex > todoList.size()-1 || itemIndex < 0) {
            System.out.println("Velg et gyldig nummer");
            itemIndex = scanner.nextInt();
        }

        // Lagrer navnet på gjøremålet for å kunne bruke det i tilbakemelding senere
        String itemName = todoList.get(itemIndex).getItemName();

        // Fjerner gjøremålet fra lista
        todoList.remove(itemIndex);

        // Bruker det lagrede navnet i tilbakemelding. Om navnet ikke hadde vært lagret
        // før gjøremålet ble fjernet, hadde vi ikke kunne hentet det ut på noen måte
        System.out.println(itemName + " fjernet!");
    }
}
