package taskmanager.manager;

import taskmanager.manager.HistoryManager;
import taskmanager.model.Task;

import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager {
    private  int MAX_COUNT = 10;
    private final ArrayList<Task> history = new ArrayList<>();

    @Override
    public ArrayList<Task> getHistory() {
        return history;
    }

    @Override
    public void addTaskToHistory(Task task) {
        history.add(task);
        if (history.size() > MAX_COUNT) {
            history.remove(0);
        }
    }
}
