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

### What are some of the other ways to implement a stack?

In some programming languages (e.g. Python), it is possible to implement a stack through the in-built List object. 

Taking Python as an example, we can do something like this:

myStack = [] --- Initialise an empty stack.

myStack.append(3) --- State of stack is [3] --- This is the __push__ method.

myStack.append(4) --- State of stack is [3, 4]

myStack[-1]  --- returns the value 4. --- This is the __peek__ method.

myStack.pop() --- State of stack is [3] -- This is the __pop__ method.

len(myStack) --- returns 0 since no elements in the stack at present -- This is the __length__ method.

        
