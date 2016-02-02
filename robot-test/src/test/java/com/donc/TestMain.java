package com.donc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by donovan on 2016/02/02.
 */
public class TestMain {

    private RobotSim robotSim;

    @Before
    public void setUp() throws Exception {
        robotSim = new RobotSim();
    }

    @After
    public void tearDown() throws Exception {
        robotSim = null;
    }

    @Test
    public void testFirstMovement() throws Exception {
        robotSim.init(0,0, RobotSim.DIRECTION.NORTH);
        robotSim.move(RobotSim.COMMAND.FORWARD);
        assertEquals("0,1,NORTH", robotSim.getGPSReport());
    }

    @Test
    public void testSecondMovement() throws Exception {
        robotSim.init(0,0, RobotSim.DIRECTION.NORTH);
        robotSim.move(RobotSim.COMMAND.TURN_LEFT);
        assertEquals("0,0,WEST", robotSim.getGPSReport());
    }

    @Test
    public void testThirdMovement() throws Exception {
        robotSim.init(1,2, RobotSim.DIRECTION.EAST);
        robotSim.move(RobotSim.COMMAND.FORWARD);
        robotSim.move(RobotSim.COMMAND.FORWARD);
        robotSim.move(RobotSim.COMMAND.TURN_LEFT);
        robotSim.move(RobotSim.COMMAND.FORWARD);
        assertEquals("3,3,NORTH", robotSim.getGPSReport());
    }
}
