package JCodeArea;

import javax.swing.*;
import java.awt.*;

public class LineNumberArea extends JTextArea
{
    private int spacing;
    private Theme theme;
    private JCodeArea codeArea;

    protected LineNumberArea(JCodeArea codeArea, Theme theme, int spacing)
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
        g2d.setColor(theme.getCaBackground());
        g2d.setStroke(new BasicStroke(spacing));
        g2d.drawLine(getWidth() - spacing/2, getY(), getWidth()-spacing/2, getHeight());
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(theme.getLnaSeparatorColor());
        g2d.drawLine(getWidth() - spacing, getY(), getWidth() - spacing, getHeight());

        codeArea.numScrollPane.getVerticalScrollBar().setValue(codeArea.codeScrollPane.getVerticalScrollBar().getValue());

        repaint();
    }

    public int getSpacing()
    {
        return this.spacing;
    }

    public void setSpacing(int spacing)
    {
        this.spacing = spacing;
    }

}
