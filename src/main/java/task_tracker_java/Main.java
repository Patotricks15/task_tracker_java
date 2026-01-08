package task_tracker_java; // ou apenas remova se estiver na raiz de java

import model.Task;
import service.TaskService;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();

        // Criando uma tarefa de teste
        Task t = new Task();
        t.setName("Aprender arquitetura Python");
        t.setStatus("todo");
        service.addTask(t);
    }
}