package taskmanager.model;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Integer> subtaskIds = new ArrayList<>();

    public Epic(String title, String description) {
        super(title, description);
    }

    public int getSubtaskIdsSize() {
        return subtaskIds.size();
    }

    public ArrayList<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void addSubtaskId(Integer subTaskId) {
        this.subtaskIds.add(subTaskId);
    }

    public void setSubtaskIdsSubtaskId(ArrayList<Integer> subtaskIds) {
        this.subtaskIds = subtaskIds;
    }

    public void delSubtaskId(Integer id) {
        this.subtaskIds.remove(id);
    }

    @Override
    public String toString() {
        return "\n" + "название: " + title + ", описание: " + description + ", статус: " + status + ", id: " + id +
                ", id Подзадач: " + subtaskIds;
    }
}