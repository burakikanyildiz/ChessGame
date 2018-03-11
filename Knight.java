
import java.awt.Color;
import java.awt.Graphics;

public class Knight extends Piece{

	public Knight(boolean isBlack)
	{
		super(isBlack);
	}

	@Override
	public void drawYourself(Graphics g, int positionX, int positionY, int squareWidth) {
		// TODO Auto-generated method stub


		if(isBlack)
		{
			g.setColor(Color.black);
		}
		else
		{
			g.setColor(Color.white);
		}

		g.fillArc(positionX+(int)(squareWidth*1.7/5.0), 
				positionY+(int)(squareWidth*13.0/20.0), 
				squareWidth*6/10, (int)(squareWidth*5.0/10.0),0,180);
		g.fillRect(positionX+(int)(squareWidth*11.3/20.0), 
				positionY+(int)(squareWidth*3.5/10.0), 
				(int)(squareWidth*4.0/20.0),(int)(squareWidth*5.0/10.0));
		g.fillRect(positionX+(int)(squareWidth*4.4/10.0),
				positionY+(int)(squareWidth*2.0/10.0),
				(int)(squareWidth*3.4/10.0),
				(int)(squareWidth*3.0/20.0));
		g.fillArc(positionX+(int)(squareWidth*2.2/10.0),
				positionY+(int)(squareWidth*3.5/20.0),
				squareWidth*4/10,
				squareWidth*4/10, 250, 270);

	}

	@Override
	public boolean canMove(int x, int y) {
		// TODO Auto-generated method stub
		return x*x+y*y==5;
	}

	@Override
	public boolean canCapture(int x, int y) {
		// TODO Auto-generated method stub
		return x*x+y*y==5;
	}

	@Override
	public boolean isBlocked(int x1, int y1, int x2, int y2, Piece[][] pieces) {
		// TODO Auto-generated method stub
		return false;
	}


}



