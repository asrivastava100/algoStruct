# Stacks

A stack is a __LIFO__ (Last in First Out) data structure. The best way to visualise a stack is to imagine a stack of books sitting on a table.

For stacks, we assume that it is only possible to add a book to the top of the stack and remove a book from the top of the stack. 

Some common terms that are associated with stacks:

1. If there are no books, we say the stack __is empty__. 
2. If we would like to put a book on the stack, we say that we __push__ the book onto the stack.
3. If we would like to remove the top book, we say that we __pop__ the book off the stack.
4. If we would like to see what book is at the top, we can __peek__.

### Some running time analysis for stack operations.

The __push__, __pop__, and __peek__ operations are constant time operations (__O(1)__).

In addition to the methods above, some stack implementations give access to __length__ and __isEmpty__ methods. 
Both operations are constant time operations (__O(1)__). 

Why are all these operations constant time?

This is because the __push__, __pop__, and __peek__ only deal with the top most element of the stack. The __length__ method returns 
the value of the static variable size within the class. This is a constant time method. The __isEmpty__ method only checks if the top
most element is null. This is also a constant time operation.

### The API for Stack (implemented in Stack.java)

This implementation offers the following methods:

1. push
2. pop
3. length
4. isEmpty
5. toString
6. peek

### What are some of the other ways to implement a stack?

In some programming languages (e.g. Python), it is possible to implement a stack through the in-built List object. 

Taking Python as an example, we can do something like this:

myStack = [] --- Initialise an empty stack.

myStack.append(3) --- State of stack is [3] --- This is the __push__ method.

myStack.append(4) --- State of stack is [3, 4]

myStack[-1]  --- returns the value 4. --- This is the __peek__ method.

myStack.pop() --- State of stack is [3] -- This is the __pop__ method.

len(myStack) --- returns 1 since only one element in the stack at present -- This is the __length__ method.

### The balanced bracket problem.

I have included an example of where stacks can be used. This can be seen in the file Brackets.java.

This program uses a stack to tell us whether a given expression e.g. "if((a && b) && c))" is valid or not. In this case the program will return invalid since
there is an extra closing bracket. 

The reader is welcome to see the implementation of the program in the file Brackets.java. 

### Depth First Search and Stack

Another interesting use of stacks is within the depth first search algorithm. The stack is used to store graph vertices that 
we are going to visit during the course of the algorithm.

To see this, please feel free to visit my pathVision project at https://github.com/asrivastava100/pathVision. The DFS implementation is within the pathFinder.js
file which is part of the public folder.
        
