# This code uses the heap module in the current folder and uses it to sort an array using the heap sort algorithm. 
# Two setting are available: In place sorting and returning a new sorted array.

from heap import heap

def heap_sort(array,sort_array_in_place = 0):
    '''sorts an array using heap sort. Returns a new array by default. To sort in place, set array_in_place to 1'''
    temp_heap = heap(len(array))
    temp_heap.build_heap(array)
    if not sort_array_in_place:
        return [temp_heap.remove_min() for i in range(len(array))]

    for i in range(len(array)):
        array[i] = temp_heap.remove_min()

def test_heap_sort():
    a = [45,21,7,8,3,4,1,3]

    print("In place sorting:")
    print("unsorted array", a)
    heap_sort(a,1)
    print("sorted array", a)

    print("Returning a new array after sorting:")
    a = [1,8,5,3,77,9,13,15]
    print("array before sorting: ", a)
    b = heap_sort(a)
    print("original array after sorting: ", a)
    print("sorted array: ", b)

"""
Sample run:

test_heap_sort()

In place sorting:
unsorted array [45, 21, 7, 8, 3, 4, 1, 3]
New heap created with capacity 8
sorted array [1, 3, 3, 4, 7, 8, 21, 45]
Returning a new array after sorting:
array before sorting:  [1, 8, 5, 3, 77, 9, 13, 15]
New heap created with capacity 8
original array after sorting:  [1, 8, 5, 3, 77, 9, 13, 15]
sorted array:  [1, 3, 5, 8, 9, 13, 15, 77]

"""


    
