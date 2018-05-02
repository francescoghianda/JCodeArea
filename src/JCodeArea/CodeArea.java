package JCodeArea;

import javax.swing.*;

public class CodeArea extends JTextPane
{

    public CodeArea()
    {
        super();
    }

    protected int getLineCount()
    {
        return getText().replaceAll("\n", "\n ").split("\n").length;
    }
}
