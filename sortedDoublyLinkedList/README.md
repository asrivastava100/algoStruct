# Sorted Doubly Linked List

A doubly linked list consists of a list of 'items' each of which contains:
1. A value e.g. 5
2. A pointer to the previous item
3. A pointer to the next item

In addition, we impose the requirement that the linked list should be sorted in ascending order from left to right. 

One main benefit of having a sorted doubly linked list is that we can access the maximum and minimum elements in constant time. This is because these elements occur at the start and end of the list, respectively.

### Sorted Doubly Linked List API (Implemented in SortedDoublyLinkedList.java)

This implementation offers the following functions:

1. Insert - inserts an element while keeping the list sorted.
2. Delete - deletes all instances of the user specified value e.g. ls.delete(4) will delete all instances of 4 in the list. 
3. toString - prints the linked list from left to right.
4. reverseString = prints the linked list from right to left.


### Some running time analysis. 

Both insert and delete methods have a worst case running time of O(n) where n is the number of elements in the list. 

Why? This is because of the sorting requirement. To insert a particular element, we have to search the list to find the correct place for the element. This may potentially be after the end of the list (meaning that we have traversed the entire list). To delete a particular element, we first have to find it. In the worst case, the element may not be in the list and we would have to traverse the entire list to find this out.

We could optimise the delete operation such that we only need to traverse at most 1/2 the nodes in the list. We can roughly estimate the value of the middle element by calculating an indicator value = (first.value + last.value) / 2. If the value we would like to delete is greater than the indicator value, we should start our search from the tail of the list. If this is not the case, we should start our search from the first element of the list. This would however, still leave the time complexity of the delete method to be O(n) (since we ignore constants).
