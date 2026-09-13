package com.DevSuperior.DSComerce1.Entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;
    @Column(unique = true)
    private String Email;
    private String phone;
    private LocalDate bithDate;
    private String Passwoard;
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
    public User() {
    }

    public User(long id, String name, String email, String phone, LocalDate bithDate, String passwoard) {
        this.id = id;
        Name = name;
        Email = email;
        this.phone = phone;
        this.bithDate = bithDate;
        Passwoard = passwoard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBithDate() {
        return bithDate;
    }

    public void setBithDate(LocalDate bithDate) {
        this.bithDate = bithDate;
    }

    public String getPasswoard() {
        return Passwoard;
    }

    public void setPasswoard(String passwoard) {
        Passwoard = passwoard;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

