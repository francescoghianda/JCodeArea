package JCodeArea;

import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCodeArea extends JPanel implements AdjustmentListener, KeyListener
{

    private JPanel numPane;
    private JScrollPane codeScrollPane;
    private JScrollPane numScrollPane;
    private LineNumberArea numArea;
    private CodeArea codeArea;

    private int lines;

    private int numberColumnWidth = 60;

    private Theme theme;

    private CodeAreaScrollBarUI verticalScrollBarUI;
    private CodeAreaScrollBarUI horizontalScrollBarUI;

    private boolean autoBrackets;

    public JCodeArea(Theme theme)
    {
        setBorder(null);
        setLayout(new BorderLayout());
        //setBackground(Color.MAGENTA);

        verticalScrollBarUI = new CodeAreaScrollBarUI(theme);
        horizontalScrollBarUI = new CodeAreaScrollBarUI(theme);

        numScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        numScrollPane.setBorder(null);

        codeScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        codeScrollPane.setBorder(null);
        codeScrollPane.setBackground(theme.getCodeAreaBackground());
        codeScrollPane.getVerticalScrollBar().addAdjustmentListener(this);
        codeScrollPane.getHorizontalScrollBar().setUI(horizontalScrollBarUI);
        codeScrollPane.getVerticalScrollBar().setUI(verticalScrollBarUI);
        codeScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, getHeight()));
        codeScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(getWidth(), 10));

        codeArea = new CodeArea();
        //codeArea.setBackground(Color.GRAY);
        codeArea.addKeyListener(this);
        codeScrollPane.setViewportView(codeArea);

        numArea = new LineNumberArea(this, theme, 5);

        numPane = new JPanel();
        numPane.setBorder(null);
        numPane.setLayout(new BorderLayout());
        //numPane.setBackground(Color.GREEN);
        numScrollPane.setViewportView(numArea);
        numPane.add(numScrollPane, BorderLayout.CENTER);

        add(codeScrollPane, BorderLayout.CENTER);
        add(numPane, BorderLayout.WEST);

        setTheme(theme);

        lines = 1;

        autoBrackets = true;
    }

    @Override
    public void setSize(int width, int height)
    {
        super.setSize(width, height);
        codeScrollPane.setPreferredSize(new Dimension(width-numberColumnWidth, height));
        numPane.setPreferredSize(new Dimension(numberColumnWidth, height));
    }

    @Override
    public void setSize(Dimension size)
    {
        super.setSize(size);
        codeScrollPane.setPreferredSize(new Dimension((int)(size.getWidth()-numberColumnWidth), (int)size.getHeight()));
        numPane.setPreferredSize(new Dimension(numberColumnWidth, (int)size.getHeight()));
    }


    public void setTheme(Theme theme)
    {
        this.theme = theme;
        verticalScrollBarUI.setTheme(theme);
        horizontalScrollBarUI.setTheme(theme);
        codeScrollPane.setBackground(theme.getCodeAreaBackground());
        codeArea.setTheme(theme);
        numArea.setTheme(theme);
    }


    public Theme getTheme()
    {
        return this.theme;
    }

    @SuppressWarnings("unused")
    public String getText()
    {
        return codeArea.getText();
    }

    @SuppressWarnings("unused")
    public void setText(String text)
    {
        codeArea.setText(text);
        updateNumbers();
    }

    private void updateNumbers()
    {
        int l;
        StringBuilder str = new StringBuilder();
        if((l = codeArea.getLineCount()) != lines)
        {
            lines = l;
            for(int i = 0; i < l; i++)
            {
                str.append(" ").append(String.valueOf(i + 1)).append("\n");
            }
            numArea.setText(str.toString());
        }
    }

    JScrollPane getCodeScrollPane()
    {
        return this.codeScrollPane;
    }

    JScrollPane getNumScrollPane()
    {
        return this.numScrollPane;
    }

    @Override
    public void addKeyListener(KeyListener kl)
    {
        //super.addKeyListener(kl);
        codeArea.addKeyListener(kl);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        numScrollPane.getVerticalScrollBar().setValue(codeScrollPane.getVerticalScrollBar().getValue());
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        updateNumbers();

        if(autoBrackets)
        {
            int pos = codeArea.getCaretPosition();
            char bracket = e.getKeyChar();
            String str = "";
            boolean isBracket = false;

            switch(bracket)
            {
                case '(':
                    str = "()";
                    isBracket = true;
                    break;
                case '[':
                    str = "[]";
                    isBracket = true;
                    break;
                case '{':
                    str = "{}";
                    isBracket = true;
                    break;
                case '"':
                    str = "\"\"";
                    isBracket = true;
                    break;
                case '\'':
                    str = "''";
                    isBracket = true;
                    break;
            }

            if(isBracket)
            {
                codeArea.setText(codeArea.getText().substring(0, pos).concat(str).concat(codeArea.getText().substring(pos)));
                codeArea.setCaretPosition(pos+1); //in mezzo alle parentesi
                e.consume();
            }
            //TODO
            // AGGIUNGERE CANCELLAZIONE !!!

        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

}