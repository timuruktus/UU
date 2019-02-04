package trelico.ru.uu.models;

public class UserRegistration{

    private String email;
    private String login;
    private String password;
    private String name;
    private String secondName;

    public UserRegistration(String email, String login, String password, String name, String secondName){
        this.email = email;
        this.login = login;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
    }

    public UserRegistration(){
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSecondName(){
        return secondName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }
}
