public class Entity {

    private Long id;
    private String firstName;
    private String lastName;
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getDepartment() {
        return department;
    }


    public void setDepartment(String dep) {
        this.department = dep;
    }


    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", First name=" + firstName + ", Last name=" + lastName + ", department=" + department + '}';
    }

}
