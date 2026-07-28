# LJAJAG27

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Arithmetic Operations

Write a menu driven program to perform simple arithmetic operations based on the user's choice. The user will indicate the operation to be performed using the signs e.g. + for addition etc.

### Input Format

In first line take the operator as input.
In second line take two integer numbers as input.

You should take input for operators among these (+, -, *, /, %).

### Sample 1:
Input
Output

```
+
1 2
```

```
3
```

### Sample 2:
Input
Output

```
-
9 4
```

```
5
```

### Sample 3:
Input
Output

```
^
10 2
```

```
Invalid operator! Please use one of the following: +, -, *, /, %
```

### Sample 4:
Input
Output

```
/
10 0
```

```
Error: Division by zero is not allowed.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-28T00:18:25.853Z  

```java
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

```

---

[View on CodeChef](https://www.codechef.com/problems/LJAJAG27)