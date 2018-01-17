package com.example.demo.UserDetilsServis;


import com.example.demo.enam.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String username;

    @Column
    public String password;

    @Column
    public String phone;

    @Column
    public Integer age;

    @Column
    public boolean enabled;

    @Enumerated(EnumType.STRING)
    public Role roles;

    @Column
    public boolean locked;

    @Transient
    List<SimpleGrantedAuthority> role=new ArrayList<>();
    public User() {

    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public List<SimpleGrantedAuthority> getRoles() {

        return role;
    }

    public void setRoles(Role roles) {
            role.add(new SimpleGrantedAuthority("ROLE_"+roles.name()));

        this.roles = roles;
    }

    public User(String username, String password, String phone, Integer age, boolean enabled, Role roles, boolean locked) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.age = age;
        this.enabled = enabled;
        this.roles = roles;
        this.locked = locked;
    }
}
