
// sorted doubly linked list class
// usage: java SortedDoublyLinkedList 1 2 3 0 -3 0 2 5 3 4 -2 0
// The user enters a list of numbers just like in the example above.
// Values greater than 0 will be inserted into the linked list. 
// For values less than zero, all instance of the number (excl. sign) 
// will be deleted from the list. e.g -3 means all instances of 3 will be deleted
// a zero will print the linked list in order as well as in reverse order (on the next line).

class SortedDoublyLinkedList{
    
    private Item start = null;
    private Item last = null;

    // Doubly linked list item
    
    private class Item{
        int value;
        Item next;
        Item prev;
    }

    public void insert(int x){
        if(start == null){
            start = new Item();
            start.value = x;
            start.next = null;
            start.prev = null;
            last = start;
        } else{
            Item current = start;
            
            while(current.value < x && current != last){
                current = current.next;
            }

            if(current == start && current.value >= x){
                start.prev = new Item();
                start.prev.value = x;
                start.prev.next = current;
                start = start.prev; 
                return;
            }
            
            if(current == last && current.value < x){
                current.next = new Item();
                current.next.value = x;
                current.next.prev = current;
                current.next.next = null;
                last = current.next;
                return;
            }

            Item p = new Item();
            p.value = x;
            p.prev = current.prev;
            current.prev.next = p;
            p.next = current;
            current.prev = p;
        }
    }

    // delete method deletes all instances of the value x in the linked list.

    public void delete(int x){
        if(start == null){
            return;
        }

        if(start == last && start.value == x){
            start = null;
            last = null;
            return;
        }

        Item current = start;
        int midIndexVal = (start.value + last.value) / 2;

        if(x > midIndexVal){
            current = last;
            while(current != null && current.value != x){
                current = current.prev;
            }
        } else{
            while(current != null && current.value != x){
                current = current.next;
            }
        }

        if(current == null){
            return;
        }

        if(current == start){
            start = current.next;
            start.prev = null;
            if(start.value == x){
                this.delete(x);
            }
            return;
        }

        if(current == last){
            current.prev.next = null;
            last = current.prev;
            if(last.value == x){
                this.delete(x);
            }
            return;
        }

        current.next.prev = current.prev;
        current.prev.next = current.next;
        if(current.prev.value == x || current.next.value == x){
            this.delete(x);
        } 
        
    }

    public String toString(){
        String returnString = "[ ";
        Item current = start;
        while(current != null){
            returnString += (current.value + " ");
            current = current.next;
        }
        return returnString + "]";
    }

    public String reverseString(){
        String returnString = "[ ";
        Item current = last;
        while(current != null){
            returnString += (current.value + " ");
            current = current.prev;
        }
        return returnString + "]";
    }

    // main method tests sorted doubly linked list implementation.

    public static void main(String[] args){
        if(args.length == 0){
            return;
        }
        
        SortedDoublyLinkedList testList = new SortedDoublyLinkedList();
        
        for(int i = 0; i < args.length; i++){
            int current = Integer.parseInt(args[i]);
            if(current < 0){
                testList.delete(-current);
            } else if(current == 0){
                System.out.println(testList);
                System.out.println(testList.reverseString());
            } else{
                testList.insert(current);
            }
            
        }

    }

}


/*

sample program run 1

java SortedDoublyLinkedList 1 2 3 0 -3 0 2 5 3 4 -2 0
[ 1 2 3 ]
[ 3 2 1 ]
[ 1 2 ]
[ 2 1 ]
[ 1 3 4 5 ]
[ 5 4 3 1 ]

sample program run 2

java SortedDoublyLinkedList 1 2 3 0 3 0 2 5 3 4 2 0
[ 1 2 3 ]
[ 3 2 1 ]
[ 1 2 3 3 ]
[ 3 3 2 1 ]
[ 1 2 2 2 3 3 3 4 5 ]
[ 5 4 3 3 3 2 2 2 1 ]

*/