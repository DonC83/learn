package com.donc;

/**
 * Created by donovan on 2016/02/02.
 */
public class RobotSim {

    public enum DIRECTION {
        NORTH, SOUTH, EAST, WEST
    }

    public enum COMMAND {
        FORWARD, TURN_LEFT, TURN_RIGHT
    }

    private Position position;


    public void init(int x, int y, DIRECTION direction) {
        if (x>4 || y>4) {
            throw new IllegalArgumentException("Invalid co-ordinates provided");
        }
        position = new Position();
        position.setX(x);
        position.setY(y);
        position.setDirection(direction);
    }

    public void move(COMMAND command) {
        if ((position.getX()==0 && position.getDirection()==DIRECTION.WEST && command== COMMAND.FORWARD) ||
                (position.getX()==4 && position.getDirection()==DIRECTION.EAST && command== COMMAND.FORWARD)) {
            //do nothing
        } else if ((position.getY()==0 && position.getDirection()==DIRECTION.SOUTH && command== COMMAND.FORWARD) ||
                (position.getY()==4 && position.getDirection()==DIRECTION.NORTH && command== COMMAND.FORWARD)) {
            //do nothing
        } else {

            if (command == COMMAND.FORWARD) {
                switch (position.getDirection()) {
                    case NORTH: {
                        int i = position.getY();
                        position.setY(++i);
                        break;
                    }
                    case SOUTH: {
                        int i = position.getY();
                        position.setY(--i);
                        break;
                    }
                    case EAST: {
                        int i = position.getX();
                        position.setX(++i);
                        break;
                    }
                    case WEST: {
                        int i = position.getX();
                        position.setX(--i);
                        break;
                    }
                }
            } else if (command == COMMAND.TURN_LEFT) {
                switch (position.getDirection()) {
                    case NORTH: {
                        position.setDirection(DIRECTION.WEST);
                        break;
                    }
                    case SOUTH: {
                        position.setDirection(DIRECTION.EAST);
                        break;
                    }
                    case EAST: {
                        position.setDirection(DIRECTION.NORTH);
                        break;
                    }
                    case WEST: {
                        position.setDirection(DIRECTION.SOUTH);
                        break;
                    }
                }
            } else if (command == COMMAND.TURN_RIGHT) {
                switch (position.getDirection()) {
                    case NORTH: {
                        position.setDirection(DIRECTION.EAST);
                        break;
                    }
                    case SOUTH: {
                        position.setDirection(DIRECTION.WEST);
                        break;
                    }
                    case EAST: {
                        position.setDirection(DIRECTION.SOUTH);
                        break;
                    }
                    case WEST: {
                        position.setDirection(DIRECTION.NORTH);
                        break;
                    }
                }
            }
        }
    }

    public String getGPSReport() {
        return position.getX() + "," + position.getY() + "," + position.getDirection().toString();
    }

}
