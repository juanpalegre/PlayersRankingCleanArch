package org.example.domain;

import org.example.model.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerRepository {

    void addPlayer(Player player) throws SQLException;

    List<Player> getAllPlayers() throws Exception;

    void updatePlayer(Player player) throws SQLException;

    void deleteAllPlayers() throws SQLException;

}
