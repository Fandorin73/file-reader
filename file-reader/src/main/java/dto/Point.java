package dto;

import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = 129348938L;
    private String name;
    private int x;
    private int y;


    public Point() {
    }

    public Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;

    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    @Override
    public String toString() {
        return  "Name='" + name + '\'' +
                ", X=" + x +
                ", Y=" + y +
                '}';
    }
}
