// package avaj_launcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) throws FileNotFoundException {
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }
    protected void conditionsChanged() throws EmptyListException, IOException {
        for (Flyable observer : new ArrayList<>(observers)) {
            observer.updateConditions();
        }
    }
}
