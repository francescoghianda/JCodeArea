package JCodeArea;

import javax.swing.*;
import java.awt.*;

class CodeArea extends JTextPane
{

    private Theme theme;
    private CodeAreaCaret caret;

    CodeArea()
    {
        super();
        caret = new CodeAreaCaret(2);
        setCaret(caret);
    }

    void setTheme(Theme theme)
    {
        this.theme = theme;
        setFont(theme.getCodeAreaFont());
        setBackground(theme.getCodeAreaBackground());
        setForeground(theme.getCodeAreaForeground());
        setCaretColor(theme.getCaretColor());
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    int getLineCount()
    {
        return getText().replaceAll("\n", "\n ").split("\n").length;
    }
}
