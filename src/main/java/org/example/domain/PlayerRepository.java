package org.example.domain;

import org.example.model.Player;

import java.sql.SQLException;
import java.util.List;


/**
 * Esta clase define las operaciones básicas de acceso a datos para la entidad Player.
 */
public interface PlayerRepository {

    void addPlayer(Player player) throws SQLException;

    Player getPlayerById(int playerId);

    List<Player> getAllPlayers() throws Exception;

    void updatePlayer(Player player) throws SQLException;

    void deleteAllPlayers() throws SQLException;

}
