// usage: create a new instance of BST using BST myTree = new BST()
// then use the insert and delete methods to add or remove nodes, respectively.
// The user can also check whether a node is contained in the tree or not.
// The user can also print the tree in a Breadth First Search manner.

class BST{

    private BSTNode rootNode;

    private class BSTNode{
        int value;
        BSTNode left;
        BSTNode right;

        BSTNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    public boolean contains(int value){
        BSTNode currentNode = rootNode;
        while(currentNode != null){
            if(currentNode.value > value){
                currentNode = currentNode.left;
            } else if(currentNode.value < value){
                currentNode = currentNode.right;
            } else{
                return true;
            }
        }

        return false;
    }

    public void insert(int value){
        if(rootNode == null){
            rootNode = new BSTNode(value);
            return;
        }

        BSTNode currentNode = rootNode;
        while(true){
            if(currentNode.value > value){
                if(currentNode.left == null){
                    currentNode.left = new BSTNode(value);
                    break;
                } else{
                    currentNode = currentNode.left;
                }
            } else{
                if(currentNode.right == null){
                    currentNode.right = new BSTNode(value);
                    break;
                } else{
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public void delete(int value){
        deleteHelper(value, rootNode, null);
    }

    public void deleteHelper(int value, BSTNode start, BSTNode parentNode){
        BSTNode currentNode = start;
        while(currentNode != null){
            if(currentNode.value > value){
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if(currentNode.value < value){
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else{
                if(currentNode.left != null && currentNode.right != null){
                    currentNode.value = getRightMinNode(currentNode.right);
                    deleteHelper(currentNode.value, currentNode.right, currentNode);
                } else if(parentNode == null){
                    if(currentNode.left == null){
                        currentNode.value = currentNode.right.value;
                        currentNode.left = currentNode.right.left;
                        currentNode.right = currentNode.right.right;
                    } else if(currentNode.right == null){
                        currentNode.value = currentNode.left.value;
                        currentNode.right = currentNode.left.right;
                        currentNode.left = currentNode.left.left;
                    } else {

                    }
                } else if(parentNode.left == currentNode){
                    parentNode.left = currentNode.left != null ? currentNode.left:currentNode.right;
                 
                } else if(parentNode.right == currentNode){
                    parentNode.right = currentNode.right != null ? currentNode.right:currentNode.left;
                 
                }

                break;
            }
        }
    }

    // getRightMinNode gets the left most node value in the right subtree.

    private int getRightMinNode(BSTNode node){
        BSTNode currentNode = node;
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    // printTree prints the BST in a Breadth First Search (BFS) manner.

    public void printTree(){
        Queue<BSTNode> nodes = new Queue<BSTNode>();
        nodes.enqueue(rootNode);
     
        while(nodes.length() > 0){
            BSTNode current = nodes.dequeue();
            
            System.out.print(current.value + " ");
            
            if(current.left != null){
                nodes.enqueue(current.left);
                
            }
            if(current.right != null){
                nodes.enqueue(current.right);
               
            }
        }

        System.out.println("");
        
    }

    // main method tests BST methods.

    public static void main(String[] args){
        BST myTree = new BST();
        
        int[] nodesToInsert = {10,5,15,2,5,13,22,1,14};
        
        for(int i = 0; i < nodesToInsert.length; i++){
            myTree.insert(nodesToInsert[i]);
        }
        
        System.out.println(" ");
        System.out.println("Printing tree in BFS manner:");
        System.out.println(" ");
        

        myTree.printTree();
        System.out.println(" ");
        
        int[] nodesToCheck = {7,10,12,13,14,16,2,3,1,0,9};

        for(int j = 0; j < nodesToCheck.length; j++){
            if(myTree.contains(nodesToCheck[j])){
                System.out.println("The BST contains " + nodesToCheck[j] + ".");
            } else{
                System.out.println("The BST does not contains " + nodesToCheck[j] + ".");
            }
        }

        int[] nodesToDelete = {10, 13, 2, 11, 14, 21};
        
        System.out.println(" ");
        System.out.println("Testing the delete method");
        System.out.println("Nodes to delete:");
        System.out.println(" ");

        for(int j = 0; j < nodesToDelete.length; j++){
            System.out.print(nodesToDelete[j] + " ");
        }

        System.out.println(" ");
        System.out.println(" ");

        for(int j = 0; j < nodesToDelete.length; j++){
            myTree.delete(nodesToDelete[j]);
            System.out.println("Delete node with value " + nodesToDelete[j] + " if it exists.");
        }

        System.out.println(" ");
        System.out.println("Tree after deleting nodes:");
        System.out.println(" ");

        myTree.printTree();

        System.out.println(" ");

    }
        
}


/*

Sample program run

java BST

Printing tree in BFS manner:
 
10 5 15 2 5 13 22 1 14 
 
The BST does not contains 7.
The BST contains 10.
The BST does not contains 12.
The BST contains 13.
The BST contains 14.
The BST does not contains 16.
The BST contains 2.
The BST does not contains 3.
The BST contains 1.
The BST does not contains 0.
The BST does not contains 9.
 
Testing the delete method
Nodes to delete:
 
10 13 2 11 14 21  
 
Delete node with value 10 if it exists.
Delete node with value 13 if it exists.
Delete node with value 2 if it exists.
Delete node with value 11 if it exists.
Delete node with value 14 if it exists.
Delete node with value 21 if it exists.
 
Tree after deleting nodes:
 
15 5 22 1 5 
 
*/