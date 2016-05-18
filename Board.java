/**
 * 
 * $Id: 			Board.java
 * @version: 		v_1.4
 * date:			02/14/2015
 * Time:			18:22:00
 * @author    		hhk9433 (Hrishikesh Karale)
 * 
 * Revisions:
 *      Initial revision
 */


/*
 * This program places maximum number of queens on the given board without them
 * attacking each other.
 * Use 'javac Board.java' command to compile Board.java file and then execute 
 * using 'java Board' command in command prompt or terminal of your os.
 */
public class Board 
{
	//stores no of queens on board
	int duplicateQueenCount;
	//stored positions of queens on board
	static int queenpos[][]= new int[8][2];
	//used as trigger to check if a queen has been placed on current row
	static boolean check= false;
	int r=0;
	
	/**
	 *Constructor.
	 */
	Board()
	{
		duplicateQueenCount= 0;
	}
	
	/**
	 * Display board.
	 */
	private void display(int [][] boardDisplay)
	{
		
		for(int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				if(boardDisplay[i][j]==1)
					System.out.print(" Q");
				else
					System.out.print(" -");
			}System.out.println();
		}
	}
	

	/**
	 * This method blocks the attacking position of the queen diagonally, 
	 * vertically and horizontally,
	 */
	public void block(int duplicateChessBoard[][], int row, int column)
	{
		int row2=row+1;
		//blocks vertically downwards
		while(row2<8)	
		{
			if(duplicateChessBoard[row2][column]!= 1 )
				if(duplicateChessBoard[row2][column]== 0)
					duplicateChessBoard[row2++][column]= 2;
				else
					duplicateChessBoard[row2++][column]++;
		}
		
		row2=row-1;
		//blocks vertically upwards
		while(row2>=0)	
		{
			if(duplicateChessBoard[row2][column]!= 1 )
				if(duplicateChessBoard[row2][column]== 0)
					duplicateChessBoard[row2--][column]= 2;
				else	
					duplicateChessBoard[row2--][column]++;
		}
		
		int column2=column+1;
		//blocks horizontally to the right
		while(column2<8)	
		{
			if(duplicateChessBoard[row][column2]!=1 )
				if(duplicateChessBoard[row][column2]== 0)
					duplicateChessBoard[row][column2++]= 2;
				else
					duplicateChessBoard[row][column2++]++;
		}
		
		column2=column-1;
		//blocks horizontally to the left
		while(column2>=0)	
		{
			if(duplicateChessBoard[row][column2]!= 1 )
				if(duplicateChessBoard[row][column2]== 0)
					duplicateChessBoard[row][column2--]= 2;
				else
					duplicateChessBoard[row][column2--]++;
		}
	
		row2=row-1;
		column2=column+1;
		//blocks diagonally upwards right
		while(row2>=0 && column2<8)	
		{
			if(duplicateChessBoard[row2][column2]!= 1 )
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2--][column2++]= 2;
				else
					duplicateChessBoard[row2--][column2++]++;
		}
		
		row2=row+1;
		column2=column-1;
		//blocks diagonally downwards left
		while(row2<8 && column2>=0)	
		{
			if(duplicateChessBoard[row2][column2]!= 1 )
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2++][column2--]= 2;
				else
					duplicateChessBoard[row2++][column2--]++;
		}
		
		row2=row-1;
		column2=column-1;
		// blocks diagonally upwards left
		while(row2>=0 && column2>=0)	
		{
			if(duplicateChessBoard[row2][column2]!= 1 )
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2--][column2--]= 2;
				else
					duplicateChessBoard[row2--][column2--]++;
		}
		
		row2=row+1;
		column2=column+1;
		//blocks diagonally downwards right
		while(row2<8 && column2<8)	
		{
			if(duplicateChessBoard[row2][column2]!= 1 )
				if(duplicateChessBoard[row2][column2]== 0)
					duplicateChessBoard[row2++][column2++]= 2;
				else
					duplicateChessBoard[row2++][column2++]++;
		}
				
	}


	
	/*
	 * This method unblocks the attacking position of the currently removed 
	 * queen diagonally, vertically and horizontally,
	 */ 
	public void unBlock(int duplicateChessBoard[][], int row, int column)
	{
		int row2=row+1;
		//unblocks vertically downwards
		while(row2<8)	
		{
			if(duplicateChessBoard[row2][column]== 2)
				duplicateChessBoard[row2++][column]= 0;
			else if(duplicateChessBoard[row2][column]!= 0)
				duplicateChessBoard[row2++][column]--;
			else if(duplicateChessBoard[row2][column]== 0)
				row2++;
		}
		
		row2=row-1;
		//unblocks vertically upwards
		while(row2>=0)	
		{
			if(duplicateChessBoard[row2][column]== 2)
					duplicateChessBoard[row2--][column]= 0;
			else if(duplicateChessBoard[row2][column]!= 0)
				duplicateChessBoard[row2--][column]--;
			else if(duplicateChessBoard[row2][column]== 0)
				row2--;
		}
		
		int column2=column+1;
		//unblocks horizontally to the right
		while(column2<8)	
		{
			if(duplicateChessBoard[row][column2]== 2)
				duplicateChessBoard[row][column2++]= 0;
			else if(duplicateChessBoard[row][column2]!= 0)
				duplicateChessBoard[row][column2++]--;
			else if(duplicateChessBoard[row][column2]== 0)
				column2++;
		}
		
		column2=column-1;
		//unblocks horizontally to the left
		while(column2>=0)	
		{
			if(duplicateChessBoard[row][column2]== 2)
				duplicateChessBoard[row][column2--]= 0;
			else if(duplicateChessBoard[row][column2]!= 0)
				duplicateChessBoard[row][column2--]--;
			else if(duplicateChessBoard[row][column2]== 0)
				column2--;
		}
	
		row2=row-1;
		column2=column+1;
		//unblocks diagonally upwards right
		while(row2>=0 && column2<8)	
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2--][column2++]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2--][column2++]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2--;
				column++;
			}
		}
		
		row2=row+1;
		column2=column-1;
		//unblocks diagonally downwards left
		while(row2<8 && column2>=0)	
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2++][column2--]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2++][column2--]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2++;
				column--;
			}
		}
		
		row2=row-1;
		column2=column-1;
		//unblocks diagonally upwards left
		while(row2>=0 && column2>=0)	
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2--][column2--]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2--][column2--]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2--;
				column--;
			}
		}
		
		row2=row+1;
		column2=column+1;
		//unblocks diagonally downwards right
		while(row2<8 && column2<8)	
		{
			if(duplicateChessBoard[row2][column2]== 2)
				duplicateChessBoard[row2++][column2++]= 0;
			else if(duplicateChessBoard[row2][column2]!= 0)
				duplicateChessBoard[row2++][column2++]--;
			else if(duplicateChessBoard[row2][column2]== 0)
			{
				row2++;
				column++;
			}
		}
				
	}

	/**
	 * This method places a queen if the position is marked empty
	 */
	private void placeQueen(int duplicateChessBoard[][], int rows, int columns)
	{
		int row=rows;
		int column= columns;
		
		//checks if no of rows are in bounds
		while( row<8)	
		{
			//Checks for columns are in bounds
			while( column<8)
			{
				//checks if all the 8 queens are already found.
				if(duplicateQueenCount==8 )
				{
					System.out.println("\nNo Of Queens: "+duplicateQueenCount);
					display(duplicateChessBoard);
					duplicateQueenCount= 0;
			//		System.exit(0);
					for(int i=0; i<8; i++)
						for(int j=0; j<8; j++)
						{
							duplicateChessBoard[i][j]=0;
							if(j<2)
								queenpos[i][j]=0;
						}
					
					while(r<8)
					{
						placeQueen(duplicateChessBoard,++r ,0);
					}
					System.exit(0);
				}
				
				//checks for an empty slot for the queen.
				if(duplicateChessBoard[row][column]== 0)	
				{
					duplicateChessBoard[row][column]= 1;
					duplicateQueenCount++;
					
					//stores queen co-ordinate in queenpos array.
					queenpos[duplicateQueenCount-1][0] = row;
					queenpos[duplicateQueenCount-1][1] = column;
					
					//blocks possible attacking positions for the current queen
					block(duplicateChessBoard/*tempChessBoard*/, row, column);
					
					// checks no of columns don't exceed their bounds
					if(++column>= 9)	
					{
						if(queenpos[duplicateQueenCount-1][0]!=row++)
						{
							//sets check trigger to true as no queen found
							check=	true;
							//decrements queen count as we will be removing previous queen
							duplicateQueenCount--;
							// removes previous queen
							duplicateChessBoard[queenpos[duplicateQueenCount][0]]
											[queenpos[duplicateQueenCount][1]]= 0;
							//unblocks previous queens attacking positions
							unBlock(duplicateChessBoard, 
								queenpos[duplicateQueenCount][0], 
									queenpos[duplicateQueenCount][1]);
							return;
						}	
					}
				}
				else
				{
					//try placing a queen in next column
					placeQueen(duplicateChessBoard,row,++column);

					/*
					 * checks if there exist a row where check was triggered for no 
					 * queen found in that row.
					 */
					if(check)
					{ 
						//sets check trigger to false
						check=false;
						//removes previous queen
						duplicateChessBoard[queenpos[duplicateQueenCount][0]]
										[queenpos[duplicateQueenCount][1]]= 0;
						//unblocks previous queens  attacking position
						unBlock(duplicateChessBoard, 
							queenpos[duplicateQueenCount][0], 
								queenpos[duplicateQueenCount][1]);
						//tries to place a queen in the column next to the previous queen
						placeQueen(duplicateChessBoard, 
							queenpos[duplicateQueenCount][0], 
								++queenpos[duplicateQueenCount][1]);
					}
				}
			}

			//check is a queen already exists in the current row
			if(queenpos[duplicateQueenCount-1][0]==row++)
			{
				//place a queen in next row				
				placeQueen(duplicateChessBoard, row, 0);	
			}
			else
			{
				/*
				 * checks if there exist a row where check was triggered for no 
				 * queen found in that row.
				 */
				if(check)
				{ 
					//sets check trigger to false
					check=false;
					//removes previous queen
					duplicateChessBoard[queenpos[duplicateQueenCount][0]]
									[queenpos[duplicateQueenCount][1]]= 0;
					//unblocks previous queens  attacking position
					unBlock(duplicateChessBoard, 
						queenpos[duplicateQueenCount][0], 
							queenpos[duplicateQueenCount][1]);
					//tries to place a queen in the column next to the previous queen
					placeQueen(duplicateChessBoard, 
						queenpos[duplicateQueenCount][0], 
							++queenpos[duplicateQueenCount][1]);
				}
				check=true;
				duplicateQueenCount--;
				return;
			}
		}		
	}
	

	public static void main(String[] args)
	{
		//chessboard matrix declaration. 
		int [][] chessBoard = new int [8][8];	
		//board object initialized
		Board boardObject = new Board();	
		
		//Initializes chessBoard and queenpos to defaults
		for(int row=0; row<8; row++)	
		{
			for (int column=0; column<8; column++)
			{
				chessBoard[row][column]= 0;
			}
			queenpos[row][0]= 0;
			queenpos[row][1]= 0;
		}
		
		/*
		 * calls plcaeQueen to check if a queen can be placed in position (0,0)
		 * position of our board.
		 */
		boardObject.placeQueen(chessBoard, 0,0);
	}
}