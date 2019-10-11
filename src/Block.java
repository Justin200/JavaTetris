
public class Block {

    private BlockBoard board;
    private int random = (int)(Math.random()*7);
    int width;
    int height;
    int x;
    int y;

    public Block() {
        if(random == 0) {
            board = new BlockBoard(2, 2);
            width = 2;
            height = 2;
        }
        else if(random == 1) {
            board = new BlockBoard(1, 4);
            width = 1;
            height = 4;
        }
        else if(random == 2) {
            board = new BlockBoard(3, 2);
            width = 3;
            height = 2;
        }
        else if(random == 3) {
            board = new BlockBoard(3, 2);
            width = 3;
            height = 2;
        }
        else if(random == 4) {
            board = new BlockBoard(2, 3);
            width = 2;
            height = 3;
        }
        else if(random == 5) {
            board = new BlockBoard(2, 3);
            width = 2;
            height = 3;
        }
        else {
            board = new BlockBoard(3, 2);
            width = 3;
            height = 2;
        }
        generateShape();
        x = 3;
        y = 0;
    }

    public void generateShape() {
        if(random == 0) {
            board.getBoardArray()[0][0] = 1;
            board.getBoardArray()[0][1] = 1;
            board.getBoardArray()[1][0] = 1;
            board.getBoardArray()[1][1] = 1;
        }
        else if(random == 1) {
            board.getBoardArray()[0][0] = 2;
            board.getBoardArray()[0][1] = 2;
            board.getBoardArray()[0][2] = 2;
            board.getBoardArray()[0][3] = 2;
        }
        else if(random == 2) {
            board.getBoardArray()[0][1] = 3;
            board.getBoardArray()[1][0] = 3;
            board.getBoardArray()[1][1] = 3;
            board.getBoardArray()[2][0] = 3;
        }
        else if(random == 3) {
            board.getBoardArray()[0][0] = 4;
            board.getBoardArray()[1][0] = 4;
            board.getBoardArray()[1][1] = 4;
            board.getBoardArray()[2][1] = 4;
        }
        else if(random == 4) {
            board.getBoardArray()[0][0] = 5;
            board.getBoardArray()[0][1] = 5;
            board.getBoardArray()[0][2] = 5;
            board.getBoardArray()[1][2] = 5;
        }
        else if(random == 5) {
            board.getBoardArray()[0][2] = 6;
            board.getBoardArray()[1][0] = 6;
            board.getBoardArray()[1][1] = 6;
            board.getBoardArray()[1][2] = 6;
        }
        else {
            board.getBoardArray()[0][0] = 7;
            board.getBoardArray()[1][0] = 7;
            board.getBoardArray()[2][0] = 7;
            board.getBoardArray()[1][1] = 7;
        }
    }

    public int[][] getBoardArray() {
        return board.getBoardArray();
    }

    public void setBoardArray(int[][] board) {
        this.board.setBoardArray(board);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void changeY(int y) {
        this.y += y;
    }
}
