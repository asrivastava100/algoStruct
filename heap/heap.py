#This code implements a min heap.

class heap():
    def __init__(self,max_num_of_items):
        self.max_num_of_items = max_num_of_items
        self.heap_array = [None] * self.max_num_of_items
        self.last_filled_position = None
        print(f"New heap created with capacity {self.max_num_of_items}")
    
    def peak(self):
        if self.heap_array[0] is None:
            return None
        return self.heap_array[0]
    
    def has_left_child(self,index):
        check_idx = 2 * index + 1
        if check_idx > len(self.heap_array):
            return False
        return True if self.heap_arrayrray[2*(index)+1] is not None else False

    def has_right_child(self,index):
        check_idx = 2 * index + 2
        if check_idx > len(self.heap_array):
            return False
        return True if self.heap_array[2*(index)+1] is not None else False

    def left_child(self,index):
        return 2 * index + 1 if self.has_left_child(index) else None 

    def right_child(self,index):
        return 2 * index + 2 if self.has_right_child(index) else None 

    def parent(self,index):
        return (index - 1) // 2 if (index - 1) // 2 >= 0 else None
    
    def swap_item(self,array, idx1, idx2):
        array[idx1], array[idx2] = array[idx2], array[idx1]
    
    def insert(self,node):
        if self.last_filled_position == len(self.heap_array):
            print(f"Heap at Max capacity. Cannot insert item {node}")
            return
        if self.last_filled_position is None:
            self.heap_array[0] = node
            self.last_filled_position = 0
            return
        self.heap_array[self.last_filled_position + 1] = node
        self.last_filled_position +=1
        parent_Idx = self.parent(self.last_filled_position)
        check_idx = self.last_filled_position
        while parent_Idx is not None:
            
            if self.heap_array[parent_Idx] > self.heap_array[check_idx]:
                self.swap_item(self.heap_array, parent_Idx, check_idx)
            parent_Idx = self.parent(parent_Idx)
        return
    
    def build_heap(self,items_array):
        for i in range(len(items_array)):
            self.insert(items_array[i])
        return

    def __str__(self):
      printStr = ''
      for i in range(len(self.heap_array)):
          printStr += f" {self.heap_array[i]} "
      return printStr 

heap1 = heap(12)
heap1.build_heap([6,3,89,32,5,1])
print(heap1)

# 3  5  1  32  6  89  None  None  None  None  None  None 

# next steps: debug insert function
