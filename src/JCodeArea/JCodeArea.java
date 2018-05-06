package JCodeArea;

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

    private char deletedChar;
    private int tabs;

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
    }

    public void enableAutoBrackets(boolean autoBrackets)
    {
        this.autoBrackets = autoBrackets;
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

    private boolean isOpenBracket(char ch)
    {
        return (ch == '(' || ch == '[' || ch == '{' || ch == '"' || ch == '\'');
    }

    private boolean isCloseBracket(char ch)
    {
        return (ch == ')' || ch == ']' || ch == '}' || ch == '"' || ch == '\'');
    }

    private String createBrackets(char ch)
    {
        String str = "";
        switch(ch)
        {
            case '(':
                str = "()";
                break;
            case '[':
                str = "[]";
                break;
            case '{':
                str = "{}";
                break;
            case '"':
                str = "\"\"";
                break;
            case '\'':
                str = "''";
                break;
        }
        return str;
    }



    @Override
    public void keyTyped(KeyEvent e)
    {
        updateNumbers();

        char ch = e.getKeyChar();
        String text = codeArea.getText();
        int pos = codeArea.getCaretPosition();

        if(ch == '\t')tabs++;

        /*if(ch == '\n' && tabs > 0)
        {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < tabs; i++)
            {
                str.append('\t');
            }
            codeArea.setText(text.substring(0, pos).concat(str.toString()).concat(text.substring(pos)));
        }*/

        if(autoBrackets)
        {
            if(isOpenBracket(ch))
            {
                codeArea.setText(text.substring(0, pos).concat(createBrackets(ch)).concat(text.substring(pos)));
                codeArea.setCaretPosition(pos+1); //in mezzo alle parentesi
                e.consume();
            }
            else if(ch == '\b' && pos != text.length() && isOpenBracket(deletedChar)) //BACK_SPACE cancella la parentesi chiusa se presente
            {
                String previousChar = text.substring(pos, pos+1);
                if(isCloseBracket(previousChar.charAt(0)))
                {
                    codeArea.setText(text.substring(0, pos).concat(text.substring(pos+1)));
                    codeArea.setCaretPosition(pos);
                    e.consume();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int pos = codeArea.getCaretPosition();
        if(e.getKeyChar() == '\b' && pos > 0)
        {
            deletedChar = codeArea.getText().substring(pos-1, pos).charAt(0);
            if(deletedChar == '\t')tabs--;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

}