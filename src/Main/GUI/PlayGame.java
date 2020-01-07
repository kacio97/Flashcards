package Main.GUI;

import com.sun.source.tree.LabeledStatementTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayGame extends JFrame {
    private JPanel playGamePanel;
    private JButton backToMenu;
    private JTextField textField1;
    private JButton checkButton;
    private JButton reverseButton;
    private JButton randomButton;
    private JLabel currentLanguage;
    private JLabel scoreLabel;
    private JProgressBar progressBar1;
    private JLabel wordLabel;
    private JLabel currentLanguageWrite;
    private JButton resetGameButton;

    private List<String> polWords;
    private List<String> engWords;

    private List<String> polWordsTmp;
    private List<String> engWordsTmp;


    public PlayGame(List<String> polWords, List<String> engWords) {

        //TODO Jak ustawić dane z parametrów dla zmiennych pomocniczych
        this.polWords = polWords;
        this.engWords = engWords;

        setUI();

        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentLanguage.getText() == "English") {
                    currentLanguage.setText("Polish");
                    wordLabel.setText("Słowo");
                    currentLanguageWrite.setText("English");
                } else {
                    currentLanguage.setText("English");
                    wordLabel.setText("Word");
                    currentLanguageWrite.setText("Polish");
                }
            }
        });

        //TODO Jak robić losowanie nie niszcząc oryginalnych danych Kolekcje pomocnicze ?
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectItemFromList();
            }
        });

        //TODO patrz metodę resetData()
        resetGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetData();
            }
        });
    }

    public void setUI() {
        setSize(MainFrame.WIDTH, MainFrame.HEIGHT);
        setContentPane(playGamePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
    }

    public void setCloseActionListener(ActionListener closeActionListenerPlayGame) {
        backToMenu.addActionListener(closeActionListenerPlayGame);
    }

    //TODO Losowanie słów które się nie powtarzają dla danego języka
    public void selectItemFromList() {
        Random random = new Random();
        int index = random.nextInt(polWords.size());

        if (currentLanguage.getText() == "English") {
            wordLabel.setText(engWords.get(index));
            engWords.remove(index);
            polWords.remove(index);
        } else {
            wordLabel.setText(polWords.get(index));
            engWords.remove(index);
            polWords.remove(index);
        }
    }

    //Todo Przywracanie danych z tablicy (reset gry)
    public void resetData() {

    }
}
