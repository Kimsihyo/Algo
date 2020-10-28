import java.util.*;
import java.io.*;

public class Madas {
	static int[][] tmap;
	static int n;
	static boolean[][] visit;

	public static void main(String[] args) {
		int[][] board = { { 1, 1, 3, 3 }, { 4, 1, 3, 4 }, { 1, 2, 1, 1 }, { 2, 1, 3, 2 } };
		
		for(int row=board.length-1; row>0; row--) {
	         for(int col=0; col<board.length; col++) {
	            if(board[row][col]==0) {
	               for(int x=row-1; x>=0; x--) {
	                  if(board[x][col]!=0) {
	                     board[row][col] = board[x][col];
	                     board[x][col]=0;
	                     break;
	                  }
	               }
	            }
	         }
	      }
		
		
		visit = new boolean[board.length][board.length];
	      for(int i=0; i<board.length; i++) {
	         for(int j=0; j<board.length; j++) {
	            if(board[i][j]!=0) {
	               int candy = board[i][j];
	               int index = 1;
	               for(int row=i+1; row<board.length; row++) {
	                  if(board[row][j]==candy) {
	                     index++;
	                  }
	                  else {
	                     break;
	                  }
	               }
	               if(index>=3) {
	                  for(int row=0; row<index; row++) {
	                     visit[i+row][j]=true;
	                  }
	               }
	               index=1;
	               for(int col=j+1; col<board.length; col++) {
	                  if(board[i][col]==candy) {
	                     index++;
	                  }
	                  else {
	                     break;
	                  }
	               }
	               if(index>=3) {
	                  for(int col=0; col<index; col++) {
	                     visit[i][j+col]=true;
	                  }
	               }
	            }
	         }
	      }

	}

}
