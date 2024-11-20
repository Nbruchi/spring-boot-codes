package rca.ac.rw.relations.models;

public class SchoolDto {
    private String name;

    public SchoolDto() {
    }

    public SchoolDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
