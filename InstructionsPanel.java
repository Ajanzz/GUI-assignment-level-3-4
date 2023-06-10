import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class InstructionsPanel extends JPanel {
    private ButtonClickListener buttonClickListener;

    public InstructionsPanel() {
        setLayout(new BorderLayout());

        JTextArea instructionsText = new JTextArea();
        instructionsText.setText("Instructions:\n\nGuess a number between 1 and 100.\nClick the Check button to check your guess.\nThe game will provide feedback if your guess is too high or too low.");

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClicked(ButtonType.BACK);
                }
            }
        });

        add(instructionsText, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }
}
