package JCodeArea;

import javax.swing.*;
import java.awt.*;

class LineNumberArea extends JTextArea
{
    private int spacing;
    private Theme theme;
    private JCodeArea codeArea;

    LineNumberArea(JCodeArea codeArea, Theme theme, int spacing)
    {
        super(" 1");
        this.setEnabled(false);
        this.spacing = spacing;
        this.theme = theme;
        this.codeArea = codeArea;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(theme.getCodeAreaBackground());
        g2d.setStroke(new BasicStroke(spacing));
        g2d.drawLine(getWidth() - spacing/2, getY(), getWidth()-spacing/2, getHeight());
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(theme.getLineNumberAreaSeparator());
        g2d.drawLine(getWidth() - spacing, getY(), getWidth() - spacing, getHeight());

        codeArea.getNumScrollPane().getVerticalScrollBar().setValue(codeArea.getCodeScrollPane().getVerticalScrollBar().getValue());

        repaint();
    }

    void setTheme(Theme theme)
    {
        this.theme = theme;
        setFont(theme.getLineNumberAreaFont());
        setBackground(theme.getLineNumberAreaBackground());
        setForeground(theme.getLineNumberAreaForeground());
    }

    @SuppressWarnings("unused")
    int getSpacing()
    {
        return this.spacing;
    }

    @SuppressWarnings("unused")
    void setSpacing(int spacing)
    {
        this.spacing = spacing;
    }

}
