package Inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utils.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 'A')
        {
            gamePanel.getGame().getPlayer().setA(true);
            //gamePanel.getGame().getPlayer().setDirection(LEFT);
        }
        if(e.getKeyCode() == 'S')
        {
            gamePanel.getGame().getPlayer().setS(true);
            //gamePanel.getGame().getPlayer().setDirection(DOWN);
        }
        if(e.getKeyCode() == 'D')
        {
            gamePanel.getGame().getPlayer().setD(true);
            //gamePanel.getGame().getPlayer().setDirection(RIGHT);
        }
        if(e.getKeyCode() == 'W')
        {
            gamePanel.getGame().getPlayer().setW(true);
            //gamePanel.getGame().getPlayer().setDirection(UP);
        }

        if(e.getKeyCode() == 32)
        {
            gamePanel.getGame().getPlayer().setJump(true);
            if(gamePanel.getGame().getPlayer().getJump())
            {
                System.out.println("merge spaceu");
            }
            else
                System.out.println("nu merge");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == 'A' || e.getKeyCode() == 'S' || e.getKeyCode() == 'W' || e.getKeyCode() == 'D')
        {
            gamePanel.getGame().getPlayer().setMoving(false);
            gamePanel.getGame().getPlayer().setAllFalse();
        }
        if(e.getKeyCode() == 32)
        {
            gamePanel.getGame().getPlayer().setJump(false);
            if(!gamePanel.getGame().getPlayer().getJump())
            {
                System.out.println("merge sa cada inapoi");
            }
        }
    }
}
