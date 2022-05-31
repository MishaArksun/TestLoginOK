package ok;

public class User {
    private String login;
    private String pass;
    private String name;

    public User(String login, String pass, String name) {
        this.login = login;
        this.pass = pass;
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public String getName() {
        return name;
    }
    public String getPass() {
        return pass;
    }
}

