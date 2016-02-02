package com.donc;

/**
 * Created by donovan on 2016/02/02.
 */
public class Position {
    private int x;
    private int y;
    private RobotSim.DIRECTION direction;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public RobotSim.DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(RobotSim.DIRECTION direction) {
        this.direction = direction;
    }
}
