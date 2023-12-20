package taskmanager.model;

import taskmanager.model.Enums.Status;

public class Subtask extends Task {

    private int epicId;

    public Subtask(String title, String description, Status status, int epicId) {
        super(title, description);
        this.epicId = epicId;
        this.status = status;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "\n" + "название: " + title + ", описание: " + description + ", статус: " + status + ", id: " + id +
                ", id Эпика: " + epicId;
    }
}
