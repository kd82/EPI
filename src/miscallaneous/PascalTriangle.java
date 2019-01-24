package miscallaneous;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		
		List<List<Integer>> pascalsTriangle=computePascalTriangle(10);
		System.out.println(pascalsTriangle.toString());
	}

	private static List<List<Integer>> computePascalTriangle(int n) {
		List<List<Integer>> pascalsTriangle=new ArrayList<>();
		for(int i=0;i<n;++i)
		{
			List<Integer> curRow=new ArrayList<>();
			for(int j=0;j<=i;++j){
				curRow.add((0<j && j<i)?
						pascalsTriangle.get(i-1).get(j-1)+pascalsTriangle.get(i-1).get(j):1);
			}
			pascalsTriangle.add(curRow);
		}
		return pascalsTriangle;
	}

}
