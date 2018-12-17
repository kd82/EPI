
public class BuildingsWithView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] input={1,2,1,2};
      System.out.println(buildsWithSunsetView(input));
	}
	
	public static int buildsWithSunsetView(int[] arr){
		int count=1;
		int n=arr.length;
		int max=arr[n-1];
		for(int i=n-2;i>=0;--i){
			if(arr[i]>max){
				count++;
				max=arr[i];
			}
		}
		return count;
	}

}
