package miscallaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("serial")
		List<List<Integer>> originalMatrix = new ArrayList<List<Integer>>() {{
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
		System.out.println("The rotated Matrix is: ");
		List<List<Integer>> rotatedMatrix=rotateMatrix(originalMatrix);
		for(int i=0;i<rotatedMatrix.size();i++)
		{
			for(int j=0;j<rotatedMatrix.size();j++){
				System.out.print(rotatedMatrix.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> rotateMatrix(List<List<Integer>> originalMatrix) {
	  final int matrixSize=originalMatrix.size()-1;
	  for(int row=0;row<(originalMatrix.size()/2);++row)
	  {
		  for(int col=row;col<matrixSize-row;++col){
			  int temp1=originalMatrix.get(matrixSize-col).get(row);
			  int temp2=originalMatrix.get(matrixSize-row).get(matrixSize-col);
			  int temp3=originalMatrix.get(col).get(matrixSize-row);
			  int temp4=originalMatrix.get(row).get(col);
			  originalMatrix.get(row).set(col, temp1);
			  originalMatrix.get(matrixSize-col).set(row, temp2);
			  originalMatrix.get(matrixSize-row).set(matrixSize-col, temp3);
			  originalMatrix.get(col).set(matrixSize-row, temp4);
		  }
	  }
	  return originalMatrix;
	}

}
