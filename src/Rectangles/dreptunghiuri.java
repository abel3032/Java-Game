package Rectangles;

import java.util.Random;

import java.lang.Math.*;


public class dreptunghiuri {
    public float x, y, xDir, yDir;

    private float min = -0.10f, max = 0.15f;

    public dreptunghiuri(float x, float y)
    {

        this.x = x;
        this.y = y;
        this.xDir = (float)Math.floor(Math.random()*(max-min+1)+min);
        this.yDir = (float)Math.floor(Math.random()*(max-min+1)+min);
    }

    public float getxDir() {
        return xDir;
    }

    public float getyDir() {
        return yDir;
    }

    public void setxDir(float xDir) {
        this.xDir = xDir;
    }

    public void setyDir(float yDir) {
        this.yDir = yDir;
    }
}
