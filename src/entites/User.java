/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author sahar
 */
public class User {
    
    private int id;
    private String email,username,code_generated,roles,password,activation_token;

    public User(int id, String email, String username, String code_generated, String roles, String password, String activation_token) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.code_generated = code_generated;
        this.roles = roles;
        this.password = password;
        this.activation_token = activation_token;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getCode_generated() {
        return code_generated;
    }

    public String getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getActivation_token() {
        return activation_token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCode_generated(String code_generated) {
        this.code_generated = code_generated;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivation_token(String activation_token) {
        this.activation_token = activation_token;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", username=" + username + ", code_generated=" + code_generated + ", roles=" + roles + ", password=" + password + ", activation_token=" + activation_token + '}';
    }
    
    
    
}
