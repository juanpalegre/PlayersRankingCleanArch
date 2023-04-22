package org.example.application;

import org.example.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que se encarga de convertir los datos del jugador
 * entre el modelo de dominio y el modelo de base de datos.
 */
public class PlayerMapper {

    public static Player mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("playerName");
        int score = resultSet.getInt("score");

        Player player = new Player(id, name, score);
        return player;
    }
}
