
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Rook extends Piece {

	public Rook(boolean isBlack)
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

		g.fillRect(positionX+(int)(squareWidth*3.0/10.0), 
				positionY+(int)(squareWidth/10.0),
				(int)(squareWidth*1.0/10.0), (int)(squareWidth*2.0/10.0));
		g.fillRect(positionX+(int)(squareWidth*9.0/20.0), 
				positionY+(int)(squareWidth/10.0),
				(int)(squareWidth*1.0/10.0), (int)(squareWidth*2.0/10.0));
		g.fillRect(positionX+(int)(squareWidth*12.0/20.0), 
				positionY+(int)(squareWidth/10.0),
				(int)(squareWidth*1.0/10.0), (int)(squareWidth*2.0/10.0));
		g.fillOval(positionX+squareWidth/4, 
				positionY+(int)(squareWidth*5.0/20.0), 
				(int)(squareWidth*5.0/10.0), (int)(squareWidth*2.0/10.0));
		g.fillRect(positionX+(int)(squareWidth*7.0/20.0), 
				positionY+(int)(squareWidth*4.0/10.0), 
				(int)(squareWidth*7.0/20.0),(int)(squareWidth*4.0/10.0));
		g.fillOval(positionX+(int)(squareWidth*8.0/40.0), 
				positionY+(int)(squareWidth*7.0/10.0), 
				(int)(squareWidth*6.0/10.0), (int)(squareWidth*2.0/10.0));

	}

	@Override
	public boolean canMove(int x, int y) {
		// TODO Auto-generated method stub
		return (y != 0 && x == 0||x!=0 && y==0);
	}

	@Override
	public boolean canCapture(int x, int y) {
		// TODO Auto-generated method stub
		return (y != 0 && x == 0||x!=0 && y==0);
	}

	@Override
	public boolean isBlocked(int x1, int y1, int x2, int y2, Piece[][] pieces) {
		// TODO Auto-generated method stub
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
	}
}


