import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Piece implements Nameable
{
    private String name;
    private Color textColor;
    private Color backColor;

    //add a default constructor
    public Piece()
    {
        this("X", Color.WHITE, Color.RED);
    }

    //add 3 more constructors
    public Piece(String str)
    {
        this(str, Color.WHITE, Color.RED);
    }

    public Piece(String str, Color text)
    {
        this(str, text, Color.RED);
    }

    public Piece(String str, Color text, Color back)
    {
        setName(str);
        setTextColor(text);
        setBackColor(back);
    }

    //set methods go here
    public void setName(String str)
    {
        name = str;
    }

    public void setTextColor(Color text)
    {
        textColor = text;
    }

    public void setBackColor(Color back)
    {
        backColor = back;
    }

    //get methods go here
    public String getName()
    {
        return name;
    }

    public String getText()
    {
        return name;
    }

    public Color getTextColor()
    {
        return textColor;
    }

    public Color getBackColor()
    {
        return backColor;
    }

    //this method returns the text that shows in each cell
    public String toString()
    {
        return getName() + " " + getBackColor() + " " + getTextColor();
    }
}
