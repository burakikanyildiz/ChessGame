import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class ChessFrame extends JFrame implements MouseListener{

	Stack <Piece[][]> s=new Stack <Piece[][]>();
	/**
	 * width of one square on the board.
	 * Change this to have a bigger or smaller 
	 * game frame. 
	 */
	public static final int SQUARE_WIDTH = 45;

	/**
	 * margins of the board on the frame
	 */
	public static final int BOARD_MARGIN = 50;
	int round=1;
 static	int selectedSquareX = -1;
 static int selectedSquareY = -1;
	Piece pieces[][] = new Piece[8][8];

	public ChessFrame()
	{
		initializeChessBoard();
		setTitle("Chess Game");
		//let the screen size fit the board size
		setSize(SQUARE_WIDTH*8+BOARD_MARGIN*4, SQUARE_WIDTH*8+BOARD_MARGIN*5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawLabel();
		addMouseListener(this);
		setLayout(null);

	}
	public void drawLabel(){
		JLabel a1=new JLabel("a");
		a1.setFont(new Font("",Font.PLAIN,35));
		a1.setBounds(2*BOARD_MARGIN+(0)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(a1);
		JLabel b1=new JLabel("b");
		b1.setFont(new Font("",Font.PLAIN,35));
		b1.setBounds(2*BOARD_MARGIN+(1)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(b1);
		JLabel c1=new JLabel("c");
		c1.setFont(new Font("",Font.PLAIN,35));
		c1.setBounds(2*BOARD_MARGIN+(2)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(c1);
		JLabel d1=new JLabel("d");
		d1.setFont(new Font("",Font.PLAIN,35));
		d1.setBounds(2*BOARD_MARGIN+(3)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(d1);
		JLabel e1=new JLabel("e");
		e1.setFont(new Font("",Font.PLAIN,35));
		e1.setBounds(2*BOARD_MARGIN+(4)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(e1);
		JLabel f1=new JLabel("f");
		f1.setFont(new Font("",Font.PLAIN,35));
		f1.setBounds(2*BOARD_MARGIN+(5)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(f1);
		JLabel g1=new JLabel("g");
		g1.setFont(new Font("",Font.PLAIN,35));
		g1.setBounds(2*BOARD_MARGIN+(6)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(g1);
		JLabel h1=new JLabel("h");
		h1.setFont(new Font("",Font.PLAIN,35));
		h1.setBounds(2*BOARD_MARGIN+(7)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(0)*SQUARE_WIDTH-3, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(h1);
		JLabel a2=new JLabel("a");
		a2.setFont(new Font("",Font.PLAIN,35));
		a2.setBounds(2*BOARD_MARGIN+(0)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(a2);
		JLabel b2=new JLabel("b");
		b2.setFont(new Font("",Font.PLAIN,35));
		b2.setBounds(2*BOARD_MARGIN+(1)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(b2);
		JLabel c2=new JLabel("c");
		c2.setFont(new Font("",Font.PLAIN,35));
		c2.setBounds(2*BOARD_MARGIN+(2)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(c2);
		JLabel d2=new JLabel("d");
		d2.setFont(new Font("",Font.PLAIN,35));
		d2.setBounds(2*BOARD_MARGIN+(3)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(d2);
		JLabel e2=new JLabel("e");
		e2.setFont(new Font("",Font.PLAIN,35));
		e2.setBounds(2*BOARD_MARGIN+(4)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(e2);
		JLabel f2=new JLabel("f");
		f2.setFont(new Font("",Font.PLAIN,35));
		f2.setBounds(2*BOARD_MARGIN+(5)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(f2);
		JLabel g2=new JLabel("g");
		g2.setFont(new Font("",Font.PLAIN,35));
		g2.setBounds(2*BOARD_MARGIN+(6)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(g2);
		JLabel h2=new JLabel("h");
		h2.setFont(new Font("",Font.PLAIN,35));
		h2.setBounds(2*BOARD_MARGIN+(7)*SQUARE_WIDTH+2, 
				BOARD_MARGIN*0+(9)*SQUARE_WIDTH-7, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(h2);
		JLabel one1=new JLabel("1");
		one1.setFont(new Font("",Font.PLAIN,30));
		one1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(8)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(one1);
		JLabel two1=new JLabel("2");
		two1.setFont(new Font("",Font.PLAIN,30));
		two1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(7)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(two1);
		JLabel three1=new JLabel("3");
		three1.setFont(new Font("",Font.PLAIN,30));
		three1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(6)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(three1);
		JLabel four1=new JLabel("4");
		four1.setFont(new Font("",Font.PLAIN,30));
		four1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(5)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(four1);
		JLabel five1=new JLabel("5");
		five1.setFont(new Font("",Font.PLAIN,30));
		five1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(4)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(five1);
		JLabel six1=new JLabel("6");
		six1.setFont(new Font("",Font.PLAIN,30));
		six1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(3)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(six1);
		JLabel seven1=new JLabel("7");
		seven1.setFont(new Font("",Font.PLAIN,30));
		seven1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(2)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(seven1);
		JLabel eight1=new JLabel("8");
		eight1.setFont(new Font("",Font.PLAIN,30));
		eight1.setBounds(BOARD_MARGIN+(0)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(1)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(eight1);
		JLabel one2=new JLabel("1");
		one2.setFont(new Font("",Font.PLAIN,30));
		one2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(8)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(one2);
		JLabel two2=new JLabel("2");
		two2.setFont(new Font("",Font.PLAIN,30));
		two2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(7)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(two2);
		JLabel three2=new JLabel("3");
		three2.setFont(new Font("",Font.PLAIN,30));
		three2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(6)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(three2);
		JLabel four2=new JLabel("4");
		four2.setFont(new Font("",Font.PLAIN,30));
		four2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(5)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(four2);
		JLabel five2=new JLabel("5");
		five2.setFont(new Font("",Font.PLAIN,30));
		five2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(4)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(five2);
		JLabel six2=new JLabel("6");
		six2.setFont(new Font("",Font.PLAIN,30));
		six2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(3)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(six2);
		JLabel seven2=new JLabel("7");
		seven2.setFont(new Font("",Font.PLAIN,30));
		seven2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(2)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(seven2);
		JLabel eight2=new JLabel("8");
		eight2.setFont(new Font("",Font.PLAIN,30));
		eight2.setBounds(BOARD_MARGIN+(9)*SQUARE_WIDTH+10, 
				BOARD_MARGIN*0+(1)*SQUARE_WIDTH-2, SQUARE_WIDTH*4, SQUARE_WIDTH*4);
		add(eight2);
		JButton save=new JButton("Save");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				save("game.txt");
			}
		});
		save.setBounds(SQUARE_WIDTH+BOARD_MARGIN+80,BOARD_MARGIN-25,BOARD_MARGIN+25,BOARD_MARGIN/2);
		add(save);
		JButton undo=new JButton("Undo");
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				undo();
			}
		});
		undo.setBounds(SQUARE_WIDTH+BOARD_MARGIN+180,BOARD_MARGIN-25,BOARD_MARGIN+25,BOARD_MARGIN/2);
		add(undo);
	}
	public boolean move(String from, String to){
		from=from.toUpperCase();
		to=to.toUpperCase();
		int fromx=from.charAt(0)-'A';
		int fromy=7-(from.charAt(1)-'0'-1);
		selectedSquareX=fromx;
		selectedSquareY=fromy;
		int tox=to.charAt(0)-'A';
		int toy=7-(to.charAt(1)-'0'-1);	
		int targetSquareX = tox;
		int targetSquareY = toy;
		System.out.println(selectedSquareX+" ,"+selectedSquareY+"/"+targetSquareX+","+targetSquareY);
		if(selectedSquareX >= 0 && selectedSquareY >= 0 &&
				selectedSquareX < 8 && selectedSquareY < 8 &&
				targetSquareX >= 0 && targetSquareY >= 0 &&
				targetSquareX < 8 && targetSquareY < 8)
		{
			//if a piece is selected 
			if(pieces[selectedSquareX][selectedSquareY] != null)
			{
				if(round%2==0 && pieces[fromx][fromy].isBlack
						||round%2==1 && !pieces[fromx][fromy].isBlack ){
					selectedSquareX = fromx;
					selectedSquareY = fromy;
					System.out.println(selectedSquareX+","+selectedSquareY);	
				}	
				//get the distance of the drag-drop
				int diffX = targetSquareX - selectedSquareX;
				int diffY = targetSquareY - selectedSquareY;
				//if there is a piece in targeted square
				if(pieces[targetSquareX][targetSquareY] != null)
				{

					if(pieces[selectedSquareX][selectedSquareY].canCapture(diffX, diffY)&&
							pieces[selectedSquareX][selectedSquareY].isBlack!=pieces[targetSquareX][targetSquareY].isBlack&&
							!pieces[selectedSquareX][selectedSquareY].isBlocked(selectedSquareX, selectedSquareY, targetSquareX, targetSquareY, pieces))
					{
						System.out.println("can capture");
						push(pieces);
						pieces[selectedSquareX][selectedSquareY].numberOfMoves++;
						pieces[targetSquareX][targetSquareY] = 
								pieces[selectedSquareX][selectedSquareY];
						pieces[selectedSquareX][selectedSquareY] = null;
						if(isInCheck()){
							undo();
							round++;
							return false;
						}
						round++;
						repaint();
						promotion();
						isCheckmate();
						return true;
					}
				}
				else
				{
					//if targeted square is empty
					//System.out.println("no target");
					if(pieces[selectedSquareX][selectedSquareY].canMove(diffX, diffY)&&
							!pieces[selectedSquareX][selectedSquareY].isBlocked(selectedSquareX, selectedSquareY, targetSquareX, targetSquareY, pieces))
					{
						//System.out.println("can move");
						push(pieces);
						pieces[selectedSquareX][selectedSquareY].numberOfMoves++;
						pieces[targetSquareX][targetSquareY] = 
								pieces[selectedSquareX][selectedSquareY];
						pieces[selectedSquareX][selectedSquareY] = null;
						if(isInCheck()){
							undo();
							round++;
							return false;
						}
						round++;
						repaint();
						promotion();
						isCheckmate();
						return true;
					}
				}
			}
		}
		return false;
	}
	boolean promotion(){
		for(int i=0;i<8;i++){
			if(pieces[i][0]!=null&&pieces[i][0].getClass().getName().equals("Pawn")&&!pieces[i][0].isBlack){
				pieces[i][0]=new Queen(false);
				
				return true;
			}
			if(pieces[i][7]!=null&&pieces[i][7].getClass().getName().equals("Pawn")&&pieces[i][7].isBlack){
				pieces[i][7]=new Queen(true);
			}
		}
		return false;
	}
	public String at(String pos){
		pos=pos.toUpperCase();
		int posx=pos.charAt(0)-'A';
		int posy=7-(pos.charAt(1)-'0'-1);
		String s="";
		if(pieces[posx][posy]!=null){
			s=pieces[posx][posy].getColor()+"-"+pieces[posx][posy].getClass().getName();
		}
		return s;

	}
	public boolean castling(boolean isKingSide){
		if(round%2==0){
			if(isKingSide){
				if(pieces[4][0] instanceof King && pieces[7][0] instanceof Rook&&pieces[5][0]==null&& pieces[6][0]==null){
					push(pieces);
					pieces[4][0]=null;
					pieces[7][0]=null;
					pieces[6][0]=new King(true);
					pieces[5][0]=new Rook(true);
					if(isInCheck()){
						undo();
						round++;
						return false;
					}
					round++;
					repaint();
					isCheckmate();
					return true;
				}
			}else{
				if(pieces[4][0] instanceof King && pieces[0][0] instanceof Rook&&pieces[1][0]==null&& pieces[2][0]==null&&pieces[3][0]==null){
					push(pieces);
					pieces[4][0]=null;
					pieces[0][0]=null;
					pieces[2][0]=new King(true);
					pieces[3][0]=new Rook(true);
					if(isInCheck()){
						undo();
						round++;
						return false;
					}
					round++;
					repaint();
					isCheckmate();
					return true;
				}
			}
		}else{
			if(isKingSide){
				if(pieces[4][7] instanceof King && pieces[7][7] instanceof Rook&&pieces[5][7]==null&& pieces[6][7]==null){
					push(pieces);
					pieces[4][7]=null;
					pieces[7][7]=null;
					pieces[6][7]=new King(false);
					pieces[5][7]=new Rook(false);
					if(isInCheck()){
						undo();
						round++;
						return false;
					}
					round++;
					repaint();
					isCheckmate();
					return true;
				}
			}else{
				if(pieces[4][7] instanceof King && pieces[0][7] instanceof Rook&&pieces[1][7]==null&& pieces[2][7]==null&&pieces[3][7]==null){
					push(pieces);
					pieces[4][7]=null;
					pieces[0][7]=null;
					pieces[2][7]=new King(false);
					pieces[3][7]=new Rook(false);
					if(isInCheck()){
						undo();
						round++;
						return false;
					}
					round++;
					repaint();
					isCheckmate();
					return true;
				}
			}
		}
		return false;
	}
	public void undo(){
		if(s.isEmpty()){
		}else{
			Piece[][] abc=s.pop();
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(abc[i][j]!=pieces[i][j]){
						if(abc[i][j]!=null){
							pieces[i][j]=abc[i][j];
							if(pieces[i][j].getClass().getName().equals("Pawn")){
								System.out.println(pieces[i][j].numberOfMoves);
							}
							pieces[i][j].numberOfMoves--;
							if(pieces[i][j].getClass().getName().equals("Pawn")){
								System.out.println(pieces[i][j].numberOfMoves);
							}
						}else{
							pieces[i][j]=null;
						}
					}
				}
			}
			round--;
		}
		repaint();
	}
	public void push(Piece[][] pieces){
		Piece[][] temp=new Piece[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(pieces[i][j]!=null){
					temp[i][j]=pieces[i][j];
				}
			}
		}
		s.push(temp);
	}
	public void save(String fileName) {
		PrintStream in;
		try {
			in = new PrintStream(new File(fileName));
			System.out.println(1);
			in.println(round%2==0?"Black":"White");
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(pieces[i][j]!=null){
						char f=(char)(i+'A');
						char s=(char)(8-j+'0');
						String pos=""+f+s;
						in.println(pieces[i][j].getColor()+"-"+pieces[i][j].getClass().getName()+"-"+pos);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(2);
	}
	public boolean isInCheck(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				for(int k=0;k<8;k++){
					for(int l=0;l<8;l++){
						if(pieces[i][j]!=null&&((round%2==0&&!pieces[i][j].isBlack)||(round%2==1&&pieces[i][j].isBlack))){
							if(pieces[k][l]!=null&&pieces[k][l].getClass().getName().equals("King")){
								int diffX = k - i;
								int diffY = l - j;
								if(pieces[i][j].canCapture(diffX, diffY)&&
										pieces[i][j].isBlack!=pieces[k][l].isBlack&&
										!pieces[i][j].isBlocked(i, j, k, l, pieces)){
									System.out.println("ÞAH!!!!");
									System.out.println("i:"+i+", j:"+j+", k:"+k+", l:"+l);
									return true;
								}
							}	
						}
					}
				}
			}
		}
		return false;
	}
	public boolean isCheckmate(){
		if(isInCheck()){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					for(int k=0;k<8;k++){
						for(int l=0;l<8;l++){
							if(pieces[i][j]!=null&&((round%2==0&&pieces[i][j].isBlack)||(round%2==1&&!pieces[i][j].isBlack))){
								if(pieces[k][l]!=null){
									if(pieces[i][j].isBlack!=pieces[k][l].isBlack&&
											pieces[i][j].canCapture(k-i, l-j)&&									
											!pieces[i][j].isBlocked(i, j, k, l, pieces)){
										Piece p=pieces[k][l];
										pieces[k][l]=pieces[i][j];
										pieces[i][j]=null;
										if(!isInCheck()){
											pieces[i][j]=pieces[k][l];
											pieces[k][l]=p;
											return false;
										}else{
											System.out.println("HAHA!");
											pieces[i][j]=pieces[k][l];
											pieces[k][l]=p;
										}
									}
								}else if(pieces[i][j].canMove(k-i, l-j)&&
										!pieces[i][j].isBlocked(i, j, k, l, pieces)){
									pieces[k][l]=pieces[i][j];
									pieces[i][j]=null;
									if(!isInCheck()){
										pieces[i][j]=pieces[k][l];
										pieces[k][l]=null;
										return false;
									}else{
										pieces[i][j]=pieces[k][l];
										pieces[k][l]=null;
									}
								}
							}

						}
					}
				}
			}
		}else{
			
			return false;
		}

		System.out.println("MAT!!!!");
		String message="";
		if(round%2==0){
			message="White WON!";
		}else{
			message="Black WON!";
		}
		System.out.println("GAME OVER!!!");
		JOptionPane.showMessageDialog(null, message,"CHECKMATE",-1);
		return true;
	}

	public void initializeChessBoard()
	{
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(j == 1)
				{
					pieces[i][j] = new Pawn(true);
				}
				else if(j == 6)
				{
					pieces[i][j] = new Pawn(false);
				}
				else
				{
					pieces[i][j] = null;
				}
			}
		}
		pieces[0][0]=new Rook(true);
		pieces[0][7]=new Rook(false);
		pieces[7][0]=new Rook(true);
		pieces[7][7]=new Rook(false);
		pieces[2][0]=new Bishop(true);
		pieces[2][7]=new Bishop(false);
		pieces[5][0]=new Bishop(true);
		pieces[5][7]=new Bishop(false);
		pieces[1][0]=new Knight(true);
		pieces[1][7]=new Knight(false);
		pieces[6][0]=new Knight(true);
		pieces[6][7]=new Knight(false);
		pieces[3][0]=new Queen(true);
		pieces[3][7]=new Queen(false);
		pieces[4][0]=new King(true);
		pieces[4][7]=new King(false);
	}
	public static ChessFrame load(String fileName){
		ChessFrame frame=new ChessFrame();
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				frame.pieces[i][j]=null;
			}
		}
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
			if(input.hasNext()){
				String s=input.nextLine();
				if(s.equals("Black")){
					frame.round=2;
				}else{
					frame.round=1;
				}
			}
			while(input.hasNextLine()){
				boolean b=false;
				Piece p = null;
				String s=input.nextLine();
				String color=s.substring(0,5);
				String type=s.substring(6,s.lastIndexOf('-'));		
				String pos=s.substring(s.lastIndexOf('-')+1);
				pos=pos.toUpperCase();
				int posx=pos.charAt(0)-'A';
				int posy=7-(pos.charAt(1)-'0'-1);
				if(color.equals("Black")){
					b=true;
				}else{
					b=false;
				}
				if(type.equals("Pawn")){
					p=new Pawn(b);
					if((b==true&&posy==1) ||(b==false&&posy==6)  ){
						p.numberOfMoves=0;
					}else{
						p.numberOfMoves=1;
					}
				}else if(type.equals("Rook")){
					p=new Rook(b);
				}else if(type.equals("Knight")){
					p=new Knight(b);
				}else if(type.equals("Bishop")){
					p=new Bishop(b);
				}else if(type.equals("Queen")){
					p=new Queen(b);
				}else if(type.equals("King")){
					p=new King(b);
				}
				if(p!=null)
					frame.pieces[posx][posy]=p;	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frame;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//print the board 's lines to show squares
		g.setColor(Color.BLACK);
		g.drawLine(2*BOARD_MARGIN-1, BOARD_MARGIN*3, 2*BOARD_MARGIN-1, 3*BOARD_MARGIN+(8)*SQUARE_WIDTH);
		g.drawLine(2*BOARD_MARGIN, 3*BOARD_MARGIN-1, 2*BOARD_MARGIN+(8)*SQUARE_WIDTH, 3*BOARD_MARGIN-1);
		g.drawLine(2*BOARD_MARGIN+(8)*SQUARE_WIDTH+1, BOARD_MARGIN*3,2*BOARD_MARGIN+(8)*SQUARE_WIDTH+1, 3*BOARD_MARGIN+(8)*SQUARE_WIDTH);
		g.drawLine(2*BOARD_MARGIN, 3*BOARD_MARGIN+(8)*SQUARE_WIDTH+1,2*BOARD_MARGIN+(8)*SQUARE_WIDTH, 3*BOARD_MARGIN+(8)*SQUARE_WIDTH+1);
		for(int i = 0; i<8; i++)
		{
			for(int j=0;j<8;j++){
				if((i+j)%2==0){
					g.setColor(Color.ORANGE);
				}else{
					g.setColor(Color.GREEN);
				}
				g.fillRect(2*BOARD_MARGIN+(i)*SQUARE_WIDTH, 
						BOARD_MARGIN*3+(j)*SQUARE_WIDTH, 
						SQUARE_WIDTH, 
						SQUARE_WIDTH);
			}
		}
		//print the pieces
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(pieces[i][j] != null)
				{
					pieces[i][j].drawYourself(g, i*SQUARE_WIDTH+2*BOARD_MARGIN, 
							j*SQUARE_WIDTH+BOARD_MARGIN*3, SQUARE_WIDTH);
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Clicked");

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Pressed");
		//calculate which square is selected 
		if(pieces[(e.getX()-2*BOARD_MARGIN)/SQUARE_WIDTH][(e.getY()-BOARD_MARGIN*3)/SQUARE_WIDTH]!=null){
			if(round%2==0 && pieces[(e.getX()-2*BOARD_MARGIN)/SQUARE_WIDTH][(e.getY()-BOARD_MARGIN*3)/SQUARE_WIDTH].isBlack
					||round%2==1 && !pieces[(e.getX()-2*BOARD_MARGIN)/SQUARE_WIDTH][(e.getY()-BOARD_MARGIN*3)/SQUARE_WIDTH].isBlack )
			{
				selectedSquareX = (e.getX()-2*BOARD_MARGIN)/SQUARE_WIDTH;
				selectedSquareY = (e.getY()-BOARD_MARGIN*3)/SQUARE_WIDTH;
				System.out.println(selectedSquareX+","+selectedSquareY);	
			}
		}
		//System.out.println(selectedSquareX+","+selectedSquareY);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Released");
		//calculate which square is targeted
		int targetSquareX = (e.getX()-2*BOARD_MARGIN)/SQUARE_WIDTH;
		int targetSquareY = (e.getY()-BOARD_MARGIN*3)/SQUARE_WIDTH;
		//System.out.println(targetSquareX+","+targetSquareY+"\n");

		char f2=(char)(targetSquareX+'A');
		char s2=(char)(8-targetSquareY+'0');
		String pos2=""+f2+s2;
		char x1=(char)(selectedSquareX+'A');
		char y1=(char)(8-selectedSquareY+'0');
		String pos1=""+x1+y1;
		System.out.println("pos1:"+pos1);
		System.out.println("pos2:"+pos2);
		if(pos1.equalsIgnoreCase("e8")&&pos2.equalsIgnoreCase("a8")&&round%2==0){
			castling(false);
		}else if(pos1.equalsIgnoreCase("e8")&&pos2.equalsIgnoreCase("h8")&&round%2==0){
			castling(true);
		}else if(pos1.equalsIgnoreCase("e1")&&pos2.equalsIgnoreCase("a1")&&round%2==1){
			castling(false);
		}else if(pos1.equalsIgnoreCase("e1")&&pos2.equalsIgnoreCase("h1")&&round%2==1){
			castling(true);
		}else{
			move(pos1,pos2);
		}

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Entered");

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Exited");

	}
}
