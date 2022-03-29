package readwrite;

import java.io.IOException;

public class TodoManager {

    public static void main(String[] args) throws IOException {

        TodoMenuHandler menu = new TodoMenuHandler(TodoFileHandler.readFromFile());

        menu.showMenu();

        TodoFileHandler.writeToFile(menu.getTodoList());
    }
}
