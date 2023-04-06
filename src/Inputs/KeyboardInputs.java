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

        }
        if(e.getKeyCode() == 'S')
        {
            gamePanel.getGame().getPlayer().setS(true);

        }
        if(e.getKeyCode() == 'D')
        {
            gamePanel.getGame().getPlayer().setD(true);

        }
        if(e.getKeyCode() == 'W')
        {
            gamePanel.getGame().getPlayer().setW(true);

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == 'A')
        {
            gamePanel.getGame().getPlayer().setA(false);
        }
        if(e.getKeyCode() == 'S')
        {
            gamePanel.getGame().getPlayer().setS(false);
        }
        if(e.getKeyCode() == 'W')
        {
            gamePanel.getGame().getPlayer().setW(false);
        }
        if(e.getKeyCode() == 'D')
        {
            gamePanel.getGame().getPlayer().setD(false);
        }

    }
}
