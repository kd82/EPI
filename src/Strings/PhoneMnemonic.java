package strings;

import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonic {

	public static void main(String[] args) {
		List<String> numbers=new ArrayList<String>();
		numbers=phoneMnemonic("120");
		for(String num:numbers){
			System.out.print(num+" ");
		}
		System.out.println("\nIterative");
		List<String> iterativeNumbers=new ArrayList<String>();
		iterativeNumbers=phoneMnemonicIterative("120");
		for(String num:iterativeNumbers){
			System.out.print(num+" ");
		}

	}
	private static final String[] MAPPING={"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","UVW","WXYZ"};
	public static List<String> phoneMnemonic(String phoneNumber) {
	    List<String> mnemonics=new ArrayList<>();
	    char[] partialMnemonics=new char[phoneNumber.length()];
	    phoneMnemonicHelper(phoneNumber,0,partialMnemonics,mnemonics);
	    return mnemonics;
	  }
	private static void phoneMnemonicHelper(String phoneNumber, int digit, char[] partialMnemonic,
			                                List<String> mnemonics ) {
		//Base case for recursion which indicates all digits are processed
		if(digit==phoneNumber.length()){
			mnemonics.add(new String(partialMnemonic));
		}
		else
		{
			for(int i=0;i<MAPPING[phoneNumber.charAt(digit)-'0'].length();++i){
			   char c=MAPPING[phoneNumber.charAt(digit)-'0'].charAt(i);
			   partialMnemonic[digit]=c;
			   phoneMnemonicHelper(phoneNumber,digit+1,partialMnemonic,mnemonics);
			}
	   }
	}
	private static List<String> phoneMnemonicIterative(String phoneNumber){
		 List<String> mnemonics=new ArrayList<>();
		 mnemonics.add("");
		  for(int digit = 0; digit < phoneNumber.length(); digit++) {
			  List<String> partialMnemonic=new ArrayList<>();
			  for(int j=0;j<MAPPING[phoneNumber.charAt(digit)-'0'].length();++j){
				  for(String s: mnemonics){  
					  char c=MAPPING[phoneNumber.charAt(digit)-'0'].charAt(j);
			          s+=c;  
			          partialMnemonic.add(s);
			        } 
				}
			  mnemonics=partialMnemonic;
	      }
		return mnemonics;
	}
}
