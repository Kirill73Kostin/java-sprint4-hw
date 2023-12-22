package taskmanager.manager;

import taskmanager.model.Epic;
import taskmanager.model.Subtask;
import taskmanager.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TaskManager {

    int createTask(Task task);

    int createEpic(Epic epic);

    int createSubtask(Subtask subtask);

    void updateTask(Task task);

    void updateEpic(Epic epic);

    void updateSubtask(Subtask subtask);

    ArrayList<Task> getTasks();

    ArrayList<Subtask> getSubtasks();

    ArrayList<Epic> getEpics();

    void delAllTasks();

    void delAllSubtasks();

    void delAllEpics();

    Task getByIdTask(Integer id);

    Subtask getByIdSubtask(Integer id);

    Epic getByIdEpic(Integer id);

    void delByIdTask(Integer id);

    void delByIdSubtask(Integer id);

    void delByIdEpic(Integer id);

    ArrayList<Subtask> listSubtaskOfEpic(Integer id);
    List<Task> getHistory();

}
