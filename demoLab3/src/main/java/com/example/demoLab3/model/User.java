package main.java.com.example.demoLab3.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
   
    @ID
    private String login;

    private String password;
    private String name;

    public User () {
        //Nao faz nada
    }

    public User (String login, String password, String name){
        this.login = login;
        this.password = password;
        this.name = name;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
}