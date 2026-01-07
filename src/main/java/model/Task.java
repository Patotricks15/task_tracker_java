package model;

public class Task {
    private int id;
    private String name;
    private String createdDate;
    private String status;


    public int getId() { return id; }
    public String getName() { return name; }
    public String getCreatedDate() { return createdDate; }
    public String getStatus() { return status; }

  
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public void setStatus(String status) { this.status = status; }
}