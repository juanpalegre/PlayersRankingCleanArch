package org.example.application;

import org.example.domain.PlayerRepository;
import org.example.model.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RankingService {
    private PlayerRepository playerRepository;

    public RankingService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() throws Exception {
        return playerRepository.getAllPlayers();
    }

    public void addPlayer(Player player) throws SQLException {
        playerRepository.addPlayer(player);
    }

    public void loadResult(Player winner, Player loser) throws SQLException {
        // Suma 100 puntos al ganador y 50 puntos al perdedor
        winner.addPoints(100);
        loser.addPoints(50);

        // Guarda los cambios en la base de datos
        playerRepository.updatePlayer(winner);
        playerRepository.updatePlayer(loser);
    }
}
