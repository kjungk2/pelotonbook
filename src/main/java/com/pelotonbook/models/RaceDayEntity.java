package com.pelotonbook.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Kevin on 5/8/2017.
 */

@Entity

//TODO: This table name will change, for now it is 'testdb'
@Table(name="testdb")
public class RaceDayEntity {

    @Id
    @GeneratedValue
    private int id;

//    @Column(name="id")
//    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="RANK")
    private String rank;

    @Column(name="RACEDAY")
    private String raceday;

    @Column(name="TEAM")
    private String team;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="PCS_TIME")
    private String pcsTime;

    @Column(name="TOT_TIME")
    private String totalTime;


    // constructor
    public RaceDayEntity(int id,
                         String name,
                         String rank,
                         String raceday,
                         String team,
                         String country,
                         String pcsTime,
                         String totalTime) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.raceday = raceday;
        this.team = team;
        this.country = country;
        this.pcsTime = pcsTime;
        this.totalTime = totalTime;
    }

    // default constructor
    public RaceDayEntity(){}

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRaceday() {
        return raceday;
    }

    public void setRaceday(String raceday) {
        this.raceday = raceday;
    }

    public String getTeam() { return team; }

    public void setTeam(String team) { this.team = team; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getPcsTime() { return pcsTime; }

    public void setPcsTime(String pcsTime) { this.pcsTime = pcsTime; }

    public String getTotalTime() { return totalTime; }

    public void setTotalTime(String totalTime) { this.totalTime = totalTime; }
}
