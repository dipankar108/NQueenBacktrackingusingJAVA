//This is NQueen backtracking java code.
// In this code default boasd initialized by 0. It means there is No queen.
// If we are able to replace queen then we replaced 0 to 1.
// you can use String for this operation but it needs some modification.


public class NQ{
	static boolean isSafe(int[][] board,int row, int col ){
		//Here if all the position that checked if there is already queen then its value is already 1 so that means we cannot add any queen on that 
		//position and we return false.
		// check horizontali
		for (int i=0; i<board.length; i++) {
			if (board[row][i]==1)return false;
		}
		// check vertically
		for (int i=0;i<board.length ;i++ ) {
			if(board[i][col]==1)return false;
		}
		//check upperleft
		for (int r=row,c=col;r>=0 && c>=0 ;r--,c-- ) {
			if(board[r][c]==1)return false;
		}
		//check upperright
		for (int r=row,c=col;r>=0 && c<board.length ;r--,c++ ) {
			if(board[r][c]==1)return false;
		}
		//check lowerleft
		for (int r=row,c=col;r<board.length && c>=0 ;r++,c-- ) {
			if(board[r][c]==1)return false;
		}
		//check upperleft
		for (int r=row,c=col;r<board.length && c<board.length ;r++,c++ ) {
			if(board[r][c]==1)return false;
		}
		return true;
	}
	static boolean Nqueen(int[][] board,int row){
		int N=board.length;
		if (row==N) return true;
		for (int col=0;col<N ;col++ ) {
			if (isSafe(board,row,col)) {
			      board[row][col]=1;
				// call recursion function
				if (Nqueen(board,row+1))return true;
				// if we got false than we nwwd to backtrack old queen position I mean make it 00 again 
				   board[row][col]=0;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] board={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		Nqueen(board,0); 
		//Printing new solution
		for (int i=0; i<board.length;i++ ) {
for (int j=0; j<board.length;j++ ) {
				System.out.print(board[i][j]);
}
System.out.println();
		}
	}
}
