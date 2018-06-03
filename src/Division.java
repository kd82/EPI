
public class Division {

	public static void main(String[] args) {
		long a=32;
		long b=8;
		System.out.println(divideBruteForce(a,b));
		System.out.println(divide(a,b));
	}

	private static long divideBruteForce(long a, long b) {
		long result=0;
		while(a>=b){
			a=a-b;
			result++;
		}
		return result;
	}
	private static long divide(long x,long y){
		long result=0;
		short power=32;
		long yPower=y<<power;
		System.out.println(yPower);
		while(x>=y){
			while(yPower>x){
				yPower>>>=1;
				power--;
			}
			result+=1L<<power;
			x-=yPower;
		}
		
		return result;
	}

}
