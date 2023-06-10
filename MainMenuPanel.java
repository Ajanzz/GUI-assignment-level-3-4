import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class MainMenuPanel extends JPanel {
    private ButtonClickListener buttonClickListener;

    public MainMenuPanel() {
        setLayout(new GridLayout(3, 1));

        JButton playButton = new JButton("Play");
        JButton instructionsButton = new JButton("Instructions");
        JButton quitButton = new JButton("Quit");

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClicked(ButtonType.PLAY);
                }
            }
        });

        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClicked(ButtonType.INSTRUCTIONS);
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

        add(playButton);
        add(instructionsButton);
        add(quitButton);
    }

    public void setButtonClickListener(ButtonClickListener listener) {
        this.buttonClickListener = listener;
    }
}
