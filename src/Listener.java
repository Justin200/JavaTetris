
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Timer;
import javax.swing.event.ChangeListener;

public class Listener implements MouseListener, MouseMotionListener,
        KeyListener, ActionListener, FocusListener {

    Board gameBoard;
    Timer timer;

    public Listener(Board gameBoard) {
        this.gameBoard = gameBoard;
        gameBoard.addKeyListener(this);
        gameBoard.addMouseListener(this);
        gameBoard.addMouseMotionListener(this);
        gameBoard.addFocusListener(this);
        gameBoard.setFocusable(true);
        timer = new Timer(600, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s == null) {
            if(gameBoard.getBlockSize() != 0) {
                if(gameBoard.checkAvailableDown() == true) {
                    gameBoard.moveShapeDown();
                    gameBoard.refresh();
                    gameBoard.repaint();
                }
                else {
                    gameBoard.checkBoardClear();
                    gameBoard.addToArray(new Block());
                    gameBoard.refresh();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            if(gameBoard.checkAvailableLeft())
                gameBoard.moveShapeLeft();
            gameBoard.refresh();
            gameBoard.repaint();
        }
        else if (code == KeyEvent.VK_RIGHT) {
            if(gameBoard.checkAvailableRight())
                gameBoard.moveShapeRight();
            gameBoard.refresh();
            gameBoard.repaint();
        }
        else if (code == KeyEvent.VK_DOWN) {
            if(gameBoard.checkAvailableDown())
                gameBoard.moveShapeDown();
            gameBoard.refresh();
            gameBoard.repaint();
        }
        else if (code == KeyEvent.VK_UP) {
            if(gameBoard.checkAvailableRotate())
                gameBoard.rotate();
            gameBoard.refresh();
            gameBoard.repaint();
        }
        else if (code == KeyEvent.VK_ENTER) {
            if(gameBoard.checkAvailableRotate())
                gameBoard.rotate();
            gameBoard.refresh();
            gameBoard.repaint();
        }
        gameBoard.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub
        timer.start();
    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub
        timer.stop();
    }

}
