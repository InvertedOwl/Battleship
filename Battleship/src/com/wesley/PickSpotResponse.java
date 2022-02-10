package com.wesley;

public class PickSpotResponse {
    private int row;
    private int column;
    private int size;
    private boolean horizontal;

    public PickSpotResponse(int row, int column, int size, boolean horizontal) {
        this.row = row;
        this.column = column;
        this.size = size;
        this.horizontal = horizontal;
    }
    public PickSpotResponse(int row, int column, int size) {
        this.row = row;
        this.column = column;
        this.size = size;
        this.horizontal = true;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
}
