package com.wesley;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int[][] opponentboard = new int[10][10];
    private int[][] playerboard = new int[10][10];

    public int[][] getOpponentboard() {
        return opponentboard;
    }

    public void setOpponentboard(int[][] opponentboard) {
        this.opponentboard = opponentboard;
    }

    public int[][] getPlayerboard() {
        return playerboard;
    }

    public void setPlayerboard(int[][] playerboard) {
        this.playerboard = playerboard;
    }
    private int numShips = 0;


    /**
     * @param scanner
     * @return Returns an object with all the information needed to place a ship or guess a spot
     */
    public PickSpotResponse pickSpot(Scanner scanner) {
        String spot = scanner.nextLine();
        int row = 0;
        int column = 0;


        boolean horizontal = false;
        try {
            row = Integer.parseInt(spot.substring(1, 2));
            column = (int) spot.substring(0, 1).toLowerCase().charAt(0) - 97;
            horizontal = spot.substring(3, 4).contains("h");
        } catch (Exception e){
            horizontal = true;
        }


        // TODO gross code do not look please
        if (numShips < Main.numShips){
            if (horizontal) {
                if (column + numShips + 1 < playerboard[row].length - 1){

                } else {
                    System.out.println("Invalid spot, Ship goes off board. Please try again");
                    System.out.println(column + numShips + 1 + ", " + playerboard[row].length);
                }
            }
            if (!horizontal) {
                if (row + numShips + 1 < playerboard.length - 1) {

                } else {
                    System.out.println("Invalid spot, Ship goes off board. Please try again");
                    System.out.println(column + numShips + 1 + ", " + playerboard[row].length);
                }
            }
        }

        while (!horizontal && !(row + numShips + 1 < playerboard.length - 1)){
            System.out.println("Invalid spot, Ship goes off board. Please try again");
            spot = scanner.nextLine();
            try {
                row = Integer.parseInt(spot.substring(1, 2));
                column = (int) spot.substring(0, 1).toLowerCase().charAt(0) - 97;
                horizontal = spot.substring(3, 4).contains("h");
            } catch (Exception e){
                horizontal = true;
            }
        }
        while (horizontal && !(column + numShips + 1 < playerboard[row].length - 1)){
            System.out.println("Invalid spot, Ship goes off board. Please try again");
            spot = scanner.nextLine();
            try {
                row = Integer.parseInt(spot.substring(1, 2));
                column = (int) spot.substring(0, 1).toLowerCase().charAt(0) - 97;
                horizontal = spot.substring(3, 4).contains("h");
            } catch (Exception e){
                horizontal = true;
            }
        }

        return new PickSpotResponse(row, column, numShips + 1, horizontal);
    }


    public void takeStartTurn(PickSpotResponse pickSpotResponse) {

        for (int i = 0; i < pickSpotResponse.getSize(); i ++){
            //line 70
            if (pickSpotResponse.isHorizontal()){
                playerboard[pickSpotResponse.getRow()][pickSpotResponse.getColumn() + i] = 1;
            } else {
                playerboard[pickSpotResponse.getRow() + i][pickSpotResponse.getColumn()] = 1;
            }
        }
        numShips++;
    }

    public int getNumShips() {
        return numShips;
    }
}
