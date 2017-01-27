package stack;

import java.util.Scanner;

public class DijkstraEvaluation {
	public static void main(String []args){
		Stack<String> operators =  new Stack<String>();
		Stack<Double> digits =  new Stack<Double>();
		
		System.out.println("Ingresa ej. (1+((2+3)*(4*5))):");
		Scanner sc =  new Scanner(System.in);
		String line =  sc.nextLine();
		
		for(int i = 0; i < line.length(); i++){
			char symbol = line.charAt(i);
			if(symbol == '('){}
			else if(symbol == '+'){ operators.push(symbol+""); }
			else if(symbol == '*'){ operators.push(symbol+""); }
			else if(symbol == ')'){
				String op= operators.pop();
				if(op.equals("+")){digits.push(digits.pop()+digits.pop());}
				else if(op.equals("*")){digits.push(digits.pop()*digits.pop());}
			}else{
				digits.push(Double.parseDouble(symbol+""));
			}
		}
		System.out.println(digits.pop());
		sc.close();
	}
}
