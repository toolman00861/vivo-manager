package JavaBean;

public class Department {
    private int id;
    private String name;
    private String description;
    private int department_members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDepartment_members() {
        return department_members;
    }

    public void setDepartment_members(int department_members) {
        this.department_members = department_members;
    }
}
