package readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoFileHandler {

    private static File file = new File("resources/todolist.txt");

    public static ArrayList<TodoItem> readFromFile() throws FileNotFoundException {

        ArrayList<TodoItem> todoList =  new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String itemName = scanner.nextLine();
            boolean isDone = Boolean.parseBoolean(scanner.nextLine());
            String junk = scanner.nextLine();

            todoList.add(new TodoItem(itemName, isDone));
        }

        scanner.close();

        return todoList;
    }

    public static void writeToFile(ArrayList<TodoItem> todoList) throws IOException {

        FileWriter writer = new FileWriter(file);

        for (TodoItem item : todoList) {
            writer.write(item.getItemName() + "\n");
            writer.write(item.isDone() + "\n");
            writer.write("---\n");
        }

        writer.close();
    }
}
