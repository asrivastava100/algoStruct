
// usage: java Matrix n m max 
// generates the random n x m matrix a and the random m x m matrix b,
// both with integer values in [0,max]. It then computes a * b (MMULT) and b^T (TRANSPOSE)

class Matrix {

    static int[][] randomMatrix(int n, int m, int max) {
        
        // Handle invalid entry case -- return 1x1 matrix with entry -1

        if(n <= 0 || m <= 0 || max <= 0){
            int[][] res;
            res = new int[1][1];
            res[0][0] = -1;
            return res;
        } 
        
        int[][] result; 
        result = new int[n][m];

        // Fill entries of matrix. Note (int) (Math.random() * (max + 1)) gives a random integer 
        // in the range [0,... max] both inclusive.

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                result[i][j] = (int) (Math.random() * (max + 1));
            }
        }
        return result;
    }

    static int[][] product(int[][] a, int[][] b) {
        
        // Handle invalid entry case -- return 1x1 matrix with entry -1
        
        if(a[0].length != b.length){
            int[][] res;
            res = new int[1][1];
            res[0][0] = -1;
            return res;
        }

        int resRow = a.length;
        int resCol = b[0].length;
        int [][] result;

        result = new int[resRow][resCol];
        
        // total represents (i,j) entry of result matrix

        for(int i = 0; i < resRow; i++){
            for(int j = 0; j < resCol; j++){
                int total = 0;
                for(int k = 0; k < a[0].length; k++){
                    total += (a[i][k] * b[k][j]);    
                }
                result[i][j] = total;
            }
        }
        return result;
    }

    static void transpose(int[][] matrix) {
        
        // Assumes input matrix is a square matrix. Transposes the matrix in place.
        // i < j condition is necessary to avoid reswapping elements that are 
        // already in the correct position. (If we remove i < j, we will get
        // back the input matrix i.e. no transpose op. conducted.)
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i < j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    static void printMatrix(String name, int[][] matrix) {
        
        // The output displays the brackets, correct spacing and correct 
        // positioning for the name.
        
        String outputStr = name + " = ";
        int outputStrLen = outputStr.length();
        int outputStrPos = (int) (matrix.length / 2);

        if (matrix == null) {
            System.out.println("null");
            return;
        }
        
        // Find the maximum entry in the matrix.

        int max = 0;
        for(int a = 0; a < matrix.length; a++){
            for(int b = 0; b < matrix[0].length;b++){
                if(matrix[a][b] > max){
                    max = matrix[a][b];
                }
            }
        }
        
        int maxNumLength = Integer.toString(max).length();
        
        // print the matrix
        
        for (int i = 0; i < matrix.length; i++) {
            if(i == outputStrPos){
                // print name of matrix
                System.out.print(outputStr);
            } else{
                for(int a = 0; a < outputStrLen; a++){
                    System.out.print(" ");
                }
            }
            System.out.print("(  ");
            for (int j = 0; j < matrix[0].length; j++) {
                String entry = Integer.toString(matrix[i][j]);
               
                for(int k = 0; k < maxNumLength - entry.length(); k++){
                    System.out.print(" ");
                }
                System.out.print(entry + "  ");
                
                
            }
            System.out.print(")");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            return;
        }
        
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);
        int[][] a = randomMatrix(n,m,max);
        int[][] b = randomMatrix(m,m,max);
        printMatrix( "a", a);
        System.out.println();
        printMatrix( "b", b);        
        System.out.println();
        printMatrix( "a*b", product(a,b));                
        System.out.println();
        transpose(b);
        printMatrix( "b^T", b);                
    }

}


/*

Sample program run.

java Matrix 3 6 20

    (  13   9  14  15   2   4  )
a = (   2  12  19   5   1  14  )
    (  20   9  14  16   7   1  )

    (  16   0   2   9   1   6  )
    (  17  10   5   4   0   8  )
    (  18  18   4   6  15   7  )
b = (   5  17  11  20   9   7  )
    (  16   7   1   7  15  11  )
    (   4  17  12  15  12   9  )

      (  736  679  342  611  436  411  )
a*b = (  675  792  364  497  515  413  )
      (  921  680  336  684  491  488  )

      (  16  17  18   5  16   4  )
      (   0  10  18  17   7  17  )
      (   2   5   4  11   1  12  )
b^T = (   9   4   6  20   7  15  )
      (   1   0  15   9  15  12  )
      (   6   8   7   7  11   9  )

*/