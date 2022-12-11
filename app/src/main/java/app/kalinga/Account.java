package app.kalinga;

public class Account {

    String username;
    String password;

    public Account(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public Account() {

    }

    @Override
    public String toString() {
        return
                "Username: " + username + '\n' +
                "Password: " + password + "\n";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
