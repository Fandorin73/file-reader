package dto;

import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = 129348938L;
    private String name;
    private int x;
    private int y;
    private int z;

    public Point() {
    }

    public Point(String name, int x, int y, int z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
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

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return  "Name='" + name + '\'' +
                ", X=" + x +
                ", Y=" + y +
                ", Z=" + z +
                '}';
    }
}
