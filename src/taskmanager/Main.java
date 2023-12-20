package taskmanager;

import taskmanager.manager.InMemoryHistoryManager;
import taskmanager.manager.InMemoryTaskManager;
import taskmanager.model.Enums.Status;
import taskmanager.model.Epic;
import taskmanager.model.Subtask;
import taskmanager.model.Task;

public class Main {

    public static void main(String[] args) {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
        Task task2 = new Task("t2", "tt2");
        task2.setStatus(Status.DONE);
        Task task1 = new Task("t1", "tt1");
        task1.setStatus(Status.DONE);
        Epic epic2 = new Epic("e2", "ee2");
        Epic epic1 = new Epic("e1", "ee1");
        Subtask subtask1 = new Subtask("s1", "ss1", Status.IN_PROGRESS, 1);
        Subtask subtask2 = new Subtask("s2", "ss2", Status.NEW, 1);
        Subtask subtask3 = new Subtask("s3", "ss3", Status.NEW, 2);

        inMemoryTaskManager.createEpic(epic2);
        inMemoryTaskManager.createEpic(epic1);
        inMemoryTaskManager.createTask(task2);
        inMemoryTaskManager.createTask(task1);
        inMemoryTaskManager.createSubtask(subtask1);
        inMemoryTaskManager.createSubtask(subtask2);
        inMemoryTaskManager.createSubtask(subtask3);
        //inMemoryTaskManager.delByIdTask(4);
        //inMemoryTaskManager.delByIdEpic(1);
        System.out.println(inMemoryHistoryManager.getHistory().size());
        /*System.out.println(inMemoryTaskManager.getEpics());
        System.out.println(inMemoryTaskManager.listSubtaskOfEpic(1));
        System.out.println(inMemoryTaskManager.listSubtaskOfEpic(2));
        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println(inMemoryTaskManager.getSubtasks());
        System.out.println(inMemoryTaskManager.getByIdTask(3));*/

    }
}
