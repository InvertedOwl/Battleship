package com.wesley;

import java.awt.*;
import java.util.ArrayList;

public class Ship {
    private ArrayList<Point> shipPoints = new ArrayList<>();
    private int size;

    public Ship(int size, ArrayList<Point> shipPoints) {
        this.size = size;
        this.shipPoints = shipPoints;
    }

    public ArrayList<Point> getShipPoints() {
        return shipPoints;
    }

    public void setShipPoints(ArrayList<Point> shipPoints) {
        this.shipPoints = shipPoints;
    }
}
