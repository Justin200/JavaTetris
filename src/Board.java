/**
 * Created by justinhu on 5/22/17.
 */
// TODO: 5/23/17 Add scoring, rotation bug, rotating around left and not center 

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;


// refresh and row clearing don't go together
// check if rotate
// rotate around center
// implement other basic design like score and increased difficulty
// shadow
// space function ^^ shadow uses that
// display next block


public class Board extends JPanel {

    private int[][] boardArray;
    private ArrayList<Block> blocks = new ArrayList();
    private int counter = 0;

    public Board(int width, int height) {
        boardArray = new int[width][height];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                boardArray[i][j] = 0;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 333, 663);
        g.setColor(Color.BLACK);
        for(int i = 3; i < 333; i+=33) {
            for(int j = 3; j < 663; j+=33) {
                g.fillRect(i, j, 30, 30);
            }
        }

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 20; j++) {
                if(boardArray[i][j] == 1) {
                    g.setColor(Color.YELLOW);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
                else if(boardArray[i][j] == 2) {
                    g.setColor(Color.CYAN);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
                else if(boardArray[i][j] == 3) {
                    g.setColor(Color.RED);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
                else if(boardArray[i][j] == 4) {
                    g.setColor(Color.GREEN);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
                else if(boardArray[i][j] == 5) {
                    g.setColor(Color.ORANGE);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
                else if(boardArray[i][j] == 6) {
                    g.setColor(Color.BLUE);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
                else if(boardArray[i][j] == 7) {
                    g.setColor(Color.MAGENTA);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
                else if(boardArray[i][j] == 8) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect((i*30)+(i*3)+3, (j*30)+(j*3)+3, 30, 30);
                }
            }
        }

    }

    public int[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(int[][] boardArray) {
        this.boardArray = boardArray;
    }

    public int getBlockSize() {
        return blocks.size();
    }

    public void addToArray(Block block) {
        blocks.add(block);
    }

    public void refresh() {

        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 20; col++) {
                boardArray[row][col] = 0;
            }
        }

        for(int i = 0; i < blocks.size(); i++) {
            Block currentBlock = blocks.get(i);
            for(int j = 0; j < currentBlock.getHeight(); j++) {
                for(int k = 0; k < currentBlock.getWidth(); k++) {
                    if(currentBlock.getBoardArray()[k][j] != 0)
                        boardArray[k+currentBlock.getX()][j+currentBlock.getY()] = currentBlock.getBoardArray()[k][j];
                }
            }
        }
    }

    public void checkBoardClear() {
        boolean shouldClear = true;
        int rowToClear = 0;

        for(int i = boardArray[0].length - 1; i > 1; i--) {
            for(int j = 0; j < boardArray.length; j++) {
                if(boardArray[j][i] == 0)
                    shouldClear = false;
            }
            if(shouldClear) {
                System.out.println(shouldClear);
                for(int x = i; x > 1; x--) {
                    for(int y = 0; y < boardArray.length; y++) {
                        boardArray[y][x] = boardArray[y][x-1];
                    }
                    refresh();
                }
                //i++;
            }
        }
        //refresh();
    }

    public void moveShapeLeft() {
        blocks.get(blocks.size() - 1).setX(blocks.get(blocks.size() - 1).getX()-1);
    }

    public void moveShapeRight() {
        blocks.get(blocks.size() - 1).setX(blocks.get(blocks.size() - 1).getX()+1);
    }

    public void moveShapeDown() {
        blocks.get(blocks.size() - 1).changeY(1);
    }

    public void rotate() {

        // can't rotate at edges - checkAvailabletoRotate()

        // fix it so that it rotates around the middle of the array rather than the left
        // so edit the x and y values of the thing

        int[][] rotatedArray = new int[blocks.get(blocks.size() - 1).getHeight()]
                [blocks.get(blocks.size() - 1).getWidth()];
        for (int x = 0; x < blocks.get(blocks.size() - 1).getWidth(); x++) {
            for (int y = 0; y < blocks.get(blocks.size() - 1).getHeight(); y++) {
                rotatedArray[y][x] = blocks.get(blocks.size() - 1).getBoardArray()[x][blocks.get(blocks.size() - 1).getHeight() - y - 1];
            }
        }

        int height = blocks.get(blocks.size() - 1).getHeight();
        int width = blocks.get(blocks.size() - 1).getWidth();

        blocks.get(blocks.size() - 1).setHeight(width);
        blocks.get(blocks.size() - 1).setWidth(height);
        blocks.get(blocks.size() - 1).setBoardArray(rotatedArray);
        refresh();

    }

    public boolean checkAvailableRotate() {
//        if(){  ///For block type
//
//        }
        /////if(blocks.get(blocks.size() - 1).rotate())

        // compare every space of the blockboard to the og total blockboard and see if there are
        // any overlaps

        return true;
    }

    public boolean checkAvailableLeft() {
        if(blocks.get(blocks.size() - 1).getX() <= 0) {
            return false;
        }
        for(int i = 0; i < blocks.get(blocks.size() - 1).getHeight(); i++) {
            int counter = 0;
            if(blocks.get(blocks.size() - 1).getBoardArray()[0][i] == 0) {
                counter++;
                if(blocks.get(blocks.size() - 1).getBoardArray()[1][i] == 0)
                    counter++;
            }
            if(boardArray[blocks.get(blocks.size() - 1).getX() - 1 + counter][blocks.get(blocks.size() - 1).getY() + i] != 0)
                return false;
        }
        return true;
    }

    public boolean checkAvailableRight() {
        if(blocks.get(blocks.size() - 1).getX() + blocks.get(blocks.size() - 1).getWidth()  > 9) {
            return false;
        }
        for(int i = 0; i < blocks.get(blocks.size() - 1).getHeight(); i++) {
            int counter = 0;
            if(blocks.get(blocks.size() - 1).getBoardArray()[blocks.get(blocks.size() - 1).getWidth() - 1][i] == 0) {
                counter++;
                if(blocks.get(blocks.size() - 1).getBoardArray()[blocks.get(blocks.size() - 1).getWidth() - 2][i] == 0) {
                    counter++;
                }
            }
            if(boardArray[blocks.get(blocks.size() - 1).getX() + blocks.get(blocks.size() - 1).getWidth() - counter][blocks.get(blocks.size() - 1).getY() + i] != 0)
                return false;
        }
        return true;
    }

    public boolean checkAvailableDown() {
        if(blocks.get(blocks.size() - 1).getHeight() + blocks.get(blocks.size() - 1).getY() >= 20) {
            return false;
        }
        for(int i = 0; i < blocks.get(blocks.size() - 1).getWidth(); i++) {
            int counter = 0;
            if(blocks.get(blocks.size() - 1).getBoardArray()[i][blocks.get(blocks.size() - 1).getHeight() - 1] == 0) {
                counter++;
                if(blocks.get(blocks.size() - 1).getBoardArray()[i][blocks.get(blocks.size() - 1).getHeight() - 2] == 0) {
                    counter++;
                }
            }
            if(boardArray[blocks.get(blocks.size() - 1).getX() + i][blocks.get(blocks.size() - 1).getY() + blocks.get(blocks.size() - 1).getHeight() - counter] != 0)
                return false;
        }
        return true;
    }

}
