package user_info_managment;

public class Login {
    private String username;
    private String password;

    Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void searchForAccount(){
        // implementation
    }
    
    
}
