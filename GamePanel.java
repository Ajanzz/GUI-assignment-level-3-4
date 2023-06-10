import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class GamePanel extends JPanel {
    private ButtonClickListener buttonClickListener;
    private int targetNumber;
    private JTextField guessField;
    private JLabel resultLabel;

    public GamePanel() {
        setLayout(new BorderLayout());

        targetNumber = (int) (Math.random() * 100) + 1;

        JPanel inputPanel = new JPanel();
        guessField = new JTextField(10);
        JButton checkButton = new JButton("Check");
        resultLabel = new JLabel();

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    if (guess < targetNumber) {
                        resultLabel.setText("Too low");
                    } else if (guess > targetNumber) {
                        resultLabel.setText("Too high");
                    } else {
                        resultLabel.setText("You got it!");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        inputPanel.add(guessField);
        inputPanel.add(checkButton);

        JButton backButton = new JButton("Back");
        JButton quitButton = new JButton("Quit");

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClicked(ButtonType.BACK);
                }
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClicked(ButtonType.QUIT);
                }
            }
        });

        add(inputPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.NORTH);
        add(backButton, BorderLayout.WEST);
        add(quitButton, BorderLayout.EAST);
    }

    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }
}
