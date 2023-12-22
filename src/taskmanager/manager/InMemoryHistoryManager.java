package taskmanager.manager;

import taskmanager.model.Task;
import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private int MAX_COUNT = 10;
    private static final ArrayList<Task> history = new ArrayList<>();

    @Override
    public List<Task> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public void addTaskToHistory(Task task) {
        history.add(task);
        if (history.size() > MAX_COUNT) {
            history.remove(0);
        }
    }

}
