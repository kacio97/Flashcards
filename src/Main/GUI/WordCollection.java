package Main.GUI;

import javax.swing.*;
import javax.swing.event.ListDataListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static Main.GUI.MainFrame.HEIGHT;
import static Main.GUI.MainFrame.WIDTH;

public class WordCollection extends JFrame {
    private JList englishWords;
    private JList polishWords;
    private JButton backToMenuButton;
    private JPanel wordCollectionPanel;
    private JButton show;
    private JButton deleteWord;

    private List<String> polWords;
    private List<String> engWords;

    public WordCollection(List<String> polWords, List<String> engWords) {

        this.polWords = polWords;
        this.engWords = engWords;

        setUI();


        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polishWords.setVisible(true);
                englishWords.setVisible(true);
                setModels();
            }
        });

        deleteWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndexForPolish = polishWords.getSelectedIndex();
                int selectedIndexForEnglish = englishWords.getSelectedIndex();

                deleteWordFromList(selectedIndexForEnglish, selectedIndexForPolish);
                selectedIndexForEnglish = -1;
                selectedIndexForPolish = -1;
            }
        });
    }


    public void setUI() {

        setSize(WIDTH, HEIGHT);
        setContentPane(wordCollectionPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void setModels() {
        DefaultListModel model = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
//        String tmp = "s";
//
//        for(int i = 0; i < polWords.size(); i++){
//            tmp = polWords.get(i);
//            model.addElement(tmp);
//        }
        model.addAll(polWords);
        model2.addAll(engWords);
        polishWords.setModel(model);
        englishWords.setModel(model2);
    }

    public void setCloseActionListener(ActionListener closeActionListener) {
        backToMenuButton.addActionListener(closeActionListener);
    }

    public void deleteWordFromList(int indexForEnglishWord, int indexForPolishWord) {
        DefaultListModel model = (DefaultListModel) englishWords.getModel();
        DefaultListModel model2 = (DefaultListModel) polishWords.getModel();

        if ((indexForEnglishWord != -1 || indexForPolishWord != -1) && indexForEnglishWord == indexForPolishWord) {
            model.removeElementAt(indexForEnglishWord);
            model2.removeElementAt(indexForEnglishWord);
            polWords.remove(indexForPolishWord);
            engWords.remove(indexForEnglishWord);

        } else {
            JOptionPane.showMessageDialog(wordCollectionPanel,
                    "Select the same words in both tables !",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
