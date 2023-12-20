package taskmanager.manager;

import taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public interface HistoryManager {
    ArrayList<Task> getHistory();
    void addTaskToHistory(Task task);
}
