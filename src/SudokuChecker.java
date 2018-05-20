import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuChecker {

	public static void main(String[] args) {
		
		@SuppressWarnings("serial")
		List<List<Integer>> assignment = new ArrayList<List<Integer>>() {{
		    add(Arrays.asList(5,3,0,0,7,0,0,0,0));
		    add(Arrays.asList(6,0,0,1,9,5,0,0,0));
		    add(Arrays.asList(0,9,8,0,0,0,0,6,0));
		    add(Arrays.asList(8,0,0,0,6,0,0,0,3));
		    add(Arrays.asList(4,0,0,8,0,3,0,0,1));
		    add(Arrays.asList(7,0,0,0,2,0,0,0,6));
		    add(Arrays.asList(0,6,0,0,0,0,2,8,0));
		    add(Arrays.asList(0,0,0,4,1,9,0,0,5));
		    add(Arrays.asList(0,0,0,0,8,0,0,7,9));
		}};
		System.out.println("The given assignment is: "+sudokuCheck(assignment));
		
	}
	
	private static boolean sudokuCheck(List<List<Integer>> partialAssignment){
	
	    //Check row constraints
		for(int i=0;i<partialAssignment.size();++i)
		{
			if(hasDuplicate(partialAssignment,i,i+1,0,partialAssignment.size()))
			 return false;
		}
		
		//Check column constraints
		for(int j=0;j<partialAssignment.size();++j)
		{
			if(hasDuplicate(partialAssignment,0,partialAssignment.size(),j,j+1))
			 return false;
		}
		//Check region constraints
		int regionSize=(int)Math.sqrt(partialAssignment.size());
		for(int I=0;I<regionSize;++I)
		{
			for(int J=0;J<regionSize;++J)
			{
				if(hasDuplicate(partialAssignment,I*regionSize,(I+1)*regionSize,J*regionSize,(J+1)*regionSize))
					 return false;
			}
		}
		
		return true;
	}

	private static boolean hasDuplicate(List<List<Integer>> partialAssignment, int startRow,
			                            int endRow, int startCol, int endCol) {
		//Boolean array to check for duplicate values;
		List<Boolean> isPresent=new ArrayList<>(
				                 Collections.nCopies(partialAssignment.size()+1, false));
	    for(int i=startRow;i<endRow;++i)
	    {
	    	for(int j=startCol;j<endCol;++j)
	    	{
	    		// If the value is present in the boolean array then return true;
	    		if(partialAssignment.get(i).get(j)!=0
	    				&& isPresent.get(partialAssignment.get(i).get(j)))
	    		{
	    			return true;
	    		}
	    		isPresent.set(partialAssignment.get(i).get(j), true);
	    	}
	    }
		return false;
	}

}
