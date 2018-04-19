
public class Parity {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(parity(6));
	}
    public static short parity(long x)
    {
    	short res=0;
    	res=(short) ((x>>>2)&1);
    	long bitMask=(1l&3);
    	return (short) (res^bitMask);
    }
}
