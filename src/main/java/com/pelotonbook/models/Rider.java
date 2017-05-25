package com.pelotonbook.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kevin on 4/17/2017.
 */
@Entity
public class Rider {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1)
    private String name;

    @NotNull
    @Size(min=1)
    private String team;

    @NotNull
    @Size(min=1)
    private String pcsLink;

    // constructors
    public Rider(String name, String team, String pcsLink) {
        this.name = name;
        this.team = team;
        this.pcsLink = pcsLink;
    }

    public Rider() { }


    // getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPcsLink() {
        return pcsLink;
    }

    public void setPcsLink(String pcsLink) {
        this.pcsLink = pcsLink;
    }
}
