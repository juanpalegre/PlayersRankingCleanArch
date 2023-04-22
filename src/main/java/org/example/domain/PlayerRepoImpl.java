package org.example.domain;

import org.example.application.PlayerMapper;
import org.example.model.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa PlayerRepository y se encarga de interactuar con la base de datos a través de JDBC.
 */

public class PlayerRepoImpl implements PlayerRepository{
    @Override
    public void addPlayer(Player player) throws SQLException {
        Connection connection = DatabaseConnector.obtenerConexion();
        String sql = "insert into players (playerName, score) values ('" + player.getName() + "' , '" + player.getScore() + "' )";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        connection.close();
    }

    @Override
    public Player getPlayerById(int playerId) {
        String sql = "SELECT * FROM players WHERE id = ?";
        Player player = null;

        try (Connection connection = DatabaseConnector.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             statement.setInt(1, playerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    player = PlayerMapper.mapRow(resultSet);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return player;
    }

    @Override
    public List<Player> getAllPlayers() throws Exception {
        Connection connection = DatabaseConnector.obtenerConexion();
        String sql = "SELECT * FROM players ORDER BY score DESC";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Player> playerList = new ArrayList<>();
        while (resultSet.next()){
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("playerName"));
            player.setScore(resultSet.getInt("score"));
            playerList.add(player);
        }
        statement.close();
        connection.close();
        return playerList;
    }

    @Override
    public void updatePlayer(Player player) throws SQLException {
        Connection connection = DatabaseConnector.obtenerConexion();
        String sql = "UPDATE players SET score = ? WHERE id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, player.getScore());
        statement.setInt(2, player.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void deleteAllPlayers() throws SQLException {
        Connection connection = DatabaseConnector.obtenerConexion();
        String sql = "DELETE FROM players";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }


}
