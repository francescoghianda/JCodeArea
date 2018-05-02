package JCodeArea;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CodeAreaScrollBarUI extends BasicScrollBarUI
{
    private Theme theme;

    public CodeAreaScrollBarUI(Theme theme)
    {
        super();
        this.theme = theme;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds)
    {
        g.setColor(theme.getCaBackground());
        g.fillRect((int)trackBounds.getX(), (int)trackBounds.getY(), (int)trackBounds.getWidth(), (int)trackBounds.getHeight());
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
    {
        g.setColor(new Color(170, 170, 170));
        g.fillRoundRect((int)thumbBounds.getX(), (int)thumbBounds.getY(), (int)thumbBounds.getWidth(), (int)thumbBounds.getHeight(), 8, 8);
    }

    @Override
    protected JButton createDecreaseButton(int orientation)
    {
        JButton button = new JButton();
        Dimension zeroDim = new Dimension(0,0);
        button.setPreferredSize(zeroDim);
        button.setMinimumSize(zeroDim);
        button.setMaximumSize(zeroDim);
        return button;
    }

    @Override
    protected JButton createIncreaseButton(int orientation)
    {
        JButton button = new JButton();
        Dimension zeroDim = new Dimension(0,0);
        button.setPreferredSize(zeroDim);
        button.setMinimumSize(zeroDim);
        button.setMaximumSize(zeroDim);
        return button;
    }

}
