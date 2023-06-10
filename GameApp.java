import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameApp {
    private JFrame frame;
    private MainMenuPanel mainMenuPanel;
    private InstructionsPanel instructionsPanel;
    private GamePanel gamePanel;

    public GameApp() {
        frame = new JFrame("Game App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the window on the screen

        mainMenuPanel = new MainMenuPanel();
        instructionsPanel = new InstructionsPanel();
        gamePanel = new GamePanel();

        mainMenuPanel.setButtonClickListener(new ButtonClickListener() {
            @Override
            public void onButtonClicked(ButtonType buttonType) {
                if (buttonType == ButtonType.PLAY) {
                    frame.setContentPane(gamePanel);
                } else if (buttonType == ButtonType.INSTRUCTIONS) {
                    frame.setContentPane(instructionsPanel);
                } else if (buttonType == ButtonType.QUIT) {
                    System.exit(0);
                }
                frame.revalidate();
            }
        });

        instructionsPanel.setButtonClickListener(new ButtonClickListener() {
            @Override
            public void onButtonClicked(ButtonType buttonType) {
                if (buttonType == ButtonType.BACK) {
                    frame.setContentPane(mainMenuPanel);
                    frame.revalidate();
                }
            }
        });

        gamePanel.setButtonClickListener(new ButtonClickListener() {
            @Override
            public void onButtonClicked(ButtonType buttonType) {
                if (buttonType == ButtonType.BACK) {
                    frame.setContentPane(mainMenuPanel);
                    frame.revalidate();
                } else if (buttonType == ButtonType.QUIT) {
                    System.exit(0);
                }
            }
        });

        frame.setContentPane(mainMenuPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameApp();
            }
        });
    }
}

enum ButtonType {
    PLAY,
    INSTRUCTIONS,
    BACK,
    QUIT
}

interface ButtonClickListener {
    void onButtonClicked(ButtonType buttonType);
}
