import java.awt.Color;
import java.awt.Graphics;

public class Queen extends Piece {

	public Queen(boolean isBlack)
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
		g.fillOval(positionX+(int)(squareWidth*9.2/20.0), 
				positionY+(int)(squareWidth*1.6/25),6, 6);
		g.fillOval(positionX+(int)(squareWidth*7.2/20.0), 
				positionY+(int)(squareWidth*2/15),15, 15);
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
		return (y != 0 && x == 0||x!=0 && y==0)|| (Math.abs(y) == Math.abs(x) && x!=0);

	}

	@Override
	public boolean canCapture(int x, int y) {
		// TODO Auto-generated method stub
		return (y != 0 && x == 0||x!=0 && y==0)|| (Math.abs(y) == Math.abs(x) && x!=0);
	}

	@Override
	public boolean isBlocked(int x1, int y1, int x2, int y2, Piece[][] pieces) {
		// TODO Auto-generated method stub
		if(x2-x1==0 || y2-y1==0){
			int dirX= Math.abs(x2-x1);
			int dirY= Math.abs(y2-y1); 
			if(dirX>dirY){
				dirX = x2>x1 ? 1 : -1;
				for (int i=1;i<Math.abs(x2-x1);i++) {
					if (pieces[x1+i*dirX][y1]!=null) {
						return true;
					}
				}
			}else{
				dirY=y2>y1 ? 1 : -1;
				for (int i=1;i<Math.abs(y2-y1);i++) {
					if (pieces[x1][y1+i*dirY]!=null) {
						return true;
					}
				}
			}
			return false;
		}else{
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
}
