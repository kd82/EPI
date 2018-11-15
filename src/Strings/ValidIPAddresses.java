package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddresses {

	public static void main(String[] args) {
		List<String> IPAddresses=new ArrayList<String>();
		IPAddresses=getValidIpAddress("19216811");
		for(String s:IPAddresses){
			System.out.print(s+" ");
		}
	}
	public static List<String> getValidIpAddress(String s) {
	    // TODO - you fill in here.
		List<String> result=new ArrayList<>();
		for(int i=1;i<4 &&i<s.length();++i){
		 String first=s.substring(0,i);
		 if(isValid(first)){
			 for(int j=1;j<4 &&i+j<s.length();++j){
				 String second=s.substring(i,i+j);
				 if(isValid(second)){
				 for(int k=1;i+j+k<s.length()&& k<4;++k){
					 String third=s.substring(i+j,i+j+k);
					 String fourth=s.substring(i+j+k);
					 if(isValid(third) && isValid(fourth)){
						 result.add(first+"."+second+"."+third+"."+fourth);
					 }
					}
				 }
			 }
		 }
		}
	    return result;
	  }
	private static boolean isValid(String first) {
		if(first.length()>3)
			return false;
		// All other than 0 are invalid;
		if(first.startsWith("0")&& first.length()>1){
			return false;
		}
		int val=Integer.parseInt(first);
		return val<=255 && val>=0;
	}
}
