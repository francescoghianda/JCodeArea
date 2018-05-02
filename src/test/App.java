package test;

import JCodeArea.JCodeArea;
import JCodeArea.Theme;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame
{
    private JCodeArea codeArea;

    public App()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1280, 720));
        this.setLayout(null);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

        codeArea = new JCodeArea(Theme.DARK_THEME);
        codeArea.setLocation(100, 20);
        codeArea.setSize(new Dimension(1000, 600));
        codeArea.setPreferredSize(new Dimension(600, 400));

        this.add(codeArea, BorderLayout.NORTH);

        this.setVisible(true);
    }


    public static void main(String[] args)
    {
        new App();
    }
}
