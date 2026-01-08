package service;

import dao.TaskDAO;
import model.Task;

public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();


    public void addTask(Task task) {
        if (task.getName() == null || task.getName().trim().isEmpty()) {
            System.out.println("Erro: O nome da tarefa é obrigatório!");
            return;
        }
   
        taskDAO.addTask(task);
    }

  
    public void deleteTask(String taskId) {
        if (taskId == null || taskId.trim().isEmpty()) {
            System.err.println("Erro: O ID da tarefa é obrigatório!");
            return;
        }
        taskDAO.deleteTask(taskId);
    }


    public void updateTaskStatus(String taskId, String status) {
        if (status == null || status.trim().isEmpty()) {
            System.out.println("Erro: O novo status não pode ser vazio!");
            return;
        }
        taskDAO.updateTaskStatus(taskId, status);
    }

    public void listTasks() {
        taskDAO.listTasks();
    }
}