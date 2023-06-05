#This code implements a min heap.

class heap():
    def __init__(self,max_num_of_items):
        self.max_num_of_items = max_num_of_items
        self.heap_array = [None] * self.max_num_of_items
        self.last_filled_position = None
        print(f"New heap created with capacity {self.max_num_of_items}")
    
    def is_empty(self):
        return True if self.last_filled_position is None else False

    def peak(self):
        return self.heap_array[0] if not self.is_empty() else None

    def has_left_child(self,index):
        check_idx = 2 * index + 1
        if check_idx > self.max_num_of_items - 1:
            return False
        return True if self.heap_array[check_idx] is not None else False

    def has_right_child(self,index):
        check_idx = 2 * index + 2
        if check_idx > self.max_num_of_items - 1:
            return False
        return True if self.heap_array[check_idx] is not None else False

    def left_child(self,index):
        return 2 * index + 1 if self.has_left_child(index) else None 

    def right_child(self,index):
        return 2 * index + 2 if self.has_right_child(index) else None 

    def parent(self,index):
        return (index - 1) // 2 if (index - 1) // 2 >= 0 else None
    
    def swap_item(self,array, idx1, idx2):
        array[idx1], array[idx2] = array[idx2], array[idx1]
    
    def insert(self,node):
        if self.last_filled_position is None:
            self.heap_array[0] = node
            self.last_filled_position = 0
            return
        if self.last_filled_position + 1 == self.max_num_of_items:
            print(f"Heap at Max capacity. Cannot insert item {node}")
            return
        self.heap_array[self.last_filled_position + 1] = node
        self.last_filled_position +=1
        parent_Idx = self.parent(self.last_filled_position)
        check_idx = self.last_filled_position
        while parent_Idx is not None:
            if self.heap_array[parent_Idx] > self.heap_array[check_idx]:
                self.swap_item(self.heap_array, parent_Idx, check_idx)
            check_idx = parent_Idx
            parent_Idx = self.parent(parent_Idx)
        return

    def remove_min(self):
        if self.is_empty():
            raise Exception("Nothing to remove. Heap is empty")
        min_node = self.peak()
        self.swap_item(self.heap_array,self.last_filled_position,0)
        self.heap_array[self.last_filled_position] = None
        self.last_filled_position -= 1
        self.sift_down(self.heap_array,0)
        return min_node
    
    def sift_down(self,array,index):
        while self.has_left_child(index):
            node_to_compare = self.right_child(index) if self.has_right_child(index) and array[self.right_child(index)] < array[self.left_child(index)] else self.left_child(index) 
            if array[node_to_compare] < array[index]:
                self.swap_item(array,node_to_compare,index)
            index = node_to_compare
        return
            
    def build_heap(self,items_array):
        for i in range(len(items_array)):
            self.insert(items_array[i])
        return

    def __str__(self):
      print_str = ''
      for i in range(len(self.heap_array)):
          print_str += f" {self.heap_array[i]} "
      return print_str 


heap1 = heap(12)
print("Heap is empty? ", heap1.is_empty())
heap1.build_heap([6,3,89,32,5,1,0,-1,-5,7,-9,11,12])
print("Elements of the heap: ", heap1)
print("Heap is empty? ", heap1.is_empty())
print(f"Item {heap1.remove_min()} removed")
print("Heap after removal: ", heap1)
print(f"Item {heap1.remove_min()} removed")
print("Heap after removal: ", heap1)
heap1.insert(12)
print("Heap after inserting element 12: ", heap1)


"""
Sample run:

New heap created with capacity 12
Heap is empty?  True
Heap at Max capacity. Cannot insert item 12
Elements of the heap:   -9  -5  1  0  -1  11  3  32  5  7  6  89 
Heap is empty?  False
Item -9 removed
Heap after removal:   -5  -1  1  0  6  11  3  32  5  7  89  None 
Item -5 removed
Heap after removal:   -1  0  1  5  6  11  3  32  89  7  None  None 
Heap after inserting element 12:   -1  0  1  5  6  11  3  32  89  7  12  None 
"""
