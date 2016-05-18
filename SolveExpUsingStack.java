/**
 * program:	SolveEcpUsingStack.java
 * version:	1.3
 * author:	Hrishikesh Karale (hhk9433)
 * date:	february 8, 2015
 */

import java.util.*;

/**
 * This Program solves the given expression using stack and prints out the 
 * result as output.
 * we load the expression character by character into the stack until we find
 * a closing bracket. when a closing bracket is found we pop the elements until
 * an opening bracket is found and pop an extra element. then we evaluate the 
 * popped expression enclosed in brackets and then push it back again into the
 * stack. 
 */
class SolveExpUsingStack
{
	/**
	 * This is the main method of our class. it loads the string character by 
	 * character and performs the necessary steps to solve the expression.
	 * @param args
	 */
	public static void main(String args[])	
  	{
		//stores sign from the expression.
    	String sign= "";
    	
    	//stores first part of the expression.
    	float first_integer= 0;
    	
    	//stores second part of the expression.
		float second_integer= 0;
		
		//stores the numbers to be pushed into stack.
		String s= "";
		
		//store the character read from the given expression.
		char exp= ' ';
		
		//given expression.
		String expression= "((1+2)*((3-4)*(5-6)))";
		
		//stack of strings is generated.
		Stack<String> st= new Stack<String>();
		
		/*
		 * this block of code reads the expression character by character and
		 * then performs the required action.
		 */
		for(int i=0; i< expression.length(); i++)
		{
			//stores i'th character from the expression.
			exp=expression.charAt(i++);

			//checks if the character read  is '(' or '-' or '+' or '/' or '*'
			if( (int)exp== 40 || (int)exp== 42 || (int)exp== 43 ||(int)exp== 45
					|| (int)exp== 47 )
			{
				//push the character on the stack.
				st.push(Character.toString(exp));
			}
			
			/*
			 * checks if the character being read is a number. if found to be true 
			 * it checks if consecutive characters are numbers to create a whole number.
			 */
			else if( ((int)exp>47 && (int)exp<58) || exp== '.')
			{
				s="";
				
				/*
				 * this block of code reads the number. 
				 */
				do
				{
					s= s+ exp;
					exp= expression.charAt(i++);
				}while(((int)exp>47 && (int)exp<58) || exp== '.');
				
				st.push(s);
				i--;
			}
			
			/*
			 * if a closing bracket is found then all the elements from the 
			 * stack are popped until and unless we find an opening bracket 
			 * and then another pop is done to remove the opening bracket. 
			 * Then the popped expressiona is evaluated and result is stored 
			 * in stack.
			 */
			else if( (int)exp== 41)
			{
				//top of the stack is popped, converted and stored
				second_integer= Float.parseFloat(st.pop());
				sign= st.pop();
				
				//top of the stack is popped, converted and stored
				first_integer= Float.parseFloat(st.pop());
				st.pop();
				
				/*
				 * This block of code checks the type of expression and then
				 * evaluates it giving us the result 
				 */
				if(sign.equals("+"))
					st.push(Float.toString(first_integer+second_integer));
				else if(sign.equals("-"))
					st.push(Float.toString(first_integer-second_integer));
				else if(sign.equals("*"))
					st.push(Float.toString(first_integer*second_integer));
				else if(sign.equals("/"))
					st.push(Float.toString(first_integer/second_integer));
			}
			i--;
		}
		
		System.out.println("\n Answer: "+st.pop() );
	}
}