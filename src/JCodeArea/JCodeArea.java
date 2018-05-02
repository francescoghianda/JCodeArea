package JCodeArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCodeArea extends JPanel implements AdjustmentListener, KeyListener
{

    private JPanel numPane;
    protected JScrollPane codeScrollPane;
    protected JScrollPane numScrollPane;
    private LineNumberArea numArea;
    private CodeArea codeArea;

    private int lines;

    private int numberColumnWidth = 60;

    private Theme theme;

    public JCodeArea(Theme theme)
    {
        setBorder(null);
        setLayout(new BorderLayout());
        setBackground(Color.MAGENTA);

        numScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        numScrollPane.setBorder(null);

        codeScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        codeScrollPane.setBorder(null);
        codeScrollPane.setBackground(theme.getCaBackground());
        codeScrollPane.getVerticalScrollBar().addAdjustmentListener(this);
        codeScrollPane.getHorizontalScrollBar().setUI(new CodeAreaScrollBarUI(theme));
        codeScrollPane.getVerticalScrollBar().setUI(new CodeAreaScrollBarUI(theme));
        codeScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, getHeight()));
        codeScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(getWidth(), 10));

        codeArea = new CodeArea();
        codeArea.setBackground(Color.GRAY);
        codeArea.addKeyListener(this);
        codeScrollPane.setViewportView(codeArea);

        numArea = new LineNumberArea(this, theme, 5);

        numPane = new JPanel();
        numPane.setBorder(null);
        numPane.setLayout(new BorderLayout());
        numPane.setBackground(Color.GREEN);
        numScrollPane.setViewportView(numArea);
        numPane.add(numScrollPane, BorderLayout.CENTER);


        add(codeScrollPane, BorderLayout.CENTER);
        add(numPane, BorderLayout.WEST);

        setTheme(theme);

        lines = 1;
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
        codeArea.setFont(theme.getCaFont());
        codeArea.setBackground(theme.getCaBackground());
        codeArea.setForeground(theme.getCaForeground());
        codeArea.setCaretColor(theme.getCaForeground());
        numArea.setFont(theme.getLnaFont());
        numArea.setBackground(theme.getLnaBackground());
        numArea.setForeground(theme.getLnaForeground());
    }


    public Theme getTheme()
    {
        return this.theme;
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

    @Override
    public void keyTyped(KeyEvent e)
    {
        int l;
        String str = "";
        if((l = codeArea.getLineCount()) != lines)
        {
            lines = l;
            for(int i = 0; i < l; i++)
            {
                str += " "+String.valueOf(i+1)+"\n";
            }
            numArea.setText(str);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

}