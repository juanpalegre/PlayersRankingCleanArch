package org.example.model;

/**
 * Clase destinada a representar el modelo para las instancias de los jugadores
 * dentro del ranking.
 * No se incluye un constructor con el parámetro id dado que este lo va a manejar de manera
 * autoincremental la propia base de datos.
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
