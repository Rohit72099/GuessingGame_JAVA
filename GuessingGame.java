package new_game;

//public class GuessingGame {
//
////	public static void main(String[] args) {
////		// TODO Auto-generated method stub
////
////	}
//
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGame {
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private Random rand;
    private int numberToGuess;
    private int numberOfTries;

    public GuessingGame() {
        rand = new Random();
        numberToGuess = rand.nextInt(100);
        numberOfTries = 0;

        frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess(Integer.parseInt(textField.getText()));
                textField.setText("");
            }
        });
        contentPane.add(textField, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        contentPane.add(textArea, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void checkGuess(int guess) {
        numberOfTries++;
        if (guess < numberToGuess) {
            textArea.append(guess + " is too low\n");
        } else if (guess > numberToGuess) {
            textArea.append(guess + " is too high\n");
        } else {
            textArea.append(guess + " is correct. You win! It took you " + numberOfTries + " tries.\n");
            numberToGuess = rand.nextInt(100);
            numberOfTries = 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuessingGame();
            }
        });
    }
}
