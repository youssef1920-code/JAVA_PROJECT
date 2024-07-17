public class User {

    private String name;
    private String lastName;
    private long phone;
    private String password;
    private long id;

    public User(String name, String lastName, long phone, String password, long id) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", id=" + id +
                '}';
    }
}
