package JCodeArea;

import javax.swing.text.DefaultCaret;
import java.awt.*;

class CodeAreaCaret extends DefaultCaret
{
    private int width;
    private Color color;

    CodeAreaCaret(int width)
    {
        super();
        this.width = width;
        setBlinkRate(450);
    }

    void setColor(Color color)
    {
        this.color = color;
    }

    @Override
    public void paint(Graphics g)
    {
        if(isVisible())
        {
            g.setColor(color);
            g.fillRect((int)getCenterX()-this.width/2, (int)getY(), this.width, (int)getHeight());
        }
        repaint();
    }


}
