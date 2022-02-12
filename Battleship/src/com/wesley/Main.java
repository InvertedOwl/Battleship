package com.wesley;


import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static final int numShips = 5;
    public static boolean debug = false;
    public static void main(String[] args) throws IOException {
        boolean win = false;
        System.out.println(" ___       __   ________  ________  ________  ________  ________  _________  ________      \n" +
                "|\\  \\     |\\  \\|\\   __  \\|\\   __  \\|\\   __  \\|\\   __  \\|\\   __  \\|\\___   ___\\\\   ____\\     \n" +
                "\\ \\  \\    \\ \\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\___|_    \n" +
                " \\ \\  \\  __\\ \\  \\ \\   __  \\ \\   _  _\\ \\   __  \\ \\  \\\\\\  \\ \\   __  \\   \\ \\  \\ \\ \\_____  \\   \n" +
                "  \\ \\  \\|\\__\\_\\  \\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\ \\  \\   \\ \\  \\ \\|____|\\  \\  \n" +
                "   \\ \\____________\\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\_______\\ \\_______\\ \\__\\ \\__\\   \\ \\__\\  ____\\_\\  \\ \n" +
                "    \\|____________|\\|__|\\|__|\\|__|\\|__|\\|_______|\\|_______|\\|__|\\|__|    \\|__| |\\_________\\\n" +
                "                                                                               \\|_________|\n" +
                "                                                                                           ");
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        game.setPlayer1(new Player());
        game.setPlayer2(new Player());

        System.out.println("Press enter to start!");
        String string = scanner.nextLine();
        if (!string.equals("debug")) {

            System.out.println("Player 1 please place your ships");
            while (game.getPlayer1().getNumShips() < numShips) {
                game.printPlayerBoard(game.getPlayer1());
                System.out.println("Pick your spot for your ship! ex: 'a1 h'");
                game.getPlayer1().takeStartTurn(game.getPlayer1().pickSpot(scanner));
            }

            System.out.println(repeat(50, "\n"));

            System.out.println("Player 2 please place your ships");
            while (game.getPlayer2().getNumShips() < numShips) {
                game.printPlayerBoard(game.getPlayer2());
                System.out.println("Pick your spot for your ship! ex: 'a1 h'");
                game.getPlayer2().takeStartTurn(game.getPlayer2().pickSpot(scanner));
                game.printPlayerBoard(game.getPlayer2());
            }
        } else {
            Main.debug = true;
            System.out.println("Welcome to debug! Ships have been placed for you.");
            game.getPlayer1().setPlayerboard(new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                    {0, 0, 1, 1, 0, 1, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

            });
            game.getPlayer2().setPlayerboard(new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

            });
        }

        while (!win){
            System.out.println(repeat(50, "\n"));
            System.out.println("Player 1 try to guess your opponent ships!");
            game.printOpponentBoard(game.getPlayer1());
            PickSpotResponse response = game.getPlayer1().pickSpot(scanner);

            if (game.getPlayer2().getPlayerboard()[response.getRow()][response.getColumn()] != 0) {
                game.getPlayer1().getOpponentboard()[response.getRow()][response.getColumn()] = 3;
            } else {
                game.getPlayer1().getOpponentboard()[response.getRow()][response.getColumn()] = 2;
            }
            game.getPlayer1().getPlayerboard()[response.getRow()][response.getColumn()] = 0;
            game.printOpponentBoard(game.getPlayer1());

            System.out.println("Click to continue");
            scanner.nextLine();

            if (game.checkWin(game.getPlayer1())) {
                win = true;
                System.out.println("Game over! Player 2 won!");
            }

            System.out.println(repeat(50, "\n"));

            System.out.println("Player 2 try to guess your opponent ships!");
            game.printOpponentBoard(game.getPlayer2());
            response = game.getPlayer2().pickSpot(scanner);

            if (game.getPlayer1().getPlayerboard()[response.getRow()][response.getColumn()] != 0) {
                game.getPlayer2().getOpponentboard()[response.getRow()][response.getColumn()] = 3;
            } else {
                game.getPlayer2().getOpponentboard()[response.getRow()][response.getColumn()] = 2;
            }
            game.getPlayer2().getPlayerboard()[response.getRow()][response.getColumn()] = 0;
            game.printOpponentBoard(game.getPlayer2());
            System.out.println("Click to continue");
            scanner.nextLine();

            if (game.checkWin(game.getPlayer2())) {
                win = true;
                System.out.println("Game over! Player 1 won!");
            }
        }
        if (Main.debug)
        System.out.println("it ended");
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

}
