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

  
    public void deleteTask(int taskId) {
        if (taskId <= 0) {
            System.out.println("Erro: ID de tarefa inválido!");
            return;
        }
        taskDAO.deleteTask(taskId);
    }


    public void updateTaskStatus(int taskId, String status) {
        if (status == null || status.trim().isEmpty()) {
            System.out.println("Erro: O novo status não pode ser vazio!");
            return;
        }
        taskDAO.updateTaskStatus(taskId, status);
    }
}