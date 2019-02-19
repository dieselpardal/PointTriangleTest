//import Components.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener{

    private PointTriangle pointTriangle = new PointTriangle();

    Board() {
        setFocusable(true);
        this.pointTriangle.valueDefault();
        Timer timer = new Timer(10, this);
        timer.start();
    }
    public void paint(Graphics g) {
        this.pointTriangle.cls(g);
        this.pointTriangle.relogio(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
