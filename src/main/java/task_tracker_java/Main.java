package task_tracker_java; // ou apenas remova se estiver na raiz de java

import model.Task;
import service.TaskService;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        if (args.length == 0) {
            System.out.println("Use: task-cli [comando] [argumentos]");
            return;
        }
        String comando = args[0];

        switch (comando) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Erro: Nome da tarefa é obrigatório para adicionar.");
                    break;
                }
                Task novaTask = new Task();
                novaTask.setName(args[1]);
                service.addTask(novaTask);
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Erro: O ID da tarefa é obrigatório para excluir.");
                    break;
                }
                service.deleteTask(args[1]);
                break;
                case "list":
                // Vamos precisar criar esse método no Service e DAO ainda!
                System.out.println("Listando tarefas...");
                break;

            case "mark-in-progress":
                service.updateTaskStatus(args[1], "in-progress");
                break;

            case "mark-done":
                service.updateTaskStatus(args[1], "done");
                break;
            default:
                System.out.println("Comando inválido. Use: task-cli [comando] [argumentos]");
        }
    }

}