package Entities;

import java.beans.Beans;

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
    private int animationTick, animationIndex, animationSpeed = 20;
    private int playerAction = IDLE;
    private int playerDir = -1;
    public float y_initial;
    private boolean moving = false;
    private boolean attacking = false;
    public boolean A = false, S = false, D = false, W = false;
    public boolean jumping = false;


    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void setA(boolean mov)
    {
        this.A = mov;
        moving = true;
    }

    public void setAllFalse()
    {
        A = false;
        S = false;
        D = false;
        W = false;
    }

    public void setS(boolean mov)
    {
        this.S = mov;
        moving = true;
    }

    public void setW(boolean mov)
    {
        this.W = mov;
        moving = true;
    }

    public void setD(boolean mov)
    {
        this.D = mov;
        moving = true;
    }



    public void update()
    {
        updateAnimationsTick();
        setAnimation();
        updatePos();
    }

    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][animationIndex], (int)x, (int)y, 256, 160, null);
    }

    /*public void setDirection(int direction)
    {
        this.playerDir = direction;
        moving = true;
    }*/

    public void setJump(boolean jump)
    {
        jumping = jump;
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
            }
        }
    }

    private void setAnimation() {
        if(moving)
        {
            playerAction = RUNNING;
            if(attacking)
            {
                playerAction = ATTACK1;
            }
        }

        if(!moving)
        {
            if(attacking)
            {
                playerAction = ATTACK1;
            }
            else
                playerAction = IDLE;
            if(jumping)
            {
                playerAction = JUMP;
            }
        }

    }

    /*private void updatePos() {
        if(moving)
        {
            if(playerDir == LEFT)
            {
                x-=2;
            }

            if(playerDir == UP)
            {
                y-=2;
            }

            if(playerDir == RIGHT)
            {
                x+=2;
            }

            if(playerDir == DOWN)
            {
                y+=2;
            }
        }
    }*/



    private void updatePos()
    {
        if(moving)
        {
            if(A)
            {
                x-=2;
            }
            if(S)
            {
                y+=2;
            }
            if(D)
            {
                x+=2;
            }
            if(W)
            {
                y-=2;
            }
        }
        if(jumping)
        {

            y-=2;
            //setJump(false);
        }


    }

    public boolean getJump()
    {
        return this.jumping;
    }

    private void loadAnimations() {

        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try{
            BufferedImage img = ImageIO.read(is);

            animations = new BufferedImage[9][6];
            for(int j=0; j<animations.length; j++)
                for(int i=0; i<animations[j].length; i++)
                {
                    animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
                }

            } catch(IOException e){
                e.printStackTrace();
            }finally
            {
                try{
                    is.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
    }
}
