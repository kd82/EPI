

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] a={1,5,9,0,0,0};
		int[] b={2,4,6};
		int[] sorted=merge(a,3,b);
		for(int i=0;i<a.length;++i){
			System.out.println(sorted[i]);
		}
	}

	private static int[] merge(int[] a, int size, int[] b) {
		int i=size-1,k=a.length-1,j=b.length-1;
		while(i>=0 && j>=0){
		   a[k--]=a[i]>b[j]?a[i--]:b[j--];
		}
		while(j>=0){
			 a[k--]=b[j--];
		 }
		return a;
	}

}
