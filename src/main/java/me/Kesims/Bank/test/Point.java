package me.Kesims.Bank.test;

public class Point {
    private int X;
    private int Y;

    public Point(int X, int Y) {
        setX(X);
        setY(Y);
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
