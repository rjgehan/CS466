package com.example.sevencardstud.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(unique = true, name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Balance")
    private Double balance = 0.0;

    @Column(name = "Wins")
    private Integer wins = 0;

    @Column(name = "selectedImage")
    private String selectedImage;

    @Column(name = "SecurityAnswer")
    private String securityAnswer;

    public User() {
        // Default constructor
    }

    public User(Integer ID, String username, String password, Double balance, Integer wins, String securityAnswer) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.wins = wins;
        this.securityAnswer = securityAnswer;
    }

    // ID methods
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    // Username methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Password methods
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Balance methods
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // Wins methods
    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    // SecurityAnswer methods
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public String getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(String selectedImage) {
        this.selectedImage = selectedImage;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

}
