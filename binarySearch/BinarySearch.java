
class BinarySearch{

    static boolean found;
    static int counter;

    // main method tests binSearch and insert methods

    public static void main(String[] args){

        int[] x = {1, 4, 4, 4, 8, 9};
        int[] test_x = {-1, 4, 1, 7, 9, 8, 2};
        testBinSearch(test_x, x, 0, x.length);
        
        int[] y = {7, 7, 10, 23, 42, 42, 42, 51, 60};
        int[] test_y = {3, 7, 26, 42, 29, 51, 32, 21, 60};
        testBinSearch(test_y, y, 0, y.length);
        
        int[] z = new int[(int) Math.pow(10,8)];
        for(int c = 0; c < z.length; c++){
            z[c] = 2 * c + 1;  // populate array with odd nos.
        }

        int[] test_z = {50000000, 25000000, 12500001, 12, 1513482};
        testBinSearch(test_z, z, 0, z.length);
        

        int[] p = new int[(int) Math.pow(10,8)];
        for(int c = 0; c < p.length; c++){
            p[c] = 9;
        }

        int[] test_p = {1, 9, 13, 14, 9, 2, 1, -1};
        testBinSearch(test_p, p, 0, p.length);

        System.out.println("Testing Insert method:");
        System.out.println(" ");
        
        testInsert(12, x);
        testInsert(-7, x);
        testInsert(4, x);
        testInsert(7, x);
        
    }

    // binSearch searches for the integer key among the entires x[i], ..., x[j-1] using binary
    // search. The return of the method is the smallest array idx k such that x[k] == key, if key
    // in array. Otherwise return idx k such that the assignment x[k] = key would still keep the
    // array sorted (if current elements x[k],...x[j-1] are shifted up to x[k+1],...x[j])

    static int binSearch(int key, int[] x, int i, int j){
        return binarySearchHelper(key, x, i, j - 1);
    }

    static int binarySearchHelper(int key, int[] x, int i, int j){
        
        counter++;
        
        // base case: key not found. 
        // extract the idx k = j + 1 in the final call (i > j) 
        
        if(i > j) {
            return j + 1;
        }

        int middle = (i + j) / 2;

        if(x[middle] == key){          
            found = true;
            if(middle != 0 && x[middle - 1] == key){  
                return binarySearchHelper(key, x, 0, middle);

                // the code above helps find the smallest index such that x[ind] == key
                // we only need to check the left for a smaller index. If it exists,
                // run binary search on left part to get the smallest index.
            }

            return middle;
       
        } else if(x[middle] < key){
            return binarySearchHelper(key, x, middle + 1, j);
            
        } else{
            return binarySearchHelper(key, x, i, middle - 1);
        }

    }

    // insert method puts the integer key in the correct position in array x.

    static int[] insert(int key, int[] x){
        if(x.length == 0){
            int[] res = {key};
            return res;
        }
       
        int idx = binSearch(key, x, 0, x.length);
        
        int[] result = new int[x.length + 1];
        if(idx >= x.length){
            result[x.length] = key;
        }

        boolean flag = false;

        for(int i = 0; i < result.length - 1; i++){

            if(i == idx){
                result[i] = key;
                flag = true;
            } 

            if(!flag){
                result[i] = x[i];
            } else{
                result[i+1] = x[i];
            }

        }

        return result;
    }

    static void testBinSearch(int[] keys, int[] x, int i, int j){
        if(keys.length == 0 || x.length == 0){
            System.out.println("Check input to test method.");
        }

        System.out.print("Testing array: ");
        int array_print_len = Math.min(8, x.length);

        for(int a = 0; a < array_print_len; a++){
            System.out.print(x[a] + " ");
        } 

        System.out.print("....");
        System.out.println(" ");
       
        for(int b = 0; b < keys.length; b++){
            found = false;
            counter = 0;
            int result = binSearch(keys[b], x, 0, x.length);

            if(found){
                System.out.println("Key " + keys[b] + " found at index " + result + ", after "
                  + counter + " iterations.");
            } else{
                System.out.println("Key " + keys[b] + " not found, should be at index " +
                result + ", after " + counter + " binary search iterations.");
            }
        }
        
        System.out.println(" ");

    }

    static void testInsert(int key, int[] array){
        
        System.out.println("Test - Key: " + key);
        int[] new_x = insert(key,array);

        for(int k = 0; k < new_x.length; k++){
            System.out.print(new_x[k] + " ");
        }

        System.out.println(" ");
        System.out.println(" ");
    }
}


/*

A sample run of the program.

Testing array: 1 4 4 4 8 9 .... 
Key -1 not found, should be at index 0, after 3 binary search iterations.
Key 4 found at index 1, after 2 iterations.
Key 1 found at index 0, after 2 iterations.
Key 7 not found, should be at index 4, after 4 binary search iterations.
Key 9 found at index 5, after 3 iterations.
Key 8 found at index 4, after 2 iterations.
Key 2 not found, should be at index 1, after 4 binary search iterations.
 
Testing array: 7 7 10 23 42 42 42 51 .... 
Key 3 not found, should be at index 0, after 4 binary search iterations.
Key 7 found at index 0, after 3 iterations.
Key 26 not found, should be at index 4, after 5 binary search iterations.
Key 42 found at index 4, after 1 iterations.
Key 29 not found, should be at index 4, after 5 binary search iterations.
Key 51 found at index 7, after 3 iterations.
Key 32 not found, should be at index 4, after 5 binary search iterations.
Key 21 not found, should be at index 3, after 5 binary search iterations.
Key 60 found at index 8, after 4 iterations.
 
Testing array: 1 3 5 7 9 11 13 15 .... 
Key 50000000 not found, should be at index 25000000, after 27 binary search iterations.
Key 25000000 not found, should be at index 12500000, after 27 binary search iterations.
Key 12500001 found at index 6250000, after 26 iterations.
Key 12 not found, should be at index 6, after 28 binary search iterations.
Key 1513482 not found, should be at index 756741, after 28 binary search iterations.
 
Testing array: 9 9 9 9 9 9 9 9 .... 
Key 1 not found, should be at index 0, after 27 binary search iterations.
Key 9 found at index 0, after 27 iterations.
Key 13 not found, should be at index 100000000, after 28 binary search iterations.
Key 14 not found, should be at index 100000000, after 28 binary search iterations.
Key 9 found at index 0, after 27 iterations.
Key 2 not found, should be at index 0, after 27 binary search iterations.
Key 1 not found, should be at index 0, after 27 binary search iterations.
Key -1 not found, should be at index 0, after 27 binary search iterations.
 
Testing Insert method:
 
Test - Key: 12
1 4 4 4 8 9 12  
 
Test - Key: -7
-7 1 4 4 4 8 9  
 
Test - Key: 4
1 4 4 4 4 8 9  
 
Test - Key: 7
1 4 4 4 7 8 9  
 
*/