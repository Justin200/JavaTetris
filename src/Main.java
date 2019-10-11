
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Tetris");
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        Board board = new Board(10, 20);
        board.requestFocusInWindow();
        new Listener(board);
        container.add(board, BorderLayout.CENTER);

        window.setContentPane(container);
        window.setSize(333, 685);
        window.setLocation(150,50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);

        board.addToArray(new Block());
        //board.generateShadow();
        board.refresh();


//        board.moveShapeLeft();
//        board.refresh();
//        board.moveShapeLeft();
//        board.refresh();
//        board.moveShapeLeft();
//        board.refresh();
//        board.refresh();

        //board.moveShapeLeft(block);
        //board.moveShapeRight(block);

    }
}
