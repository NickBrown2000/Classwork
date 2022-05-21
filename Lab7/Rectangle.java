import java.awt.*;

public class Rectangle extends Shape {
  // Instance variables
  private int width;
  private int height;

  // Constructor
  public Rectangle(int x, int y, Color color,
                   int width, int height) {
    super(x, y, color);
    this.width = width;
    this.height = height;
  }

  // Instance methods
  public void draw(Graphics g) {
    g.setColor(getColor());
    g.fillRect(getX(), getY(), width, height);
  }
  
  public void scale(double factor){
  width=width*(int)factor;
  height=height*(int)factor;
  }
  
  public double area(){
    return(height*width);
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public String toString()
  {
    return super.toString() + "\nWidth: " + this.getWidth() + " Height: " + this.getHeight();
  }
}
