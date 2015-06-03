import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class CalculateExpression {
   // int sum ;
	Map<Character,Integer> letterValMap = new HashMap<>();
	int sum1 = 0;
	List<String> st = new ArrayList<String>();
	public CalculateExpression() {
	
	}
	
	/**
	 * Method taking two params and recursively calling 
	 * itself each time with a character comes just before the previous character 
	 * in addition to it's respective numeric postion
	 * @param ch  
	 * @param pos
	 * @return
	 */
	public int calExpr(char ch , int  pos){
		int sum=0;
		ch = Character.toUpperCase(ch);
		if(ch=='A'){
			return 1;
		}else {
			ch--;
			sum = sum + (calExpr(ch , (int)ch-64) *2) + pos;
			return sum;
		}
	}
	
	 
		/**
	 * Method which takes any String and returns the sum of values each character equals to.
	 * This value is calculated according to the follwing expression
	 * A = 1; B =A*2 + 2 ; C = B*2 + 3 and so on...
	 * @param str - Required String
	 * @return the sum of integer values of letters
	 */
	 
    public int addLettersOfString(String str){
    	int sumOfLetters = 0,value=0;
    	str = str.toUpperCase();
    	char[] ch = str.toCharArray();
    	for(int i =0;i<ch.length;i++){
    		value = calExpr(ch[i],(int)ch[i]-64);
    		sumOfLetters = sumOfLetters + value;
    	}
    	return sumOfLetters;
    }
      
    public char[] returnString(char[]word,int number){
    	
    	char[] str = new char[70];
    	int  j=0;
    	    for(int i=25;number > 0;i--)
    	    {
    	        while(letterValMap.get(word[i])<=number)
    	        {
    	    	  	str[j++]=(char)(65+i);
    	    	    number = number-letterValMap.get(word[i]);
    	        }	
    }
   return str;
    } 
    
	public static void main(String[] args) {
		char ch='A';
		int pos,val,number=0;
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";            // Assign any String
		String str,strExp="";
		CalculateExpression c= new CalculateExpression();
		char[] word = alphabets.toCharArray();
		for(int i = 0 ;i<word.length;i++){
			val = c.calExpr(word[i], (int)word[i]-64);
			c.letterValMap.put(word[i], val);
		}
				
		//Take a character input and get the corresponding value 
		System.out.print("Enter a character");
		System.out.println();
		Scanner sc  = new Scanner(System.in);
		String strInput = sc.nextLine();
		while(!strInput.matches("[a-zA-Z]+")&& strInput.length()!=1){
			System.out.print("Please Enter a character");
			strInput = sc.nextLine();
		
		}
		ch = strInput.charAt(0);
		ch = Character.toUpperCase(ch);
		pos =(int)ch - 64;
		val = c.calExpr(ch,pos);
		
		// Take a String input and get the sum of each character
		System.out.println("Enter a String");
		str = sc.nextLine();
		while(!str.matches("[a-zA-Z]+")){
			System.out.print("Please Enter an Albhabet");
			str = sc.nextLine();
		}
		int sum = c.addLettersOfString(str);
		// Take The Numeric Position Of Given character
		Character newChar  = str.charAt(0);
		strExp = newChar.toString();
        char[] chr  = str.toCharArray();
        for(int i = 1 ;i<chr.length;i++){
         	strExp = strExp + "+" +chr[i];
         }
       
        // Take an integer and match it with all substring of letters and return the shortest one
        System.out.println("Enter a number");
        while (!sc.hasNextInt()){
        	System.out.print("Enter Proper Int value");
        	sc.next();
        }
        number = sc.nextInt();
        char[] str1 = c.returnString(word, number);
              
		// Display the outputs
       System.out.println("-------------OUTPUT-------------");
       System.out.println("1. Value Of : ["+ch+"] = " + val);
       System.out.print("2. Sum Of Letters of "+str+":");
       System.out.print("[");
       for(int i =0;i<str.length();i++){
    	   System.out.print(str.charAt(i));
    	   if(!(i==str.length()-1)){
    		   System.out.print("+");
    	   }
       }
       System.out.println("] = " + sum);
       System.out.print("3. String of given integer [" +number+ "] : ");
       System.out.println(str1);
       sc.close();
        }

}
