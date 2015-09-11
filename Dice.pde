Die bob;
void setup()
{
	size(500, 550);
	noLoop();
}
void draw()
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
	text ("The sum of all the dice is " + sum, 170, 520);
}
void mousePressed()
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

	void roll()
	{
		double dRandom = Math.random();
		if(dRandom < .166666)
		{
			dot = 1;
		}
		else if (dRandom < .333333)
		{
			dot = 2;
		}
		else if (dRandom < .5)
		{
			dot = 3;
		}
		else if (dRandom < .666666)
		{
			dot = 4;
		}
		else if (dRandom < .833333)
		{
			dot = 5;
		}
		else
		{
			dot = 6;
		}
	}

	void show()
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
