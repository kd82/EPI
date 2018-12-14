package stacks;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BuildingsWithHeight {
    
	public static class BuildingWithHeight{
		public Integer Idx;
		public Integer Height;
	    
		public BuildingWithHeight(int id,int height){
			this.Idx=id;
			this.Height=height;
		}
	}
	
	public static Deque<BuildingWithHeight> examineBuildingsWithSunset(Iterator<Integer> buildings){
		Deque<BuildingWithHeight> buildingsWithView=new LinkedList<>();
		int buildingIdx=0;
		while(buildings.hasNext()){
			Integer buildingHeight=buildings.next();
			while(!buildingsWithView.isEmpty() && (Integer.compare(buildingHeight, buildingsWithView.getLast().Height)>=0)){
				buildingsWithView.removeLast();
			}
			buildingsWithView.addLast(new BuildingWithHeight(buildingIdx++, buildingHeight));
		}
		return buildingsWithView;
	}

}
