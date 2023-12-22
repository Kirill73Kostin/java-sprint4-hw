package taskmanager;

import taskmanager.manager.HistoryManager;
import taskmanager.manager.InMemoryHistoryManager;
import taskmanager.manager.InMemoryTaskManager;
import taskmanager.manager.TaskManager;
import taskmanager.model.Enums.Status;
import taskmanager.model.Epic;
import taskmanager.model.Subtask;
import taskmanager.model.Task;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new InMemoryTaskManager();
        HistoryManager historyManager = new InMemoryHistoryManager();

        Task task2 = new Task("t2", "tt2");
        task2.setStatus(Status.DONE);
        Task task1 = new Task("t1", "tt1");
        task1.setStatus(Status.DONE);
        Epic epic2 = new Epic("e2", "ee2");
        Epic epic1 = new Epic("e1", "ee1");
        Subtask subtask1 = new Subtask("s1", "ss1", Status.IN_PROGRESS, 1);
        Subtask subtask2 = new Subtask("s2", "ss2", Status.NEW, 1);
        Subtask subtask3 = new Subtask("s3", "ss3", Status.NEW, 2);

        taskManager.createEpic(epic2);
        taskManager.createEpic(epic1);
        taskManager.createTask(task2);
        taskManager.createTask(task1);
        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);
        taskManager.createSubtask(subtask3);
        //taskManager.delByIdTask(4);

        System.out.println(taskManager.getEpics());
        System.out.println(taskManager.listSubtaskOfEpic(1));
        System.out.println(taskManager.listSubtaskOfEpic(2));
        System.out.println(taskManager.getTasks());
        System.out.println(taskManager.getSubtasks());
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(4));
        System.out.println(taskManager.getByIdTask(3));
        System.out.println(historyManager.getHistory().size());
        System.out.println(historyManager.getHistory().get(0));
        System.out.println(historyManager.getHistory().get((historyManager.getHistory().size() - 1)));

    }
}
