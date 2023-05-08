package controllers;

public class DirectorRequest {
    private Long id;
    private String name;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public DirectorRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
