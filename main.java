/**
 * @author Simon Solum-Faeste
 * @since 29.03.19
 */

import java.util.ArrayList;
import java.util.Scanner;

public class main {


    /**
     * global
     * arrays, arraylist, scanner and variables
     */
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> players = new ArrayList<String>();
    private static int[] score = new int [1000];
    private static int diceSides = 6;
    private static int[] dicethrow = new int [1000];
    private static int largestScore = score[0];

    /**
     * main method that runs the program
     * contains 2 methods
     * askGamers()- ask the player/players questions
     * game() - runs the game
     */
    public static void main(String[] args) {
        askGamers();
        game();
    }

    /**
     * asks users - how many players and adds them to the game
     */
    private static void askGamers(){
        System.out.println("Welcome to Simons 'improved' dice games!"+"\n\nhow many players?");
        int maxPlayers = sc.nextInt();

        /**
         * loops through maxplayers
         * every loop allows users to wright a name
         */
        for(int i=1; i<=maxPlayers; i++){
            System.out.println("\nPlayer "+i+ " state your name: ");
            String playerName = sc.next();

            /**
             * adds players to the arraylist "players"
             */
            players.add(playerName);
        }
    }

    /**
     * runs the game.
     */
    private static void game(){
        /**
         * asks user how many rounds they want
         */
        System.out.println("\nHow many Rounds?");
        int numRounds = sc.nextInt();


        /**
         * loops through numrounds
         */
        for(int i=1; i<=numRounds; i++){
            System.out.println("\nRound " + i);

            /**
             * loops through players arraylist
             * if statement makes sure that the index is not out of bounds
             * randomize dice tosses
             * prints out player by position of j, what number of toss and randomized dice throw
             */
            for (int j=0; j<=players.size(); j++){

                if (players.size() > j) {

                    dicethrow[i] = (int) (1 + diceSides * Math.random());

                    System.out.println(players.get(j) + " dice toss " + i + " is " + dicethrow[i]);


                    /**
                     * dicethrow adds to score[j](position of j in array)
                     * this way players get there own total score
                     */
                    score[j] += dicethrow[i];

                    /**
                     * prints out what player and the total score
                     */
                    System.out.println(players.get(j) + " total score is " + score[j] + "\n");
                }
            }
        }

        /**
         * loops through score array and checks if score[i] is bigger than the "largestScore".
         * if - thats the case, largestScore gets the value from score[i]
         */
        for (int i=0; i<score.length; i++){

                if (score[i]>largestScore){
                    largestScore = score[i];
                }
        }
        /**
         * prints the highest score
         */
        System.out.println("Highscore: " + largestScore);
    }
}
