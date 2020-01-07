package Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;

    private JButton addWordButton;
    private JButton playButton;
    private JPanel MainPanel;
    private JButton wordLibrary;
    private List<String> polWords = new ArrayList<>();
    private List<String> engWords = new ArrayList<>();
    private AddFrame addFrame;
    private WordCollection wordCollection;
    private PlayGame playGame;


    public MainFrame() {
        setUI();


        addWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        setVisible(false);
                        addFrame.setVisible(true);
                    }
                });
            }
        });

        wordLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        setVisible(false);
                        wordCollection.setVisible(true);
                    }
                });
            }
        });


        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        setVisible(false);
                        playGame.setVisible(true);
                    }
                });
            }
        });
    }

    //    CHANGING FRAMES
    public void setUI() {

        setSize(WIDTH, HEIGHT);
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        addFrame = new AddFrame(polWords, engWords);
        wordCollection = new WordCollection(polWords, engWords);
        playGame = new PlayGame(polWords, engWords);

        ActionListener closeActionListenerAddFrame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.setVisible(false);
                setVisible(true);
            }
        };

        ActionListener closeActionListenerWordCollection = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordCollection.setVisible(false);
                setVisible(true);
            }
        };

        ActionListener closeActionListenerPlayGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame.setVisible(false);
                setVisible(true);
            }
        };

        addFrame.setCloseActionListener(closeActionListenerAddFrame);
        wordCollection.setCloseActionListener(closeActionListenerWordCollection);
        playGame.setCloseActionListener(closeActionListenerPlayGame);
    }
}
