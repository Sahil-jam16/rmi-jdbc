Hello World using Java Programming
public class MyFirstJavaProgram {

   /* This is my first java program.
    * This will print 'Hello World' as the output
    */

   public static void main(String []args) {
      System.out.println("Hello World"); // prints Hello World
   }
}

class FreshJuice {
   enum FreshJuiceSize{ SMALL, MEDIUM, LARGE }
   FreshJuiceSize size;
}

public class FreshJuiceTest {

   public static void main(String args[]) {
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.MEDIUM ;
      System.out.println("Size: " + juice.size);
   }
}
Java Variables Types

int a, b, c;         // Declares three ints, a, b, and c.
int a = 10, b = 10;  // Example of initialization
byte B = 22;         // initializes a byte type variable B.
double pi = 3.14159; // declares and assigns a value of PI.
char a = 'a';        // the char variable a iis initialized with value 

public class Test {
   public void pupAge() {
      int age = 0;
      age = age + 7;
      System.out.println("Puppy age is : " + age);
   }

   public static void main(String args[]) {
      Test test = new Test();
      test.pupAge();
   }
}

public class Test {
   public void pupAge() {
      int age;
      age = age + 7;
      System.out.println("Puppy age is : " + age);
   }

   public static void main(String args[]) {
      Test test = new Test();
      test.pupAge();
   }
}

import java.io.*;

public class Employee {

   // this instance variable is visible for any child class.
   public String name;

   // salary  variable is visible in Employee class only.
   private double salary;

   // The name variable is assigned in the constructor.
   public Employee (String empName) {
      name = empName;
   }

   // The salary variable is assigned a value.
   public void setSalary(double empSal) {
      salary = empSal;
   }

   // This method prints the employee details.
   public void printEmp() {
      System.out.println("name  : " + name );
      System.out.println("salary :" + salary);
   }

   public static void main(String args[]) {
      Employee empOne = new Employee("Ransika");
      empOne.setSalary(1000);
      empOne.printEmp();
   }
}

public class Test {

   public static void main(String args[]) {
      int x = 30;

      if( x < 20 ) {
         System.out.print("This is if statement");
      }else {
         System.out.print("This is else statement");
      }
   }
}


public class Test {

   public static void main(String args[]) {
      int x = 30;

      if( x == 10 ) {
         System.out.print("Value of X is 10");
      }else if( x == 20 ) {
         System.out.print("Value of X is 20");
      }else if( x == 30 ) {
         System.out.print("Value of X is 30");
      }else {
         System.out.print("This is else statement");
      }
   }
}

public class Test {

   public static void main(String args[]) {
      char grade = 'C';

      switch(grade) {
         case 'A' :
            System.out.println("Excellent!"); 
            break;
         case 'B' :
         case 'C' :
            System.out.println("Well done");
            break;
         case 'D' :
            System.out.println("You passed");
         case 'F' :
            System.out.println("Better try again");
            break;
         default :
            System.out.println("Invalid grade");
      }
      System.out.println("Your grade is " + grade);
   }
}

public class Test {

   public static void main(String args[]) {
      String grade = "C";

      switch(grade) {
         case "A" :
            System.out.println("Excellent!"); 
            break;
         case "B" :
         case "C" :
            System.out.println("Well done");
            break;
         case "D" :
            System.out.println("You passed");
         case "F" :
            System.out.println("Better try again");
            break;
         default :
            System.out.println("Invalid grade");
      }
      System.out.println("Your grade is " + grade);
   }
}

loops
public class Test {

   public static void main(String args[]) {

      for(int x = 10; x < 20; x = x + 1) {
         System.out.print("value of x : " + x );
         System.out.print("\n");
      }
   }
}

public class Test {

   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};

      for(int index = 0; index < numbers.length; index++) {
         System.out.print("value of item : " + numbers[index] );
         System.out.print("\n");
      }
   }
}

public class Test {

   public static void main(String args[]) {
      int x = 10;

      for( ;; ) {
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }
   }
}


public class Main {
  public static void main(String[] args) {
    // Implementing nested for loop
    // Initializing loop counters 
    int num = 1;
    int i = 1;

    // outer for loop
    for (num = 1; num <= 10; num++) {
      //inner for loop
      System.out.print("Table of " + num + " is : ");
      for (i = 1; i <= 10; i++) {
        // printing table
        System.out.print(num * i + " ");
      }
      // printing a new line
      System.out.println();
    }
  }
}


import java.util.Arrays;
import java.util.List;

public class Test {

   public static void main(String args[]) {
      List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

      for(Integer x : numbers ) {
         System.out.print( x );
         System.out.print(",");
      }
   }
}


public class Test {

   public static void main(String args[]) {
      Student[] students = { new Student(1, "Julie"), new Student(3, "Adam"), new Student(2, "Robert") };

      for( Students student : students ) {
         System.out.print( student );
         System.out.print(",");
      }
   }
}
class Student {
   int rollNo;
   String name;

   Student(int rollNo, String name){
      this.rollNo = rollNo;
      this.name = name;
   }

   @Override
   public String toString() {
      return "[ " + this.rollNo + ", " + this.name + " ]";
   }
}


public class Test {

   public static void main(String args[]) {
      int x = 10;

      while( x < 20 ) {
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }
   }
}


public class Test {

   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};
      int index = 0;

      while( index < 5 ) {
         System.out.print("value of item : " + numbers[index] );
         index++;
         System.out.print("\n");
      }
   }
}


public class Test {

   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};
      int index = 0;

      do {
         System.out.print("value of item : " + numbers[index] );
         index++;
         System.out.print("\n");
      } while( index < 5 );
   }
}


public class Test {

   public static void main(String args[]) {
      int x = 10;

      do {
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      } while( true );
   }
}


public class Test {

   public static void main(String args[]) {
      int x = 10;

      while( x < 20 ) {
         if(x == 15){
            break;		 
         }	     
         System.out.print("value of x : " + x );
         x++;
         System.out.print("\n");
      }
   }
}


int i = 5000;
float gpa = 13.65f;
double mask = 125;

public class Test {

   public static void main(String args[]) {
      Integer x = 5; // boxes int to an Integer object
      x =  x + 10;   // unboxes the Integer to a int
      System.out.println(x); 
   }
}

Sr.No.	Method & Description
1	
byteValue()

This method returns the value of the specified number as a byte.

2	
doubleValue()

This method returns the value of the specified number as a double.

3	
floatValue()

This method returns the value of the specified number as a float.

4	
intValue()

This method returns the value of the specified number as a int.

5	
longValue()

This method returns the value of the specified number as a long.

6	compareTo()
Compares this Number object to the argument.

7	equals()
Determines whether this number object is equal to the argument.

8	valueOf()
Returns an Integer object holding the value of the specified primitive.

9	toString()
Returns a String object representing the value of a specified number.

10	parseInt()
This method is used to get the primitive data type of a certain String.

11	abs()
Returns the absolute value of the argument.

12	ceil()
Returns the smallest integer that is greater than or equal to the argument. Returned as a double.

13	floor()
Returns the largest integer that is less than or equal to the argument. Returned as a double.

14	rint()
Returns the integer that is closest in value to the argument. Returned as a double.

15	round()
Returns the closest long or int, as indicated by the method's return type to the argument.

16	min()
Returns the smaller of the two arguments.

17	max()
Returns the larger of the two arguments.

18	exp()
Returns the base of the natural logarithms, e, to the power of the argument.

19	log()
Returns the natural logarithm of the argument.

20	pow()
Returns the value of the first argument raised to the power of the second argument.

21	sqrt()
Returns the square root of the argument.

22	sin()
Returns the sine of the specified double value.

23	cos()
Returns the cosine of the specified double value.

24	tan()
Returns the tangent of the specified double value.

25	asin()
Returns the arcsine of the specified double value.

26	acos()
Returns the arccosine of the specified double value.

27	atan()
Returns the arctangent of the specified double value.

28	atan2()
Converts rectangular coordinates (x, y) to polar coordinate (r, theta) and returns theta.

29	toDegrees()
Converts the argument to degrees.

30	toRadians()
Converts the argument to radians.

31	random()
Returns a random number.


char ch = 'a';

// Unicode for uppercase Greek omega character
char uniChar = '\u039A'; 

// an array of chars
char[] charArray ={ 'a', 'b', 'c', 'd', 'e' }; 

public class TestArray {

   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};

      // Print all the array elements
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
     
      // Summing all elements
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("Total is " + total);
      
      // Finding the largest element
      double max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) max = myList[i];
      }
      System.out.println("Max is " + max);  
   }
}

public class TestArray {

   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};

      // Print all the array elements
      for (double element: myList) {
         System.out.println(element);
      }
   }
}

// Creating a Java class
class Dog {
  // Declaring and initializing the attributes
  String breed;
  int age;
  String color;

  // methods to set breed, age, and color of the dog
  public void setBreed(String breed) {
    this.breed = breed;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public void setColor(String color) {
    this.color = color;
  }

  // method to print all three values
  public void printDetails() {
    System.out.println("Dog detials:");
    System.out.println(this.breed);
    System.out.println(this.age);
    System.out.println(this.color);
  }
} 	

public class Puppy {
   int puppyAge;

   public Puppy(String name) {
      // This constructor has one parameter, <i>name</i>.
      System.out.println("Name chosen is :" + name );
   }

   public void setAge( int age ) {
      puppyAge = age;
   }

   public int getAge( ) {
      System.out.println("Puppy's age is :" + puppyAge );
      return puppyAge;
   }

   public static void main(String []args) {
      /* Object creation */
      Puppy myPuppy = new Puppy( "tommy" );

      /* Call class method to set puppy's age */
      myPuppy.setAge( 2 );

      /* Call another class method to get puppy's age */
      myPuppy.getAge( );

      /* You can access instance variable as follows as well */
      System.out.println("Variable Value :" + myPuppy.puppyAge );
   }
}