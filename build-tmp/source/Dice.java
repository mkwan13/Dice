import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die bob;
public void setup()
{
	size(500, 550);
	noLoop();
}
public void draw()
{
	int sum = 0;
	background(51);
	for(int y = 20; y < 480; y+=60)
	{
		for(int x = 20; x < 480; x+=60)
		{
			bob = new Die(x, y, 50, 50, 3);
			bob.roll();
			bob.show();
			sum = sum + bob.dot;
		}
	}
	text ("The sum of all the dice is " + sum, 180, 520);
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{	
	int myX, myY, myWidth, myHeight, curve;
	int dot; //variable declarations here
	Die(int x, int y, int w, int h, int c) //constructor
	{
		myX = x;
		myY = y;
		myWidth = w;
		myHeight = h;
		curve = c; //variable initializations here
	}

	public void roll()
	{
		double dRandom = Math.random();
		if(dRandom < .166666f)
		{
			dot = 1;
		}
		else if (dRandom < .333333f)
		{
			dot = 2;
		}
		else if (dRandom < .5f)
		{
			dot = 3;
		}
		else if (dRandom < .666666f)
		{
			dot = 4;
		}
		else if (dRandom < .833333f)
		{
			dot = 5;
		}
		else
		{
			dot = 6;
		}

	}

	public void show()
	{
		rect(myX, myY, myWidth, myHeight, curve);
		if(dot == 1)
		{
			// fill(0);			
			ellipse(myX+25, myY+25, 5, 5);
		}
		if(dot == 2)
		{
			// fill(0);
			ellipse (myX+15, myY+15, 5, 5);
			ellipse (myX+35, myY+35, 5, 5);
		}
		if(dot == 3)
		{
			ellipse(myX+25, myY+25, 5, 5);
			ellipse(myX+15, myY+15, 5, 5);
			ellipse(myX+35, myY+35, 5, 5);
		}
		if (dot == 4)
		{
			ellipse (myX+15, myY+15, 5, 5);
			ellipse (myX+35, myY+35, 5, 5);
			ellipse (myX+15, myY+35, 5, 5);
			ellipse (myX+35, myY+15, 5, 5);
		}
		if (dot == 5)
		{
			ellipse (myX+15, myY+15, 5, 5);
			ellipse (myX+35, myY+35, 5, 5);
			ellipse (myX+15, myY+35, 5, 5);
			ellipse (myX+35, myY+15, 5, 5);
			ellipse (myX+25, myY+25, 5, 5);
		}
		if (dot == 6)
		{
			ellipse (myX+15, myY+15, 5, 5);
			ellipse (myX+35, myY+35, 5, 5);
			ellipse (myX+15, myY+35, 5, 5);
			ellipse (myX+35, myY+15, 5, 5);
			ellipse (myX+15, myY+25, 5, 5);
			ellipse (myX+35, myY+25, 5, 5);
		}

					
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
