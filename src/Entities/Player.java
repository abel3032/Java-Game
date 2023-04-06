package Entities;


import utils.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.*;
import static utils.Constants.Directions.DOWN;
import static utils.Constants.playerConstants.*;

public class Player extends Entity{

    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 25;
    private int playerAction = IDLE;
    private boolean moving = false;
    private boolean attacking = false;
    public boolean A , S , D , W ;


    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void setA(boolean mov)
    {
        this.A = mov;

    }

    public void setS(boolean mov)
    {
        this.S = mov;

    }

    public void setW(boolean mov)
    {
        this.W = mov;

    }

    public void setD(boolean mov)
    {
        this.D = mov;

    }



    public void update()
    {
        updatePos();
        updateAnimationsTick();
        setAnimation();
    }

    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][animationIndex], (int)x, (int)y, 128, 80, null);
    }




    public boolean getA()
    {
        return A;
    }

    public boolean getMoving()
    {
        return moving;
    }

    public void setMoving(boolean moving)
    {
        this.moving = moving;
    }

    public void setAttacking(boolean attacking)
    {
        this.attacking = attacking;
    }

    private void updateAnimationsTick() {
        animationTick++;
        if(animationTick >= animationSpeed)
        {
            animationTick = 0;
            animationIndex ++;
            if(animationIndex >= getSpriteAmmount(playerAction))
            {
                animationIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {
        int startAnimation = playerAction;

        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;

        if(attacking)
            playerAction = ATTACK1;

        if(startAnimation != playerAction)
            resetAniTick();

    }

    private void resetAniTick() {
        animationTick = 0;
        animationIndex = 0;
    }

    private void updatePos()
    {
        moving = false;
        if(A && !D)
        {
            x-=2;
            moving = true;
        }else if(D && !A)
        {
            x+=2;
            moving = true;
        }
        if(W && !S)
        {
            y-=2;
            moving = true;
        }else if (!W && S)
        {
            y+=2;
            moving = true;
        }
    }

    private void loadAnimations() {


            BufferedImage img = LoadSave.getSpriteAtlas(LoadSave.PLAYER_ATLAS);

            animations = new BufferedImage[9][6];
            for(int j=0; j<animations.length; j++)
                for(int i=0; i<animations[j].length; i++)
                {
                    animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
                }
    }

    public void resetDirBooleans() {
        setA(false);
        setS(false);
        setD(false);
        setW(false);
    }
}
