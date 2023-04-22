package org.example.application;

import org.example.domain.PlayerRepository;
import org.example.model.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa la capa de negocio de la aplicación
 * Contiene la lógica para conectar los jugadores con la carga de resultado
 */
public class RankingService {
    //Trabajamos con la interfaz PlayerRepository.
    //La implementación de esta interfaz es ajena a esta capa, con lo cual si el recurso de los datos en algún
    //momento cambia, la clase continuará siendo funcional.
    private final PlayerRepository playerRepository;

    public RankingService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //Traemos un jugador a partir de su atributo id
    public Player getPlayer(int playerId) throws Exception{
        return playerRepository.getPlayerById(playerId);
    }

    //Traemos la lista de jugadores que conforman el ranking
    public List<Player> getPlayers() throws Exception {
        return playerRepository.getAllPlayers();
    }

    //Agregamos un nuevo jugador al ranking
    public void addPlayer(Player player) throws SQLException {
        playerRepository.addPlayer(player);
    }

    //Cargamos un nuevo resultado, lo cual setea el atributo score y lo guarda en la bd
    public void loadResult(Player winner, Player loser) throws SQLException {
       try {
           Player dbPlayer1 = playerRepository.getPlayerById(winner.getId());
           Player dbPlayer2 = playerRepository.getPlayerById(loser.getId());
           //Chequeamos la existencia de los jugadores en la base de datos
           if(dbPlayer1!=null || dbPlayer2!=null){
               dbPlayer1.addPoints(100);
               dbPlayer2.addPoints(50);
               playerRepository.updatePlayer(dbPlayer1);
               playerRepository.updatePlayer(dbPlayer2);
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
    }
}
