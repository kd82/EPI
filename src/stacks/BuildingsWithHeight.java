package stacks;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BuildingsWithHeight {
    
	public class BuildingWithHeight{
		public Integer Idx;
		public Integer Height;
	    
		public BuildingWithHeight(int id,int height){
			this.Idx=id;
			this.Height=height;
		}
	}
	
	public static void main(String[] args) {

	}
	
	public static Deque<BuildingWithHeight> examineBuildingsWithSunset(Iterator<Integer> buildings){
		Deque<BuildingWithHeight> buildingsWithView=new LinkedList<>();
		
		return buildingsWithView;
	}

}
