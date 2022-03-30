package readwrite;

import java.util.Objects;

public class TodoItem {

    // FIELDS

    private String itemName;
    private boolean done;



    // CONSTRUCTOR

    public TodoItem(String itemName, boolean done) {
        this.itemName = itemName;
        this.done = done;
    }



    // GETTERS/SETTERS

    public String getItemName() {
        return itemName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }



    // equals-metoden er noe alle objekter har tilgang til, siden den er
    // definert i Object-klassen. Denne overrides ofte når man vil sjekke
    // likhet mellom to objekter, siden dobbelt likhetstegn bare sjekker
    // om to objekter er samme objekt, mens equals sjekker om to objekter
    // har samme verdier
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return done == todoItem.done && itemName.equals(todoItem.itemName);
    }

    // hashCode-metoden er også definert i Object-klassen, og brukes
    // for å generere en unik kode for et objekt utifra objektets fields.
    // Her brukes både itemName og done-fields for å generere denne koden
    @Override
    public int hashCode() {
        return Objects.hash(itemName, done);
    }
}
