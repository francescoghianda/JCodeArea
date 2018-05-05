package JCodeArea;

import java.awt.*;

public class Theme
{
    public static final Theme DARK_THEME = new Theme(
            new Color(43, 43, 43),
            new Color(180, 180, 180),
            new Color(49, 51, 53),
            new Color(96, 96, 96),
            new Color(85, 85, 85),
            new Color(170, 170, 170),
            new Color(185, 185, 185),
            new Font("Menlo", Font.PLAIN, 20), "Menlo");

    public static final Theme LIGHT_THEME = new Theme(
            new Color(255, 255, 255),
            new Color(0, 0, 0),
            new Color(240, 240, 240),
            new Color(153, 153, 153),
            new Color(208, 208, 208),
            new Color(173, 173, 173),
            new Color(10, 10, 10),
            new Font("Menlo", Font.PLAIN, 20), "Menlo");

    public static final Theme BLUE_THEME = new Theme(
            new Color(40, 44, 52),
            new Color(136, 146, 162),
            new Color(35, 39, 47),
            new Color(119, 125, 136),
            new Color(86, 138, 242),
            new Color(60, 66, 78),
            new Color(86, 138, 242),
            new Font("Menlo", Font.PLAIN, 20), "Menlo");


    private Color codeAreaBackground;  //codeAreaBackground
    private Color codeAreaForeground;  //codeAreaForeground
    private Color lineNumberAreaBackground; //lineNumberAreaBackground
    private Color lineNumberAreaForeground; //lineNumberAreaForeground
    private Color lineNumberAreaSeparator; //lineNumberAreaSeparator
    private Color scrollBarColor;
    private Color caretColor;

    private Font codeAreaFont;
    private Font lineNumberAreaFont;

    public Theme(Color codeAreaBackground,
                 Color codeAreaForeground,
                 Color lineNumberAreaBackground,
                 Color lineNumberAreaForeground,
                 Color lineNumberAreaSeparator,
                 Color scrollBarColor,
                 Color caretColor,
                 Font codeAreaFont, String lineNumberAreaFont)
    {
        this.codeAreaBackground = codeAreaBackground;
        this.codeAreaForeground = codeAreaForeground;
        this.lineNumberAreaBackground = lineNumberAreaBackground;
        this.lineNumberAreaForeground = lineNumberAreaForeground;
        this.lineNumberAreaSeparator = lineNumberAreaSeparator;
        this.scrollBarColor = scrollBarColor;
        this.caretColor = caretColor;

        this.codeAreaFont = codeAreaFont;
        this.lineNumberAreaFont = new Font(lineNumberAreaFont, Font.PLAIN, codeAreaFont.getSize());
    }

    public Color getCodeAreaBackground()
    {
        return codeAreaBackground;
    }

    @SuppressWarnings("unused")
    public void setCodeAreaBackground(Color codeAreaBackground)
    {
        this.codeAreaBackground = codeAreaBackground;
    }

    public Color getCodeAreaForeground()
    {
        return codeAreaForeground;
    }

    @SuppressWarnings("unused")
    public void setCodeAreaForeground(Color codeAreaForeground)
    {
        this.codeAreaForeground = codeAreaForeground;
    }

    public Color getLineNumberAreaBackground()
    {
        return lineNumberAreaBackground;
    }

    @SuppressWarnings("unused")
    public void setLineNumberAreaBackground(Color lineNumberAreaBackground)
    {
        this.lineNumberAreaBackground = lineNumberAreaBackground;
    }

    public Color getLineNumberAreaForeground()
    {
        return lineNumberAreaForeground;
    }

    @SuppressWarnings("unused")
    public void setLineNumberAreaForeground(Color lineNumberAreaForeground)
    {
        this.lineNumberAreaForeground = lineNumberAreaForeground;
    }

    public Color getLineNumberAreaSeparator()
    {
        return lineNumberAreaSeparator;
    }

    @SuppressWarnings("unused")
    public void setLineNumberAreaSeparator(Color lineNumberAreaSeparator)
    {
        this.lineNumberAreaSeparator = lineNumberAreaSeparator;
    }

    public Color getScrollBarColor()
    {
        return scrollBarColor;
    }

    @SuppressWarnings("unused")
    public void setScrollBarColor(Color scrollBarColor)
    {
        this.scrollBarColor = scrollBarColor;
    }

    public Color getCaretColor()
    {
        return caretColor;
    }

    @SuppressWarnings("unused")
    public void setCaretColor(Color caretColor)
    {
        this.caretColor = caretColor;
    }

    public Font getCodeAreaFont()
    {
        return codeAreaFont;
    }

    @SuppressWarnings("unused")
    public void setCodeAreaFont(Font codeAreaFont)
    {
        this.codeAreaFont = codeAreaFont;
    }

    public Font getLineNumberAreaFont()
    {
        return lineNumberAreaFont;
    }

    @SuppressWarnings("unused")
    public void setLineNumberAreaFont(String lineNumberAreaFont)
    {
        this.lineNumberAreaFont = new Font(lineNumberAreaFont, Font.PLAIN, codeAreaFont.getSize());
    }
}
