package com.example.demo.Clients;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "col_username")
    String username;
    @Column(name = "col_password")
    String password;
    @JsonProperty("Email")
    @Column(name = "col_email")
    String Email;
    @JsonProperty("Phone")
    @Column(name = "col_phone")
    String Phone;

    @JsonProperty("bonuses")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Bonus> bonuses;

    public Client() {

    }

    public Client(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        Email = email;
        Phone = phone;
    }
    public Client(String username, String password, String email, String phone, List<Bonus> bonuses) {
        this.username = username;
        this.password = password;
        Email = email;
        Phone = phone;
        this.bonuses = bonuses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

}
