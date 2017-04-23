package lesson_01;

// You can use this program to run experiments
// 1. Add statements inside main
// 2. Compile 
// 3. Right-click on the Test rectangle and select main
// 4. Click Ok on the next dialog
// 5. The output is displayed in a terminal window

public class HelloWorld
{
    public static void main(String[] args)
    {
        // Add something inside the ( )
        System.out.println("Hello");
        System.out.println("World");
        // Add more statements below, as needed
        System.out.println(3+4+5);
        System.out.println("3+4+5");
        //
        System.out.print(3);
        System.out.println(4+5);
        //
        System.out.print("My lucky number is");
        System.out.println(3+4+5);
        //
        double cost = 0;
        double item1 = 1.00;
        double tip1 = item1 * 0.18;
        double tax1 = item1 * 0.08;
        cost = cost + item1 + tip1 + tax1;
        double item2 = 10.00;
        double tax2 = item2 * 0.08;
        double tip2 = item2 * 0.18;
        cost = cost + item2 + tip2 + tax2;
        System.out.println(cost);
    }
}
