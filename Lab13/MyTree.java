public class MyTree{
    public static void main(String args[]){
        BinarySearchTree t = new BinarySearchTree();
        t.insert(new KeyedItem("M"));
        t.insert(new KeyedItem("J"));
        t.insert(new KeyedItem("D"));
        t.insert(new KeyedItem("F"));
        t.insert(new KeyedItem("L"));
        t.insert(new KeyedItem("W"));
        t.insert(new KeyedItem("S"));
        t.insert(new KeyedItem("T"));
        t.insert(new KeyedItem("Z"));
        
        System.out.println("In-order");
        t.inorder();
        
        System.out.println("Pre-order");
        t.preorder();
        
        
        BinarySearchTree myCopy = new BinarySearchTree();
        myCopy.insert(new KeyedItem("M"));
        myCopy.insert(new KeyedItem("J"));
        myCopy.insert(new KeyedItem("D"));
        myCopy.insert(new KeyedItem("F"));
        myCopy.insert(new KeyedItem("L"));
        myCopy.insert(new KeyedItem("W"));
        myCopy.insert(new KeyedItem("S"));
        myCopy.insert(new KeyedItem("T"));
        myCopy.insert(new KeyedItem("Z"));
        
        if (t.duplicateCheck(myCopy))
            System.out.println("They're Duplicates");
        else
            System.out.println("They're Not Duplicates");
            
        t.delete("M");
        t.preorder();
    }
}