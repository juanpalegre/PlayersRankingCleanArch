package org.example.application;

import org.example.model.Player;
import org.example.model.Result;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMapper {

    public Result mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String winner = resultSet.getString("winner");
        String loser = resultSet.getString("loser");
        Result result = new Result(id, new Player(), new Player());
        return null;
    }

}
