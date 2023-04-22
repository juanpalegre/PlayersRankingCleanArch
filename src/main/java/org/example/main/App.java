package org.example.main;

import org.example.application.RankingService;
import org.example.domain.PlayerRepoImpl;
import org.example.model.Player;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static PlayerRepoImpl playerRepo = new PlayerRepoImpl();
    static RankingService rankingService = new RankingService(playerRepo);
    static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) throws Exception{

        System.out.println("Welcome to the ranking service system");
        int input;
        //A partir del ingreso del usuario, procesamos la opción requerida
        do {
            showOptions();
            input = scanner.nextInt();
            switch (input){
                case 1:
                    rankingService.addPlayer(createNewPlayer());
                    break;
                case 2:
                    getUpdatedRanking();
                    break;
                case 3:
                    loadNewResult();
                    break;
                default:
                    System.out.println("Thanks for using our system");
            }
        } while (input==1||input==2||input==3);



    }

    //Cargamos un resultado nuevo a partir del id de cada jugador
    private static void loadNewResult() throws Exception {
        System.out.println("Please, enter the id of the winner: ");
        Player winner = rankingService.getPlayer(scanner.nextInt());
        System.out.println("Please, enter the id of the loser: ");
        Player loser = rankingService.getPlayer(scanner.nextInt());
        rankingService.loadResult(winner, loser);
    }

    //Creamos nuevos jugadores a partir del ingreso de datos por parte del usuario
    private static Player createNewPlayer() {
        Player player = new Player();
        System.out.println("Please, enter the name of the new player: ");
        player.setName(scanner.next());
        System.out.println("Please, enter the score of the new player: ");
        player.setScore(scanner.nextInt());
        return player;
    }

    //Mostramos las opciones de interacción para el usuario
    private static void showOptions() {
        System.out.println("Please, select one of the following options: ");
        System.out.println("Press 1 to add a new player");
        System.out.println("Press 2 take a look at the updated ranking");
        System.out.println("Press 3 to load a new result");
        System.out.println("Press 0 to exit system");
    }

    //Actualizamos el ranking con los últimos datos obtenidos de la base de datos
    public static void getUpdatedRanking() throws Exception {
        List<Player> playerList = rankingService.getPlayers();
        for (Player player: playerList){
            System.out.println("Position: " + (playerList.indexOf(player) + 1) + " - " + player.toString());
        }
    }
}
