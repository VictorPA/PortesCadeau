package guitest;

import controller.Controller;
import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

/**
 * Created by Victor on 09/04/2016.
 */
public class MyJFrame extends JFrame {

    private Controller controller;

    private final static int flowsNumber = 4;

    private final JPanel[] flows = new JPanel[flowsNumber];
    private final JLabel nbParties;
    private final JLabel nbPortes;
    private final JLabel result;
    private final JRadioButton[] joueurs;

    private BufferedImage doorPic;


    public MyJFrame(Controller controller) throws IOException {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        this.controller = controller;
        doorPic = ImageIO.read(new File("src\\door.jpg"));
        setTitle("Monty Hall Simulation");

        JTextField field = new JTextField();
        field.setColumns(10);
        nbParties = new JLabel("Number of simulations:");
        nbParties.setFont(Font.getFont(Font.MONOSPACED));
        nbPortes = new JLabel("Number of doors:     ");
        nbPortes.setFont(Font.getFont(Font.MONOSPACED));
        result = new JLabel("Result:");
        result.setFont(Font.getFont(Font.MONOSPACED));
        joueurs = new JRadioButton[2];

        ((AbstractDocument) field.getDocument()).setDocumentFilter(new TextLimiterFilter(10));

        JTextField field2 = new JTextField();
        field2.setColumns(10);
        ((AbstractDocument) field2.getDocument()).setDocumentFilter(new TextLimiterFilter(10));


        JButton boutton = new JButton("Start simulation");


        JRadioButton b1 = new JRadioButton("Always keep");
        b1.setFont(Font.getFont(Font.MONOSPACED));
        joueurs[0] = b1;
        JRadioButton b2 = new JRadioButton("Always change");
        joueurs[1] = b2;
        b2.setFont(Font.getFont(Font.MONOSPACED));

        ButtonGroup group = new ButtonGroup();

        group.add(b1);
        group.add(b2);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(4, 0));

        for (int i = 0; i < flowsNumber; ++i) {
            flows[i] = new JPanel();
            flows[i].setLayout(new FlowLayout(FlowLayout.CENTER, 100, 4 * (int) flows[i].getPreferredSize().getHeight()));
        }

        flows[0].add(nbParties);



        flows[0].add(field);
        flows[0].setBackground(new Color(255, 213, 194));
        flows[0].setMaximumSize(flows[0].getComponent(0).getPreferredSize());
        flows[1].add(nbPortes);
        flows[1].add(field2);

        flows[1].setBackground(new Color(0xF5F5DC));
        flows[2].add(b1);
        //thirdQuarter.add(Box.createHorizontalStrut(500));
        flows[2].add(b2);

        System.out.println(flows[2].getPreferredSize().getHeight());

        flows[2].setBackground(new Color(255, 213, 194));
        flows[3].add(boutton);
        flows[3].add(result);

        ImageIcon monImageIcon = new ImageIcon(doorPic);
        JLabel maPic = new JLabel(monImageIcon);


        flows[3].add(maPic);
        maPic.setVisible(false);

        contentPane.add(flows[0]);
        contentPane.add(flows[1]);
        contentPane.add(flows[2]);
        contentPane.add(flows[3]);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);
        int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 4);

        this.setSize(width, height);
        setLocationRelativeTo(null);
        boutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gamesInput, doorsInput, playerInput = 1;
                try {
                    gamesInput = Integer.parseInt(field.getText());
                    doorsInput = Integer.parseInt(field2.getText());
                    for (int i = 0; i < joueurs.length; ++i) {
                        if (joueurs[i].isSelected())
                            playerInput = i;
                    }
                    controller.send(gamesInput, doorsInput, playerInput);
                    maPic.setVisible(true);
                } catch (NumberFormatException ex) {
                    System.out.println("caught " + ex.toString());

                }


            }

        });

    }

    public void receive(int upper, int bottom) {
        this.result.setText(upper + " won out of " + bottom);


    }

    private class TextLimiterFilter extends DocumentFilter {

        int limit;


        public TextLimiterFilter(int limit) {
            super();
            if (limit <= 0) throw new IllegalArgumentException();
            this.limit = limit;
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

            int currentLength = fb.getDocument().getLength();
            int overLimit = currentLength + text.length() - limit - length;

            if (overLimit > 0)
                text = text.substring(0, text.length() - overLimit);
            super.replace(fb, offset, length, text, attrs);
        }


    }


}
