package org.example.model;

/**
 * Clase destinada a representar el modelo para las instancias de los jugadores
 * dentro del ranking.
 */
public class Player {

    private int id;
    private String name;
    private int score;

    public Player(){

    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Player(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name + " - Score: " + this.score;
    }

    public void addPoints(int points){
        this.score += points;
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
