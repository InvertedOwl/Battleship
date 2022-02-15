package com.wesley;

public class Game {
    private Player player1;
    private Player player2;

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void printPlayerBoard(Player player) {
        System.out.println("  A  B  C  D  E  F  G  H  I  J");
        for(int i = 0; i < player.getPlayerboard().length; i++){
            int[] row = player.getPlayerboard()[i];
            System.out.print(i + " ");
            for (int value : row){
                if (value == 0) {
                    System.out.print("-  ");
                } else if (value == 1) {
                    System.out.print("Z  ");
                }
            }
            System.out.println();
        }
    }
    public void printOpponentBoard(Player player) {
        System.out.println("  A  B  C  D  E  F  G  H  I  J");
        for(int i = 0; i < player.getOpponentboard().length; i++){
            int[] row = player.getOpponentboard()[i];
            System.out.print(i + " ");
            for (int value : row){
                if (value == 0) {
                    System.out.print("-  ");
                } else if (value == 1) {
                    System.out.print("Z  ");
                } else if (value == 3){
                    System.out.print("K  ");
                }
                else if (value == 2){
                    System.out.print("M  ");
                }
            }
            System.out.println();
        }
    }

    public Player checkWin() {
        boolean win = true;
        for (int i = 0; i < player1.getPlayerboard().length; i++) {
            for (int j = 0; j < player1.getPlayerboard().length; j++) {
                if (player2.getOpponentboard()[i][j] == 0 && player1.getPlayerboard()[i][j] != 0) win = false;
            }
        }
        if (win) return player2;

        for (int i = 0; i < player2.getPlayerboard().length; i++) {
            for (int j = 0; j < player2.getPlayerboard().length; j++) {
                if (player1.getOpponentboard()[i][j] == 0 && player2.getPlayerboard()[i][j] != 0) return null;
            }
        }
        return player1;
    }

    public void printTitle() {
        System.out.println("""
                ██╗    ██╗ █████╗ ██████╗ ██████╗  ██████╗  █████╗ ████████╗███████╗
                ██║    ██║██╔══██╗██╔══██╗██╔══██╗██╔═══██╗██╔══██╗╚══██╔══╝██╔════╝
                ██║ █╗ ██║███████║██████╔╝██████╔╝██║   ██║███████║   ██║   ███████╗
                ██║███╗██║██╔══██║██╔══██╗██╔══██╗██║   ██║██╔══██║   ██║   ╚════██║
                ╚███╔███╔╝██║  ██║██║  ██║██████╔╝╚██████╔╝██║  ██║   ██║   ███████║
                 ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚══════╝
                                                                                   \s""");
    }

}
