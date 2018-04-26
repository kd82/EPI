import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number:");
		sc = new Scanner(System.in);
		int n=sc.nextInt();
        List<Integer> primes =generatePrimes(n);
        for(int prime:primes)
        {
        	System.out.print(prime+" ");
        }
	}

	private static List<Integer> generatePrimes(int n) {
		List<Integer> primes=new ArrayList<Integer>();
		List<Boolean> isPrime=new ArrayList<>(Collections.nCopies(n+1, true));
		//Initializing to 0 and 1 to false
		//since they are not prime
		isPrime.set(0, false);
		isPrime.set(1, false);
		for(int i=2;i<=n;++i)
		{
			if(isPrime.get(i))
				primes.add(i);
			for(int j=i;j<=n;j+=i)
			{
			   isPrime.set(j, false);
			}
		}
		return primes;
	}

}
