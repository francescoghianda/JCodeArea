package JCodeArea;

import java.awt.*;

public class Theme
{
    public static final Theme DARK_THEME = new Theme(new Color(43, 43, 43), new Color(180, 180, 180), new Color(49, 51, 53), new Color(96, 96, 96), new Color(85, 85, 85), new Font("Menlo", Font.PLAIN, 20), "Menlo");

    private Color caBackground;  //codeAreaBackground
    private Color caForeground;  //codeAreaForeground
    private Color lnaBackground; //lineNumberAreaBackground
    private Color lnaForeground; //lineNumberAreaForeground
    private Color lnaSeparatorColor; //lineNumberAreaSeparator

    private Font caFont;
    private Font lnaFont;

    public Theme(Color caBackground, Color caForeground, Color lnaBackground, Color lnaForeground, Color lnaSeparatorColor, Font caFont, String lnaFont)
    {
        this.caBackground = caBackground;
        this.caForeground = caForeground;
        this.lnaBackground = lnaBackground;
        this.lnaForeground = lnaForeground;
        this.lnaSeparatorColor = lnaSeparatorColor;

        this.caFont = caFont;
        this.lnaFont = new Font(lnaFont, Font.PLAIN, caFont.getSize());
    }

    public Color getCaBackground()
    {
        return caBackground;
    }

    public void setCaBackground(Color caBackground)
    {
        this.caBackground = caBackground;
    }

    public Color getCaForeground()
    {
        return caForeground;
    }

    public void setCaForeground(Color caForeground)
    {
        this.caForeground = caForeground;
    }

    public Color getLnaBackground()
    {
        return lnaBackground;
    }

    public void setLnaBackground(Color lnaBackground)
    {
        this.lnaBackground = lnaBackground;
    }

    public Color getLnaForeground()
    {
        return lnaForeground;
    }

    public void setLnaForeground(Color lnaForeground)
    {
        this.lnaForeground = lnaForeground;
    }

    public Color getLnaSeparatorColor()
    {
        return lnaSeparatorColor;
    }

    public void setLnaSeparatorColor(Color lnaSeparatorColor)
    {
        this.lnaSeparatorColor = lnaSeparatorColor;
    }

    public Font getCaFont()
    {
        return caFont;
    }

    public void setCaFont(Font caFont)
    {
        this.caFont = caFont;
    }

    public Font getLnaFont()
    {
        return lnaFont;
    }

    public void setLnaFont(String lnaFont)
    {
        this.lnaFont = new Font(lnaFont, Font.PLAIN, caFont.getSize());
    }
}
