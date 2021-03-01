# Binary Search Algorithm

Binary Search tries to find some target value within a given array. The array should be __sorted__ before the algorithm is run. 

The basic idea of Binary Search is that the section of the array where the entry is searched is halved at each iteration.

Let us say we have a sorted array __x__ with integer entries x[0], x[1], ... x[n-1]. We would like to check if this array contains the target value.

At each iteration we calculate the middle index = (start_idx + end_idx) / 2.

For the first iteration middle = (n - 1 + 0) / 2 = (n - 1) / 2. We take the integer part of this value and check x[middle] == target. 
If it is, return middle (this is the index at which we have the target value in the array)

If x[middle] > target, we can ignore the the right half of the array and call the binary search method on the left half of the array.

If x[middle] < target, we can ignore the left half of the array and call the binary search method on the right half of the array.

This process continues recursively until the target value is found. If the target value is not in the array, then we will arrive at the base case.
This is the point where the start index > end index. At this point the recursive method can terminate by returning some value (e.g -1).

In this program, we have adapted the binary search method a little. This method is called __binSearch.__ 

binSearch searches for the integer key among the entires x[i], ..., x[j-1] using binary search. The return of the method is the smallest 
array idx k such that x[k] == key, if key in array. Otherwise return idx k such that the assignment x[k] = key would still keep the
array sorted (if current elements x[k],...x[j-1] are shifted up to x[k+1], ..., x[j]).

In this case the base case will return the idx k at which the target value should be in order to keep the array sorted. 

The class also contains an insert method which takes a key and an array as arguments. It then creates a new array and makes use of the binSearch 
method to find the right index for the key value. All other values are copied over to the new array. The method returns the new array. 

### Some worst case running time analysis.

Suppose we have an array of size n and the target value is smaller than the first element of the array. We would calculate the middle index value and 
carry out a comparison step. We would then look at one half of the array. We continue the process until it terminates at the base case (start idx > end idx). 
The number of steps we take is a number k such that:

2^k = n

k = log to base 2 of n

Generally given n integers, we carry out log to base 2 of n comparisons.

In terms of worst case running time, we have O(log(n)) for binary search.

### Binary search and sorted array assumption.

We need the array to be sorted for binary search however, most arrays maybe unsorted before we decide to run binary search. In such cases we would need to make use of a sorting algorithm to sort the array first.

Algorithms such as Merge Sort can sort an array in O(nlogn) time however, other algorithms such as Bubble Sort take O(n^2) time. It is important to choose a good sorting algorithm.


