package com.codeclan.example.scotsservice.models;

import javax.persistence.*;

@Entity
@Table(name = "scots")
public class Scot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String pageID;

    @Column
    private String imageURL;

    @Column
    private String occupation;

    @Column
    private String placeOfBirth;

    @Column
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column (name = "date_of_death")
    private String dateOfDeath;

    @Column
    private String coord; 


    public Scot() {
    }

    public Scot(Long id, String name, String pageID, String imageURL, String occupation, String placeOfBirth, String gender, String dateOfBirth, String dateOfDeath, String coord) {
        this.id = id;
        this.name = name;
        this.pageID = pageID;
        this.imageURL = imageURL;
        this.occupation = occupation;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.coord = coord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageId(String pageID) {
        this.pageID = pageID;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}
