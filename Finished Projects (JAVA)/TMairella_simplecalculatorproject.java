import java.util.*; 
public class TMairella_simplecalculatorproject{ 
    public static void main(String[] args) {
        int num1;
        int num2;
        
        Scanner input = new Scanner(System.in);  
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.println("Hello " + name + " :D"); 

        Scanner num = new Scanner(System.in);
        System.out.print("Enter first number: ");
        num1 = num.nextInt();
        System.out.print("Enter second number (Put 0 if √): ");
        num2 = num.nextInt();

        Scanner op = new Scanner(System.in);
        System.out.print("Enter Operation (+,-,*,/,^,(√)): ");
        String operation = op.next();

        if (operation.equals("+"))  {
            System.out.println("Your answer is: " + (num1 + num2));
        }
        if (operation.equals("-")) {
            System.out.println("Your answer is: " + (num1 - num2));
        }
        if (operation.equals("*")) {
            System.out.println("Your answer is: " + (num1 * num2));
        }
        if (operation.equals("/")) {
            System.out.println("Your answer is: " + (num1 / num2));
        }
        if (operation.equals("^")) {
            System.out.println("Your answer is: " + Math.pow(num1, num2));
        }
        if (operation.equals("√")) {
            System.out.println("Your answer is: " + Math.sqrt(num1));
        }
        input.close();
        num.close();
        op.close();
    }
} 