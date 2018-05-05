package JCodeArea;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import java.awt.*;

class CodeAreaCaret extends DefaultCaret
{
    private int width;

    CodeAreaCaret(int width)
    {
        super();
        this.width = width;
        setBlinkRate(450);
    }

    @Override
    public void paint(Graphics g)
    {
        if(getComponent() == null || !isVisible())return;

        g.setColor(getComponent().getCaretColor());
        Rectangle rect = null;
        try
        {
            rect = (Rectangle) getComponent().modelToView2D(getDot());
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
        }
        g.fillRect(rect.x, rect.y, this.width, rect.height);
    }


}
