
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Katherine
 */


public class squareBrush { 
  
  static protected Label label = new Label("Drag the Rectangle");
 
    JFrame f = new JFrame();
    
    public squareBrush(){
    f.add("Center", new myCanvas());
    f.setSize(400, 500);   
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    }

   public static void main(String[]args){
     squareBrush mg = new squareBrush();
}
    class myCanvas extends Canvas implements MouseListener, MouseMotionListener{
      Rectangle rect = new Rectangle(20, 20, 21, 21);
       
      Graphics2D g2;
     
      int preX, preY;
      
      boolean isFirstTime = true;
      
      Rectangle area;
      
      boolean pressOut = false;
      
       public myCanvas() {
    setBackground(java.awt.Color.white);
    addMouseMotionListener(this);
    addMouseListener(this);
  }
 
  public void mousePressed(MouseEvent e){
    preX = rect.x - e.getX();
    preY = rect.y - e.getY();

   
      updateLocation(e);
    
 
  }
   
  public void mouseDragged(MouseEvent e){
  
    updateLocation(e);
  
  }

  public void mouseMoved(MouseEvent e) {
    
  }

  @Override
  public void mouseClicked(MouseEvent e) {
       
  }
  @Override
  public void mouseExited(MouseEvent e) {
       
  }
  @Override
  public void mouseEntered(MouseEvent e) {
  }   
@Override
 public void mouseReleased(MouseEvent e) {
           
        }
 
  public void updateLocation(MouseEvent e){
      rect.setLocation(preX + e.getX(), preY + e.getY());
  if(checkRect()){
  squareBrush.label.setText(rect.getX() + ","+ e.getY());
  }else{
      squareBrush.label.setText("drag inside the area.");
  }
  
  repaint();
  }

 
 public void paint(Graphics graphics){
  update(graphics);     
 } 
       
   public void update(Graphics graphics){
       Graphics2D g2 = (Graphics2D) graphics;
       Dimension dim = getSize();
       int w = (int) dim.getWidth();
       int h = (int) dim.getHeight();
  
       
       if(isFirstTime){
       area = new Rectangle(dim);
       rect.setLocation(w/2 - 50, h/2 - 25);
       isFirstTime = false;
       }
       
       //Clears the rectangle that was previously drawn.
       g2.setPaint(java.awt.Color.white);
       g2.fillRect(0, 0, WIDTH, HEIGHT);
       
       g2.setColor(java.awt.Color.black);
       g2.draw(rect);
       g2.setColor(java.awt.Color.black);
       g2.fill(rect);
 }
  boolean checkRect(){
 if (area == null) {
      return false;
    }

    if (area.contains(rect.x, rect.y, 100, 50)) {
      return true;
    }
    int new_x = rect.x;
    int new_y = rect.y;

    if ((rect.x + 100) > area.getWidth()) {
      new_x = (int) area.getWidth() - 99;
    }
    if (rect.x < 0) {
      new_x = -1;
    }
    if ((rect.y + 50) > area.getHeight()) {
      new_y = (int) area.getHeight() - 49;
    }
    if (rect.y < 0) {
      new_y = -1;
    }
    rect.setLocation(new_x, new_y);
    return false;
  }
    }
 
} 



 



