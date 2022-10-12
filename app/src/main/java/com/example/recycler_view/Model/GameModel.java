package com.example.recycler_view.Model;

public class GameModel {


    int gameImg;
    String name,country,people;

    public GameModel(int gameImg, String name, String country, String people) {
        this.gameImg = gameImg;
        this.name = name;
        this.country = country;
        this.people = people;
    }

    public int getGameImg() {
        return gameImg;
    }

    public void setGameImg(int gameImg) {
        this.gameImg = gameImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
