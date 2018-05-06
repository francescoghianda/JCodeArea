package test;

import JCodeArea.JCodeArea;
import JCodeArea.Theme;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame
{
    private JCodeArea codeArea;

    private JButton darkBtn;
    private JButton lightBtn;
    private JButton blueBtn;

    App()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1280, 720));
        this.setLayout(null);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

        codeArea = new JCodeArea(Theme.LIGHT_THEME);
        codeArea.setLocation(100, 20);
        codeArea.setSize(new Dimension(1000, 600));
        codeArea.setPreferredSize(new Dimension(600, 400));
        codeArea.enableAutoBrackets(true);

        darkBtn = new JButton("dark");
        darkBtn.setSize(50, 20);
        darkBtn.setLocation(0, 0);
        darkBtn.addActionListener(e -> {
            codeArea.setTheme(Theme.DARK_THEME);
        });

        lightBtn = new JButton("light");
        lightBtn.setSize(50, 20);
        lightBtn.setLocation(0, 25);
        lightBtn.addActionListener(e -> {
            codeArea.setTheme(Theme.LIGHT_THEME);
        });

        blueBtn = new JButton("blue");
        blueBtn.setSize(50, 20);
        blueBtn.setLocation(0, 50);
        blueBtn.addActionListener(e -> {
            codeArea.setTheme(Theme.BLUE_THEME);
        });

        this.add(darkBtn);
        this.add(lightBtn);
        this.add(blueBtn);
        this.add(codeArea, BorderLayout.NORTH);

        this.setVisible(true);
    }


    public static void main(String[] args)
    {
        new App();
    }
}
