package JCodeArea;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

class CodeAreaScrollBarUI extends BasicScrollBarUI
{
    private Theme theme;

    CodeAreaScrollBarUI(Theme theme)
    {
        super();
        this.theme = theme;
    }

    void setTheme(Theme theme)
    {
        this.theme = theme;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds)
    {
        g.setColor(theme.getCodeAreaBackground());
        g.fillRect((int)trackBounds.getX(), (int)trackBounds.getY(), (int)trackBounds.getWidth(), (int)trackBounds.getHeight());
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
    {
        g.setColor(theme.getScrollBarColor());
        g.fillRoundRect((int)thumbBounds.getX(), (int)thumbBounds.getY(), (int)thumbBounds.getWidth(), (int)thumbBounds.getHeight(), 8, 8);
    }

    @Override
    protected JButton createDecreaseButton(int orientation)
    {
        JButton button = new JButton();
        Dimension dim = new Dimension(0,0);
        button.setPreferredSize(dim);
        button.setMinimumSize(dim);
        button.setMaximumSize(dim);
        return button;
    }

    @Override
    protected JButton createIncreaseButton(int orientation)
    {
        JButton button = new JButton();
        Dimension dim = new Dimension(0,0);
        button.setPreferredSize(dim);
        button.setMinimumSize(dim);
        button.setMaximumSize(dim);
        return button;
    }

}
