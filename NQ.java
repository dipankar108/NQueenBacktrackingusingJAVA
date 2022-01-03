public class NQ{
	static boolean isSafe(int[][] board,int row, int col ){
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
				if (Nqueen(board,row+1))return true;
				   board[row][col]=0;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] board={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		Nqueen(board,0); 
		for (int i=0; i<board.length;i++ ) {
for (int j=0; j<board.length;j++ ) {
				System.out.print(board[i][j]);
}
System.out.println();
		}
	}
}