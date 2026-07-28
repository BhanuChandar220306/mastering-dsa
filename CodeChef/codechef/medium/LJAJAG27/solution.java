import java.util.*;
class Codechef
{
	public static void main (String[] args) 
	{
		// your code goes here
        Scanner sc=new Scanner(System.in);
        String op=sc.next();
        int a=sc.nextInt();
        int b=sc.nextInt();
        switch(op)
        {
            case "+":
                System.out.println(a+b);
                break;
            case "-":
                System.out.println(a-b);
                break;
            case "*":
                System.out.println(a*b);
                break;
            case "/":
                if(b==0)
                    System.out.println("Error: Division by zero is not allowed.");
                else
                    System.out.println(a/b);
                break;
            case "%":
                if(b==0)
                    System.out.println("Error: Division by zero is not allowed.");
                else
                    System.out.println(a%b);
                break;
            default:
                System.out.println("Invalid operator! Please use one of the following: +, -, *, /, %");
        }
	}
}
