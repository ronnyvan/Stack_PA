import java.util.Stack;

public class Stack_PA {
   /************************ to be solved ***********************/

   /*
    * @param stack - is a stack of Integer values
    * 
    * precondition - stack contains at least two elements
    * 
    * postcondition - returns the sum of the all the integers within the stack
    * without changing the original stack
    */
   public static int sumStack(Stack<Integer> stack) {
      int sum = 0;
      Stack<Integer> tempStack = new Stack<>();
      while (!stack.isEmpty()) {
         tempStack.push(stack.pop());
         sum += tempStack.peek();
      }
      while (!tempStack.isEmpty())
         stack.push(tempStack.pop());
      return sum;
   }

   /*
    * @param stack - is a stack of Integer values
    * 
    * @param odd - is an empty stack
    * 
    * @param even - is an empty stack
    * 
    * precondition - no preconditions
    * 
    * postcondition - Removes each element from stack and places it in either
    * the odd stack or the even stack based on the element
    * stack will be empty at the end of the call
    */
   public static boolean isEven(int x) {
      return x % 2 == 0;
   }

   public static void splitStack(Stack<Integer> stack, Stack<Integer> odd, Stack<Integer> even) {
      while (!stack.isEmpty()) {
         int currInt = stack.pop();
         if (isEven(currInt))
            even.push(currInt);
         else
            odd.push(currInt);
      }
   }

   /*
    * @param stack - is a stack of Integer values
    * 
    * precondition - no preconditions
    * 
    * postcondition - Removes all duplicates in a stack and leaves the
    * stack in the same relative order
    * Example:
    * original stack ==> [4, 6, 7, 4, 2, 7]
    * final stack ==> [4, 6, 7, 2]
    */
   public static int removeDuplicates(Stack<Integer> stacks) {
      Stack<Integer> tempStack = new Stack<>();
      Stack<Integer> reversedStack = new Stack<>();
      int dupeCount = 0;

      // reverses the stack, maintaining a LIFO order
      // so if there are dupes, the dupe closest to the top of the original stack 
      // is removed
      //original stack is now empty
      while(!stacks.isEmpty()) reversedStack.push(stacks.pop());
      
      //goes one-by-one in the reversed stack
      while (!reversedStack.isEmpty()) {
         int currInt = reversedStack.pop();
         //adds (currInt) to original stack
         stacks.push(currInt);

         while(!reversedStack.isEmpty()){
            //checks every subsequent int afterwards
            int nextInt = reversedStack.pop();
            tempStack.push(nextInt);

            if(nextInt == currInt){
               //disregards that int since it is a dupe
               tempStack.pop();
               dupeCount++;
            }

         }
         //after while loop above, every dupe of (currInt) after (currInt) is guaranteed to not be in tempStack
         //so (currInt) is unique and we can move on to the next (int)

         //adds back to reversedStack for another iteration
         while(!tempStack.isEmpty()) reversedStack.push(tempStack.pop());

         //iterates back to check the (int) that was after (or below) the current (currInt)
         //in respect to reversedStack
   }
   return dupeCount;
}

   /*
    * @param stack - is a stack of Integer values
    * 
    * @param element - value of the element to be removed
    * 
    * precondition - no precodition
    * 
    * postcondition - Removes the first occurrence of a specific element from a
    * stack, leaving
    * the other elements in the stack in the same relative order
    */
   public static void removeFirstOccurrence(Stack<Integer> stack, int element) {
      int count = 0;
      Stack<Integer> tempStack = new Stack<>();
      while (!stack.isEmpty()) {
         tempStack.push(stack.pop());
      }
      while (!tempStack.isEmpty()) {
         int currInt = tempStack.peek();
         if (currInt == element && count != 1) {
            tempStack.pop();
            count++;
         } else
            stack.push(tempStack.pop());
      }
   }

   /*
    * @param stack - is a stack of String values
    * 
    * @param element - value of the element to be removed
    * 
    * precondition - no precodition
    * 
    * postcondition - Removes all occurrances of a specific element from a stack,
    * leaving
    * the other elements in the stack in the same relative order
    */
   public static void removeAllOccurrences(Stack<String> stack, String element) {
      Stack<String> tempStack = new Stack<>();
      while (!stack.isEmpty()) {
         tempStack.push(stack.pop());
      }
      while (!tempStack.isEmpty()) {
         String currString = tempStack.peek();
         if (currString.equals(element))
            tempStack.pop();
         else
            stack.push(tempStack.pop());
      }
   }

   /****************** Testing **********************************/
   public static void main(String[] args) {
      System.out.println("********** Sum Stack Output *********");
      // Creating a Stack
      Stack<Integer> numbers = new Stack<Integer>();
      // Pushing new items to the Stack
      numbers.push(15);
      numbers.push(3);
      numbers.push(9);
      numbers.push(-2);
      numbers.push(10);
      // display stack
      System.out.println("Stack => " + numbers);
      System.out.println();
      // sum up stack values and display
      int sum = sumStack(numbers);
      System.out.println("Sum of the numbers in the Stack => " + sum);
      System.out.println("Stack => " + numbers);
      System.out.println();

      System.out.println("********** Even and Odd Stack Output *********");
      // Creating a Stack
      Stack<Integer> list = new Stack<Integer>();
      Stack<Integer> odd = new Stack<Integer>();
      Stack<Integer> even = new Stack<Integer>();

      // Pushing random elements on the Stack
      for (int i = 0; i <= 25; i++) {
         list.push((int) (Math.random()*10));
      }
      
      // list.push((int)(Math.random() * 100) + 1);

      // display stack
      System.out.println("Stack => " + list);
      System.out.println();

      // splitStack into odd andd even
      splitStack(list, odd, even);
      System.out.println("Stack => " + list);
      System.out.println("Odd => " + odd);
      System.out.println("Even => " + even);
      System.out.println();

      System.out.println("********** Remove Duplicate Stack Output *********");
      // removes duplicates from odd and even
      System.out.println("Number duplicates in Odd => " + removeDuplicates(odd));
      System.out.println("Odd => " + odd);
      System.out.println("Number duplicates in even => " + removeDuplicates(even));
      System.out.println("Even => " + even);
      System.out.println();

      System.out.println("********** Remove First Occurrence Stack Output *********");
      // Creating a Stack
      list = new Stack<Integer>();

      // Pushing new items to the Stack
      list.push(5);
      list.push(3);
      list.push(9);
      list.push(2);
      list.push(3);
      list.push(8);
      list.push(4);

      // display stack
      System.out.println("Stack => " + list);
      System.out.println();

      // remove specific elements from stack and display
      removeFirstOccurrence(list, 9);
      System.out.println("Element 9 removed - Stack => " + list);
      removeFirstOccurrence(list, 1);
      System.out.println("Element 1 removed - Stack => " + list);
      removeFirstOccurrence(list, 3);
      System.out.println("Element 3 removed - Stack => " + list);
      System.out.println();

      System.out.println("Remove All Occurrence Stack Output");

      // Creating a Stack
      Stack<String> list2 = new Stack<String>();

      // Pushing new items to the Stack
      list2.push("C");
      list2.push("F");
      list2.push("Q");
      list2.push("C");
      list2.push("B");
      list2.push("A");
      list2.push("C");

      // display stack
      System.out.println("Stack => " + list2);
      System.out.println();

      // remove specific elements from stack and display
      removeAllOccurrences(list2, "A");
      System.out.println("Element \"A\" removed - Stack => " + list2);
      removeAllOccurrences(list2, "Q");
      System.out.println("Element \"Q\" removed - Stack => " + list2);
      removeAllOccurrences(list2, "C");
      System.out.println("Element \"C\" removed - Stack => " + list2);
      System.out.println();

   }
}
