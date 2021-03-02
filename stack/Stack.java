public class Stack<T>{

    private Item top = null;
    private int size = 0;

    private class Item{
        T value;
        Item next;

    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        }

        return false;
    }

    public void push(T x){
        Item p = new Item();
        p.value = x;
        p.next = top;
        top = p;
        size++;
    }

    public T pop() {
        if(this.isEmpty()){
            throw new NullPointerException("Stack is empty");
        }

        T x = top.value;
        top = top.next;
        size--;
        return x;

    }

    public T peek(){
        if(this.isEmpty()){
            throw new NullPointerException("Stack is empty");
        }

        return top.value;
    }

    public int length(){
        return size;
    }

    public String toString(){
        
        System.out.println("Stack: ");
        System.out.println("");
        
        Item current = top;
        String result =  "";
        
        for(int i = 0; i < size - 1; i++){
            result += current.value;
            result += " -> ";
            current = current.next;
        }
        
        result += current.value;

        return result;

    }

    // main method tests the stack class methods above.

    public static void main(String[] args){
        
        Stack<Integer> myStack = new Stack<Integer>();
        
        System.out.println("The size of the stack is: " + myStack.length());
        System.out.println("");

        int numElements = 30;
        
        for(int i = 0; i < numElements; i++){
            myStack.push(i);
            System.out.println(i + " pushed onto stack");
        }

        System.out.println("");
        System.out.println("The size of the stack is: " + myStack.length());
        System.out.println("");
        System.out.println(myStack.toString());
        System.out.println("");


        for(int j = 0; j < 5; j++){
            int elem = myStack.pop();
            System.out.println(elem + " popped from the stack");

        }

        System.out.println("");
        System.out.println("The size of the stack is: " + myStack.length());
        System.out.println("");        
        System.out.println(myStack.toString());
        System.out.println("");
        System.out.println("Testing peek: " + myStack.peek());
        System.out.println("");
    }
}

/*

Sample program run:

The size of the stack is: 0

0 pushed onto stack
1 pushed onto stack
2 pushed onto stack
3 pushed onto stack
4 pushed onto stack
5 pushed onto stack
6 pushed onto stack
7 pushed onto stack
8 pushed onto stack
9 pushed onto stack
10 pushed onto stack
11 pushed onto stack
12 pushed onto stack
13 pushed onto stack
14 pushed onto stack
15 pushed onto stack
16 pushed onto stack
17 pushed onto stack
18 pushed onto stack
19 pushed onto stack
20 pushed onto stack
21 pushed onto stack
22 pushed onto stack
23 pushed onto stack
24 pushed onto stack
25 pushed onto stack
26 pushed onto stack
27 pushed onto stack
28 pushed onto stack
29 pushed onto stack

The size of the stack is: 30

Stack: 

29 -> 28 -> 27 -> 26 -> 25 -> 24 -> 23 -> 22 -> 21 -> 20 -> 19 -> 18 -> 17 -> 16 
-> 15 -> 14 -> 13 -> 12 -> 11 -> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0

29 popped from the stack
28 popped from the stack
27 popped from the stack
26 popped from the stack
25 popped from the stack

The size of the stack is: 25

Stack: 

24 -> 23 -> 22 -> 21 -> 20 -> 19 -> 18 -> 17 -> 16 -> 15 -> 14 -> 13 -> 12 -> 11 
-> 10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0

Testing peek: 24

*/