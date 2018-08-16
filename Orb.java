/*---------------------------------------------------------------------------
 * Author:                  Eduardo Valenzuela
 * 
 * This program is a game where the player (mouse) control's a green circle.
 * The object of the game is to touch the blue circle with the green circle
 * without touching any of the red pills. Each time the blue circle is touched
 * a red pill is added. 
 --------------------------------------------------------------------------*/
import java.util.Random;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
public class Orb
{
  public static void main (String [] args)
  {
      StdDraw.setCanvasSize(560,720);
        StdDraw.setXscale(-0.2,1.2);
        StdDraw.setYscale(-0.4,1.4); 
      
      final double RADIUS = 0.05;
      
      double blueOrbX = .5,
             blueOrbY = .89,
             greenOrbX = StdDraw.mouseX(),
             greenOrbY= StdDraw.mouseY();
      
       int score = 0;
      
      Random random = new Random ();
      
      Pill [] pills = new Pill [100];
      pills [0] = new Pill (0.5,0.5); 
      
      int pillNum = 1;   // how many pills in array curently
      
      
      openingScreen(StdDraw.getFont(),RADIUS);
      
      drawing(greenOrbX, greenOrbY, blueOrbX, blueOrbY, RADIUS, pills,score, pillNum, random);

  }
     
  
    /*---------------------------------------------------------------------
     |  Method : openingScreen
     |
     |  Purpose:  To create the starting screen with the instructions for 
     |           the game.
     |
     |  Parameters:  title -- the title's font
     |               radius -- the radius of the green circle
     *-------------------------------------------------------------------*/
    
  public static void openingScreen (Font title, double radius)
    {
        StdDraw.setFont(title);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(0.5,1.2,"Catch The Blue Orb");
        Font info = new Font ("Arial Black", Font.PLAIN, 24);
        StdDraw.setFont(info);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(-0.1,1.00,"The mouse controls the green");
        StdDraw.textLeft(-0.1,0.93,"circle.");
        StdDraw.textLeft(-0.1,0.78,"The goal:  Touch the blue orb,");
        StdDraw.textLeft(-0.1,0.71,"without touching any of the");
        StdDraw.textLeft(-0.1,0.64,"red pills.");
        StdDraw.textLeft(-0.1,0.49,"How many times can you touch");
        StdDraw.textLeft(-0.1,0.42,"the orb before you touch a pill?");
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(0.5,0.05,radius);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(0.5,-0.10,"Click Inside the Circle to Start!");

        while (true) {
            if (StdDraw.mousePressed()) break;
            try {TimeUnit.MILLISECONDS.sleep(10);}
            catch (InterruptedException e) {}
        }
    }
 
/*------------------------------------------------------------------------------
     |  Method : drawing
     |
     |  Purpose:  Run the game. Checks to see if pill is touching green orb.
     |            Checks to see if green orb is touching the bluw orb.
     |            Creates new pills when blue orb is touched. Prints out screen.
     |            
     |
     |  Parameters:   gOrbX -- x coordinate of the green orb
     |                gOrbY -- y coordinate of the green orb
     |                bOrbX -- x coordinate of the blue orb
     |                bOrbY -- y coordinate of the blue orb
     |                radius -- radius of the orbs
     |                pills --  array of pills
     |                score --  score of the game
     |                pillNum -- number of pills in the game/created
     |                random -- random number generator
     *--------------------------------------------------------------------------*/
public static void drawing (double gOrbX, double gOrbY, double bOrbX, double bOrbY, double radius, Pill [] pills, int score, int pillNum, Random random)
{
             
    
    while(true)
        {
            int i= 0;
            StdDraw.clear();
            gOrbX = StdDraw.mouseX();
            gOrbY= StdDraw.mouseY();
            if((Math.sqrt(Math.pow(gOrbX - bOrbX,2))+ Math.pow(gOrbY - bOrbY,2)) <= radius + radius)
            {
             score = score + 1;
             pills [score] = new Pill ();
             pillNum = pillNum + 1;

             bOrbX = random.nextDouble();
             bOrbY = random.nextDouble();
             StdDraw.filledCircle(bOrbX,bOrbY,radius);
            }
            for (i=0; i < pillNum; i++)
            {
                 if (pills[i].touching(gOrbX, gOrbY, radius))
                 {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(0.5,0.5,"Game Over");
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.square(0.5,0.5,0.5);
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.text(0.5,1.2,"Catch The Blue Orb");
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.text(0.5,-0.10,"Score: " + score);
                StdDraw.show(20);
                while(true)
                {
            }
            
                 }
            }
    
    
    StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.square(0.5,0.5,0.5);
           StdDraw.setPenColor(StdDraw.BLUE);
           StdDraw.text(0.5,1.2,"Catch The Blue Orb");
           StdDraw.setPenColor(StdDraw.GREEN);

            
            if(StdDraw.mouseX() < .05)
            {
             gOrbX  = .05;  
            }
            if(StdDraw.mouseY() < .05)
            {
              gOrbY = .05;  
            }
            if(StdDraw.mouseX() > .95)
            {
              gOrbX = .95;  
            }
            if(StdDraw.mouseY() > .95)
            {
              gOrbY = .95;  
            }
            
            if(bOrbX < .05)
            {
              bOrbX = .05;  
            }
            if(bOrbY < .05)
            {
              bOrbY = .05;  
            }
            if(bOrbX > .95)
            {
              bOrbX = .95;  
            }
            if(bOrbY > .95)
            {
              bOrbY = .95;  
            }
           StdDraw.filledCircle(gOrbX,gOrbY,radius);
           StdDraw.setPenColor(StdDraw.BLUE);
           StdDraw.filledCircle(bOrbX,bOrbY,radius);
           StdDraw.setPenColor(StdDraw.GREEN);
           StdDraw.text(0.5,-0.10,"Score: " + score);
           
           for (i=0; i < pillNum; i++)
            {
                pills[i].move();
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledCircle(pills[i].getX(), pills[i].getY(), radius);
            
            }
          
           StdDraw.show(20);
        }
}
}
