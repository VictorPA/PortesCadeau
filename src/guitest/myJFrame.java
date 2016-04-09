package guitest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Victor on 09/04/2016.
 */
public class myJFrame extends JFrame implements MouseListener, MouseMotionListener {

    private int quantMouvement;
    JTextArea inputGames;
    JTextArea inputDoors;
    JButton validate;

    public myJFrame() {


        this.quantMouvement = 0;
        Container pane = this.getContentPane();
        setVisible(true);
        setTitle("Jeu des portes");
        setBounds(new Rectangle(new Dimension(800, 500)));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pane.setLayout(new FlowLayout());


        addMouseListener(this);
        addMouseMotionListener(this);

        //Button
        validate = new JButton("Simulation");
        pane.add(validate);
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi "+quantMouvement++);
            }
        });



        //Text labels
        inputGames = new JTextArea();
        inputDoors = new JTextArea();
        pane.add(inputGames);
        pane.add(inputDoors);




    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Je click");

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Je relâche");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //  System.out.println("Je rentre");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //  System.out.println("Je sors");
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        //System.out.println("Je bouge : " + this.quantMouvement++ + "x: "+e.getX()+",y: "+e.getY()+".");
    }

    @Override
    public void mouseMoved(MouseEvent e) {


    }
}
