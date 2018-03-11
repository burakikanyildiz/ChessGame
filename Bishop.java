import java.awt.Color;
import java.awt.Graphics;

public class Bishop extends Piece{



	public Bishop(boolean isBlack)
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

		g.fillOval(positionX+(int)(squareWidth*7.7/20.0), 
				positionY+squareWidth/5, 
				squareWidth/4, squareWidth/4);
		g.fillOval(positionX+(int)(squareWidth*7/20.0), 
				positionY+(int)(squareWidth*4.0/10.0), 
				squareWidth/3, squareWidth/2);
		g.fillArc(positionX+(int)(squareWidth*1.0/5.0), 
				positionY+(int)(squareWidth*13.0/20.0), 
				squareWidth*6/10, (int)(squareWidth*5.0/10.0),0,180);

	}

	@Override
	public boolean canMove(int x, int y) {
		// TODO Auto-generated method stub
		return (Math.abs(y) == Math.abs(x) && x!=0);

	}



	@Override
	public boolean canCapture(int x, int y) {
		// TODO Auto-generated method stub
		return (Math.abs(y) == Math.abs(x) && x!=0);
	}

	@Override
	public boolean isBlocked(int x1, int y1, int x2, int y2, Piece[][] pieces) {
		// TODO Auto-generated method stub
		int dirX = x2>x1 ? 1 : -1;
		int dirY = y2>y1 ? 1 : -1;
		for (int i=1;i<Math.abs(x2-x1);i++) {
			if (pieces[x1+i*dirX][y1+i*dirY]!=null) {
				return true;
			}
		}
		return false;
	}
}




