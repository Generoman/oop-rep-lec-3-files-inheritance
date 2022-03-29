package readwrite;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoMenuHandler {

    private ArrayList<TodoItem> todoList;

    public TodoMenuHandler(ArrayList<TodoItem> todoList) {
        this.todoList = todoList;
    }

    public ArrayList<TodoItem> getTodoList() {
        return todoList;
    }

    public void showMenu() {

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {

            System.out.println("\n1 - Vis liste over gjøremål");
            System.out.println("2 - Legg til nytt gjøremål");
            System.out.println("3 - Sett et gjøremål som gjort");
            System.out.println("4 - Fjern et gjøremål");
            System.out.println("5 - Avslutt");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showFullList();
                case "2" -> addItem(scanner);
                case "3" -> setItemAsDone(scanner);
                case "4" -> removeItem(scanner);
                case "5" -> {
                    running = false;
                    System.out.println("Ha en fin dag!");
                }
                default -> System.out.println("Velg et gyldig menyalternativ");
            }
        }

        scanner.close();
    }

    public void showFullList() {
        for (int i = 0; i< todoList.size(); i++) {

            StringBuilder itemString = new StringBuilder();

            itemString.append(i + 1).append(" ");

            if (todoList.get(i).isDone()) {
                itemString.append("[x] ");
            } else {
                itemString.append("[ ] ");
            }

            itemString.append(todoList.get(i).getItemName());

            System.out.println(itemString);
        }
    }

    private void showNotDoneList() {
        for (int i = 0; i< todoList.size(); i++) {

            if (!todoList.get(i).isDone()) {
                String itemString = (i+1) + " [ ] " + todoList.get(i).getItemName();
                System.out.println(itemString);
            }
        }
    }

    public void addItem(Scanner scanner) {

        System.out.println("Skriv inn navn på gjøremål:");

        String name = scanner.nextLine();

        todoList.add(new TodoItem(name, false));

        System.out.println(name + " lagt til!");
    }

    public void setItemAsDone(Scanner scanner) {

        System.out.println("Skriv inn nummer på gjøremål:");
        showNotDoneList();

        String itemIndexString = scanner.nextLine();
        int itemIndex = Integer.parseInt(itemIndexString) - 1;
        while (itemIndex > todoList.size()-1 || itemIndex < 0) {
            System.out.println("Velg et gyldig nummer");
            itemIndex = scanner.nextInt();
        }

        todoList.get(itemIndex).setDone(true);

        System.out.println(todoList.get(itemIndex).getItemName() + " satt som gjort!");
    }

    public void removeItem(Scanner scanner) {
        System.out.println("Skriv inn nummer på gjøremål:");
        showFullList();

        String itemIndexString = scanner.nextLine();
        int itemIndex = Integer.parseInt(itemIndexString) - 1;
        while (itemIndex > todoList.size()-1 || itemIndex < 0) {
            System.out.println("Velg et gyldig nummer");
            itemIndex = scanner.nextInt();
        }

        String itemName = todoList.get(itemIndex).getItemName();
        todoList.remove(itemIndex);

        System.out.println(itemName + " fjernet!");
    }
}
