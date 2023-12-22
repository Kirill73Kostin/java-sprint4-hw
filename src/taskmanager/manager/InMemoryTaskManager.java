package taskmanager.manager;

import taskmanager.model.Epic;
import taskmanager.model.Subtask;
import taskmanager.model.Task;
import taskmanager.model.Enums.Status;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {

    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final HashMap<Integer, Epic> epicMap = new HashMap<>();
    private final HashMap<Integer, Subtask> subtaskMap = new HashMap<>();

    private int nextId = 1;

    InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();

    @Override
    public int createTask(Task task) {
        generateId(task);
        taskMap.put(task.getId(), task);
        return task.getId();
    }

    @Override
    public int createEpic(Epic epic) {
        generateId(epic);
        if (epic.getSubtaskIdsSize() == 0) {
            epic.setStatus(Status.NEW);
        }
        epicMap.put(epic.getId(), epic);
        return epic.getId();
    }

    @Override
    public int createSubtask(Subtask subtask) {
        generateId(subtask);
        Epic epic = epicMap.get(subtask.getEpicId());
        epic.addSubtaskId(subtask.getId());
        subtaskMap.put(subtask.getId(), subtask);
        updateEpicStatus(epic);
        return subtask.getId();
    }

    @Override
    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic) {
        epicMap.put(epic.getId(), epic);
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        subtaskMap.put(subtask.getId(), subtask);
        updateEpicStatus(epicMap.get(subtask.getEpicId()));
    }

    @Override
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(taskMap.values());
    }

    @Override
    public ArrayList<Subtask> getSubtasks() {
        return new ArrayList<>(subtaskMap.values());
    }

    @Override
    public ArrayList<Epic> getEpics() {
        return new ArrayList<>(epicMap.values());
    }

    @Override
    public void delAllTasks() {
        taskMap.clear();
    }

    @Override
    public void delAllSubtasks() {
        subtaskMap.clear();
        for (Epic epic : epicMap.values()) {
            epic.setStatus(Status.NEW);
        }
    }

    @Override
    public void delAllEpics() {
        epicMap.clear();
        subtaskMap.clear();
    }

    @Override
    public Task getByIdTask(Integer id) {
        addTaskToHistory(taskMap.get(id));
        return (taskMap.get(id));
    }

    @Override
    public Subtask getByIdSubtask(Integer id) {
        addTaskToHistory(subtaskMap.get(id));
        return (subtaskMap.get(id));
    }

    @Override
    public Epic getByIdEpic(Integer id) {
        addTaskToHistory(epicMap.get(id));
        return (epicMap.get(id));
    }

    @Override
    public void delByIdTask(Integer id) {
        taskMap.remove(id);
    }

    @Override
    public void delByIdSubtask(Integer id) {
        Epic e = epicMap.get(subtaskMap.get(id).getEpicId());
        ArrayList<Integer> stIds = e.getSubtaskIds();
        stIds.remove(id);
        updateEpicStatus(e);
        subtaskMap.remove(id);
    }

    @Override
    public void delByIdEpic(Integer id) {
        ArrayList<Integer> stIds = epicMap.get(id).getSubtaskIds();
        for (Integer s : stIds) {
            subtaskMap.remove(s);
        }
        epicMap.remove(id);
    }

    @Override
    public ArrayList<Subtask> listSubtaskOfEpic(Integer id) {
        ArrayList<Subtask> subTList = new ArrayList<>();
        if (epicMap.get(id) != null) {
            Epic e = epicMap.get(id);
            ArrayList<Integer> subIds = e.getSubtaskIds();
            for (Integer sId : subIds) {
                subTList.add(subtaskMap.get(sId));
            }
        }
        return (subTList);
    }

    protected int generateId(Task task) {
        task.setId(nextId);
        nextId++;
        return nextId;
    }

    private void updateEpicStatus(Epic epic) {
        int n = 0;
        int done = 0;
        if ((epic.getSubtaskIds() == null) || (subtaskMap.size() == 0)) {
            epic.setStatus(Status.NEW);
        } else {

            for (Integer subtaskId : epic.getSubtaskIds()) {
                Subtask curSub = subtaskMap.get(subtaskId);
                if (curSub.getStatus() == Status.IN_PROGRESS) {
                    epic.setStatus(Status.IN_PROGRESS);
                }
                if (curSub.getStatus() == Status.NEW) {
                    n += 1;
                }
                if (curSub.getStatus() == Status.DONE) {
                    done += 1;
                }
            }
        }
        if (epic.getSubtaskIdsSize() == n) {
            epic.setStatus(Status.NEW);
        } else {
            if (epic.getSubtaskIdsSize() == done) {
                epic.setStatus(Status.DONE);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
    }

    void addTaskToHistory(Task task) {
        inMemoryHistoryManager.addTaskToHistory(task);
    }

}
