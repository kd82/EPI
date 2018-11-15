package strings;

public class BaseConversion {

	public static void main(String[] args) {
	 System.out.println("Converted Base "+convertBase("615", 7, 13));
	}
	public static String convertBase(String numAsString, int b1, int b2) {
	    boolean isNegative=numAsString.startsWith("-");
	    int i=isNegative?1:0;
	    int x=0;
	    while(i<numAsString.length()){
	    	x*=b1;
	    	x+=Character.isDigit(numAsString.charAt(i))?numAsString.charAt(i)-'0'
	    			:numAsString.charAt(i)-'A'+10;
	    	i++;
	    }
	    return (isNegative?"-":"")+(x==0?"0":constructFromBase(x,b2));
	  }
	private static String constructFromBase(int x, int base) {
		return x==0?"":constructFromBase(x/base,base)
				+(char)(x%base>=10?'A'+x%base-10:'0'+x%base);
	}
}
