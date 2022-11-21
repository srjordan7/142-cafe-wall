import java.awt.*;

public class CafeWall{
   public static final int MORTAR = 2;

   public static void main(String[] args) {
      //create panel
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      //draw individual rows
      Row(g, 4, 40, 0, 20);
      Row(g, 5, 10, 70, 30);
      //draw grids
      Grid(g, 8, 4, 40, 150, 25, 0);
      Grid(g, 4, 2, -330, 20, 35, 35);
      Grid(g, 6, 3, -200, 200, 25, 10);
      Grid(g, 10, 5, -385, 180, 20, 10);
   }
   
   public static void Row(Graphics pen, int p, int x, int y, int s) {
      // p - # of pairs
      // x - difference between starting x coordinate & 2s
      // y - y coordinate
      // s - box size
      for (int i = 1; i <= p; i++) {
         //black box
         pen.setColor (Color.BLACK);
         pen.fillRect (2 * s * i - x, y, s, s);
         //blue x
         pen.setColor (Color.BLUE);
         pen.drawLine (2 * s * i - x, y, 2 * s * i - x + s, y + s);
         pen.drawLine (2 * s * i - x + s, y, 2 * s * i - x, y + s);
         //white box 
         pen.setColor (Color.WHITE);
         pen.fillRect (2 * s * i - x + s, y, s, s);
      }
   }
   
   public static void Grid(Graphics pen, int r, int p, int x, int y, int s, int o) {
      //r - # of rows
      //o - offset  
      for (int i = 1; i <= r / 2; i++) {
         Row(pen, p, x, y + (i - 1) * 2 * (s + MORTAR), s);
         Row(pen, p, x - o, y + s + MORTAR + (i - 1) * 2 * (s + MORTAR), s);
      }
   }
}