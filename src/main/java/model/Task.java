package model;
import java.util.UUID;

public class Task {
    private String id;
    private String name;
    private String createdDate;
    private String status;

    public Task() {
        this.id = UUID.randomUUID().toString();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCreatedDate() { return createdDate; }
    public String getStatus() { return status; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
    public void setStatus(String status) { this.status = status; }
}