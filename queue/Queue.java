
// Queue implementation

// This implementation follows the FIFO rule.

// Usage java queue 1 2 3 4 -1 5 0
// The user enters a list of numbers just like in the example above.
// Values greater than 0 will be added to the queue (enqueue). 
// If the value is -1, we remove the first element (dequeue). 
// If value = 0, we will print the queue.


public class Queue<T>{
    
    private Item first = null;
    private Item last = first;

    // Queue item
    
    private class Item{
        T value;
        Item next;
    }

    public void enqueue(T x){
        if(first == null){
            first = new Item();
            first.value = x;
            first.next = null;
            last = first;
        } else {
            last.next = new Item();
            last.next.value = x;
            last.next.next = null;
            last = last.next;
        }
    }

    public T dequeue(){
        if(first == null){
            throw new NullPointerException("Queue is empty");
        }

        T valToRemove = first.value;
        first = first.next; 
        return valToRemove;
    }


    public String toString(){
        Item current = first;
        String returnString = "[ ";
        while(current != null){
            returnString += (current.value + " ");
            current = current.next;
        }
        return returnString + "]";
    }

    // main method tests the queue implementation. It assumes an integer based queue. 

    public static void main(String[] args){
        if(args.length == 0){
            return;
        }

        Queue<Integer> testQueue = new Queue<Integer>();

        for(int i = 0; i < args.length; i++){
            if(Integer.parseInt(args[i]) == -1){
                int valRemoved = testQueue.dequeue();
                System.out.println("dequeue " + valRemoved);
            } else if(Integer.parseInt(args[i]) == 0){
                System.out.println(testQueue);
            } else{
                System.out.println("enqueue " + args[i]);
                testQueue.enqueue(Integer.parseInt(args[i]));
            }
        } 
    }
}



/*

Sample program run

java Queue 1 2 3 4 5 -1 6 7 -1 -1 -1 8 9 10 0 11 -1 0
enqueue 1
enqueue 2
enqueue 3
enqueue 4
enqueue 5
dequeue 1
enqueue 6
enqueue 7
dequeue 2
dequeue 3
dequeue 4
enqueue 8
enqueue 9
enqueue 10
[ 5 6 7 8 9 10 ]
enqueue 11
dequeue 5
[ 6 7 8 9 10 11 ]

*/