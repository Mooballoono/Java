import javax.swing.JFrame;

public class BallTest extends JFrame{
    public BallTest() {
        setTitle("BallTest");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1, 1, 800, 600);
    }

    public static void main(String[] args) {
        BallTest frame = new BallTest();
        frame.setVisible(true);
    }
}