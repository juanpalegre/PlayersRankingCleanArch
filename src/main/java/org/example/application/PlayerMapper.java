package org.example.application;

import org.example.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper {

    public Player mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int score = resultSet.getInt("score");

        Player player = new Player(id, name, score);
        return player;
    }
}
