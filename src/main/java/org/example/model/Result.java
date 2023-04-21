package org.example.model;

/**
 * Clase destinada a representar el resultado de cada partido disputado por los jugadores.
 * Posee dos atributos de tipo Player, ganador y perdedor.
 *
 */
public class Result {

    private int id;
    private Player winner;
    private Player loser;

    public Result(){

    }

    public Result(int id, Player winner, Player losser) {
        this.id = id;
        this.winner = winner;
        this.loser = losser;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
