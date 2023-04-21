package org.example.main;

import org.example.application.RankingService;
import org.example.domain.DatabaseConnector;
import org.example.domain.PlayerRepoImpl;
import org.example.model.Player;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    static Connection connection = DatabaseConnector.obtenerConexion();
    static PlayerRepoImpl playerRepo = new PlayerRepoImpl();
    static RankingService rankingService = new RankingService(playerRepo);

    public static void main( String[] args ) throws Exception{

        if (connection==null){
            System.out.println("No estoy conectado");
        } else {
            System.out.println("Estoy conectado!");
        }

        playerRepo.deleteAllPlayers();

        Player player1 = new Player("Pedro", 200);
        Player player2 = new Player("Tony", 100);
        Player player3 = new Player("Juan", 300);
        Player player4 = new Player("Jose", 400);
        Player player5 = new Player("Rodrigo", 500);
        Player player6 = new Player("Moreno", 600);

        rankingService.addPlayer(player1);
        rankingService.addPlayer(player2);
        rankingService.addPlayer(player3);
        rankingService.addPlayer(player4);
        rankingService.addPlayer(player5);
        rankingService.addPlayer(player6);

        rankingService.loadResult(player1, player2);

        getUpdatedRanking();
    }

    public static void getUpdatedRanking() throws Exception {
        List<Player> playerList = rankingService.getPlayers();
        for (Player player: playerList){
            System.out.println("Position: " + playerList.indexOf(player) + " - " + player.toString());
        }
    }
}
