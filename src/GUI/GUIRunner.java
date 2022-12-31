package GUI;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class GUIRunner {
    public static void main(){
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.put("Button.focus", new ColorUIResource(new Color(0,0,0,0)));
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            }
            new Home();
        });
    }
}
