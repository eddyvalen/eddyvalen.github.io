/*----------------------------------------------------------------------------
 * Author:                Eduardo Valenzuela
 * 
 * This class creates the red pill for the Orb game. It creates the initial
 * pill, and the subsequent pills. It also checks to see if the red pill is
 * touching the green pill and it allows the pills to move across the game
 * board.
 --------------------------------------------------------------------------*/
import java.util.Random;
    public class Pill
    {
        double xPos,            //: X coordinate of its location
               yPos,            //: Y coordinate of its location
               xVelocity,       //: How much it moves in the x direction
               yVelocity,       //: How much it moves in the y direction
               rad;             //: Radius of the pill
        
        Random random;
    /*---------------------------------------------------------------------
     |  Constructor: Pill
     |
     |  Purpose:  To create a pill with a random location and random x and
     |            y velocities. 
     *-------------------------------------------------------------------*/
           
        public Pill ()
        {
            random = new Random(); 
            xPos = random.nextDouble();
            yPos = random.nextDouble();
            xVelocity = random.nextDouble()*0.02 - 0.01;
            yVelocity = random.nextDouble()*0.02 - 0.01;
            rad = 0.05;
        }
        
    /*--------------------------------------------------------------------------
     |  Constructor: Pill
     |
     |  Purpose:  To create the initial pill with a starting location specifically
     |            at the center of the board. 
     |
     |  Parameters:  x -- specific x location
     |               y -- specific y location
     *-------------------------------------------------------------------------*/
    
        public Pill (double x, double y)
        {
            random = new Random(); 
            xPos = x;
            yPos = y;
            xVelocity = random.nextDouble()*0.02 - 0.01;
            yVelocity = random.nextDouble()*0.02 - 0.01;
            rad = 0.05;   
            
        }
    /*---------------------------------------------------------------------
     |  Method: getX 
     |
     |  Purpose: To get the x coordinate of the pill 
     |               
     |  Returns: x-coordinate of the pill
     *-------------------------------------------------------------------*/
     
        public double getX ()
        {
            return xPos;
        }
        
    /*---------------------------------------------------------------------
     |  Method : getY
     |
     |  Purpose: To get the y coordinate of the pill
     |           
     |  Returns: y-coordinate of the pill
     *-------------------------------------------------------------------*/
    
        public double getY ()
        {
            return yPos;
        }
        
    /*---------------------------------------------------------------------
     |  Method: move
     |
     |  Purpose: advances the position of hte pill by the x velocity in the
     |           x direction and the y velocity in the y direction.          
     *-------------------------------------------------------------------*/
        
        public void move ()
        {
            if (xPos + xVelocity > .95 || xPos + xVelocity < .05)
            {
                xVelocity = xVelocity * -1;
            }
            if (yPos + yVelocity > .95 || yPos + yVelocity < .05)
            {
                yVelocity = yVelocity * -1;
            }
            
            
            
            
            xPos = xPos + xVelocity;
            yPos = yPos + yVelocity;
            
        }
        
     /*---------------------------------------------------------------------
     |  Method : touching
     |
     |  Purpose: Checks to see if the pill is touching or overlapping the 
     |           player (green orb)
     |
     |  Parameters: x -- green orb's x coordinate
     |              y -- green orb's y coordinate
     |              radius --  radius of the green orb
     |
     |  Returns: true if the red pill is touching the green orb
     |           false if the red pill is not touching the green orb
     *-------------------------------------------------------------------*/
    
        public boolean touching (double x, double y, double radius)
        {
            if ((Math.sqrt(Math.pow(xPos - x,2))+ Math.pow(yPos - y,2)) <= rad)
            {
            return true;  
            }
          else
          {
              return false;
          }
    }
        
        
    }
