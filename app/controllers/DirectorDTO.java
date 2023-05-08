package controllers;

public record DirectorDTO(Long id,
                          String name) {
    @Override
    public String toString() {
        return "DirectorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
