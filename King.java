import java.awt.Color;
import java.awt.Graphics;

public class King extends Piece {

	public King(boolean isBlack)
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
		g.fillRect(positionX+(int)(squareWidth*9/20.0), 
				positionY+(int)(squareWidth*4.2/22), 7, 2);
		g.fillRect(positionX+(int)(squareWidth*9.8/20.0), 
				positionY+(int)(squareWidth*3/22), 3, 7);
		g.fillRect(positionX+(int)(squareWidth*2.8/10.0), 
				positionY+(int)(squareWidth*3.0/10),
				squareWidth*5/10, squareWidth/7);
		g.fillRect(positionX+(int)(squareWidth*3.5/10.0), 
				positionY+(int)(squareWidth*4.0/10), 
				(int)(squareWidth*3.6/10.0),(int)(squareWidth*5.5/10.0));
		g.fillRect(positionX+(int)(squareWidth*4.1/20.0), 
				positionY+(int)(squareWidth*8/10.0), 
				(int)(squareWidth*6.3/10), squareWidth/7);
	}

	@Override
	public boolean canMove(int x, int y) {
		// TODO Auto-generated method stub
		return x*x+y*y==1||x*x+y*y==2;
	}

	@Override
	public boolean canCapture(int x, int y) {
		// TODO Auto-generated method stub
		return Math.abs(x)==1&&Math.abs(y)==1||Math.abs(x)==1&&Math.abs(y)==0||Math.abs(y)==1&&Math.abs(x)==0;
	}

	@Override
	public boolean isBlocked(int x1, int y1, int x2, int y2, Piece[][] pieces) {
		// TODO Auto-generated method stub
		return false;
	}
}



