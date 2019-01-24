package miscallaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrdering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("serial")
		List<List<Integer>> squareMatrix = new ArrayList<List<Integer>>() {{
		    add(Arrays.asList(5,3,1,3,7,9,10,11,12));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		    add(Arrays.asList(6,3,1,1,9,5,9,99,999));
		}};
		System.out.println("The spiral ordering is: ");
		List<Integer> ordering1=spiralOrdering(squareMatrix);
		for(int i=0;i<ordering1.size();++i)
		{
			System.out.print(ordering1.get(i)+" ");
		}
		System.out.println("\nThe spiral ordering is: ");
		List<Integer> ordering2=spiralMatrixOrder(squareMatrix);
		for(int i=0;i<ordering2.size();++i)
		{
			System.out.print(ordering2.get(i)+" ");
		}
		
	}

	private static List<Integer> spiralOrdering(List<List<Integer>> squareMatrix) {
		List<Integer> spiralOrdering=new ArrayList<Integer>();
		for(int offset=0;offset<Math.ceil(0.5*squareMatrix.size());++offset)
			{
	         matrixLayerInClockWise(squareMatrix,offset,spiralOrdering);
			}
		return spiralOrdering;
	}

	private static void matrixLayerInClockWise(List<List<Integer>> squareMatrix, int offset,
			List<Integer> spiralOrdering) {
		//If we are in the middle of the matrix
		int bound=squareMatrix.size()-offset-1;
		if(offset==bound){
			spiralOrdering.add(squareMatrix.get(offset).get(offset));
		}
		for(int row=offset;row<bound;++row)
		{
			spiralOrdering.add(squareMatrix.get(offset).get(row));
		}
		for(int column=offset;column<bound;++column)
		{
			spiralOrdering.add(squareMatrix.get(column).get(bound));
		}
		for(int i=bound;i>offset;--i)
		{
			spiralOrdering.add(squareMatrix.get(bound).get(i));
		}
		for(int j=bound;j>offset;--j)
		{
			spiralOrdering.add(squareMatrix.get(j).get(offset));
		}
		
	}

	private static List<Integer> spiralMatrixOrder(List<List<Integer>> squareMatrix){
		final int[][] SHIFT={{0,1},{1,0},{0,-1},{-1,0}}; 
		List<Integer> spiralOrdering=new ArrayList<Integer>();
		int dir=0,x=0,y=0;
		for(int i=0;i<squareMatrix.size()*squareMatrix.size();++i){
			spiralOrdering.add(squareMatrix.get(x).get(y));
			squareMatrix.get(x).set(y,0);
			int nextX=x+SHIFT[dir][0],nextY=y+SHIFT[dir][1];
			if(nextX<0 || nextX>=squareMatrix.size() ||
			   nextY<0 || nextY>=squareMatrix.size() ||
			   squareMatrix.get(nextX).get(nextY)==0)
				{
					dir=(dir+1)%4;
					nextX=x+SHIFT[dir][0];
					nextY=y+SHIFT[dir][1];
				}
			x=nextX;
			y=nextY;
		}
		return spiralOrdering;
	}
}
