package com.wesley;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int[][] opponentboard = new int[10][10];
    private int[][] playerboard = new int[10][10];
    private ArrayList<Ship> shipsList = new ArrayList<>();

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

    public ArrayList<Ship> getShipsList() {
        return shipsList;
    }

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
        if (shipsList.size() < Main.numShips){
            if (horizontal) {
                if (column + shipsList.size() + 1 < playerboard[row].length){

                } else {
                    System.out.println("Invalid spot, Ship goes off board. Please try again");
                    System.out.println(column + shipsList.size() + 1 + ", " + playerboard[row].length);
                }
            }
            if (!horizontal) {
                if (row + shipsList.size() + 1 < playerboard.length) {

                } else {
                    System.out.println("Invalid spot, Ship goes off board. Please try again");
                    System.out.println(column + shipsList.size() + 1 + ", " + playerboard[row].length);
                }
            }
        }

        System.out.println(column + ", " + row);
        return new PickSpotResponse(row, column, getShipsList().size() + 1, horizontal);
    }


    public void takeStartTurn(PickSpotResponse pickSpotResponse){
        Ship ship = new Ship( shipsList.size() + 1, new ArrayList<>());
        for (int i = 0; i < pickSpotResponse.getSize(); i ++){
            //line 70
            if (pickSpotResponse.isHorizontal()){
                playerboard[pickSpotResponse.getRow()][pickSpotResponse.getColumn() + i] = 1;
                ship.getShipPoints().add(new Point(pickSpotResponse.getColumn() + i, pickSpotResponse.getRow()));
            } else {
                playerboard[pickSpotResponse.getRow() + i][pickSpotResponse.getColumn()] = 1;
                ship.getShipPoints().add(new Point(pickSpotResponse.getColumn(), pickSpotResponse.getRow() + i));

            }
        }

        getShipsList().add(ship);
    }
}
