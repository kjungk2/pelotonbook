package com.pelotonbook.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Kevin on 4/17/2017.
 */
@Entity
public class User {

    @NotNull
    @Size(min=3, max=15)
    private String username;

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    public List<Rider> riders;

    // constructors
    public User(String username) {
        this.username = username;
    }

    public User() { }

    public void addItem(Rider item) {
        riders.add(item);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public List<Rider> getRiders() {
        return riders;
    }

}
