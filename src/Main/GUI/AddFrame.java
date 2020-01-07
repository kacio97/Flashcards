package Main.GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class AddFrame extends JFrame {

    private JPanel AddPanel;
    private JTextField textField2;
    private JButton dodajButton;
    private JTextField textField1;
    private JButton backToMenuButton;
    private JLabel plLab;
    private JLabel engLab;

    private List<String> polWords;
    private List<String> engWords;
    private String polWord;
    private String engWord;

    public AddFrame(List<String> polWords, List<String> engWords) throws HeadlessException {
        this.polWords = polWords;
        this.engWords = engWords;
        setUI();


        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        getWordFromTextField();

                        System.out.println(engWord + " " + polWord);

                        if (!polWord.equals("") && !engWord.equals(""))
                            addData(engWord, polWord);

                    }
                });
            }
        });

        //SPRAWDZANIE TEXT FIELD POD KATEM CZY JEST NULL (NIE DZIALA)
/*        textField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                getWordFromTextField1();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getWordFromTextField1();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getWordFromTextField1();
            }
        });

        textField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                getWordFromTextField2();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getWordFromTextField2();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getWordFromTextField2();
            }
        });*/

    }

    public void setUI() {
        setSize(MainFrame.WIDTH, MainFrame.HEIGHT);
        setContentPane(AddPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        plLab.setVisible(false);
        engLab.setVisible(false);
    }

    public void addData(String wordEng, String wordPol) {
        polWords.add(wordPol);
        engWords.add(wordEng);
        polWord = "";
        engWord = "";
    }

    public void setCloseActionListener(ActionListener closeActionListener) {
        backToMenuButton.addActionListener(closeActionListener);
    }

    public void getWordFromTextField() {
        if (textField1.getText().isEmpty()) {
            engLab.setVisible(true);
        } else {
            engLab.setVisible(false);
            engWord = textField1.getText();
            textField1.setText("");

        }

        if (textField2.getText().isEmpty()) {
            plLab.setVisible(true);
        } else {
            plLab.setVisible(false);
            polWord = textField2.getText();
            textField2.setText("");
        }
    }

}
