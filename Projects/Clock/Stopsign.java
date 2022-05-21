// Displays a stop signimport java.awt.*;
public class StopSign {  public static void main(String[] args) {    
// Create drawable frame    
DrawableFrame df = new DrawableFrame("Stop Sign");
    df.show();
        df.setSize(125, 125);
            // Obtain graphics context
                Graphics g = df.getGraphicsContext();
                    // Define coordinates of outer polygon (edge of sign) and    
                    // inner polygon (red portion)
                        int[] xOuter = {36, 87, 123, 123, 87, 36, 0, 0};
                        int[] yOuter = {0, 0, 36, 87, 123, 123, 87, 36};
                        int[] xInner = {37, 86, 118, 118, 86, 37, 5, 5};
                        int[] yInner = {5, 5, 37, 86, 118, 118, 86, 37};
                       // Draw edge of sign in black
                        g.setColor(Color.black);
                        g.drawPolygon(xOuter, yOuter, xOuter.length);
                       // Fill interior of sign with red
                       g.setColor(Color.red);
                       g.fillPolygon(xInner, yInner, xInner.length);
                       // Display "STOP" in white 
                       g.setColor(Color.white);
                       g.setFont(new Font("SansSerif", Font.BOLD, 36));
                       g.drawString("STOP", 13, 76);
                       // Repaint frame
                       df.repaint();  }
}