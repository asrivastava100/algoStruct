# Queue

A queue is a __FIFO__ (First in First Out) data structure. Queues operate in the same way as they do in the real world. For example, we take the example of a shop with one till. Customers can join the queue (enqueue) as well as leave the queue (dequeue) once they have collected and paid for their shopping. 

For this queue implementation, we assume that it is only possible to remove an element from the front of the queue and add an element to the back of the queue. 

Some common terms that are associated with a queue:

1. If we would like to add an element to the queue (e.g. a customer joining the queue), we say that we __enqueue__ the element.
2. If we would like to remove the first element (e.g. the customer currently being served), we say that we __dequeue__ the element.

### Some running time analysis for stack operations.

Both __enqueue__ and __dequeue__  operations are constant time operations (__O(1)__).

Why are these operations constant time?

This is because the __enqueue__ and __dequeue__ methods only deal with the first and last elements of the queue. 

### The API for Queue (implemented in Queue.java)

This implementation offers the following methods:

1. enqueue
2. dequeue
3. toString

### Breadth First Search and Queues

An interesting use of queues is within the breadth first search algorithm. The queue is used to store neighbour graph vertices that 
we are going to visit during the course of the algorithm.

To see this, please feel free to visit my pathVision project at https://github.com/asrivastava100/pathVision. The BFS implementation is within the pathFinder.js
file which is part of the public folder.
        

