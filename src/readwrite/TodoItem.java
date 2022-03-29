package readwrite;

public class TodoItem {

    private String itemName;
    private boolean done;

    public TodoItem(String itemName, boolean done) {
        this.itemName = itemName;
        this.done = done;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
