package heap;
class Node{
    private long key;
    Node(long v){
        key = v;
    }
    public long getKey(){
        return key;
    }
    
}
class Heap{
    Node[] heapTree;
    int n;
    Heap(){
        n = 0;
        heapTree = new Node[10000];
    }
    public boolean insert(long v){
        Node newN = new Node(v);
        heapTree[n] = newN;
        trickleUp(n++);
        return true;
    }
    public void trickleUp(int index)
    {
        int parent = (index - 1)/2;
        Node bottom = heapTree[index];
        while(index > 0 && bottom.getKey() > heapTree[parent].getKey()){
            heapTree[index] = heapTree[parent];
            index = parent;
            parent = (parent - 1)/2;
        }
        heapTree[index] = bottom;
    }
    public void trickleDown(int index){
        int largerChild;
        Node top = heapTree[index];
        while(index < n/2){
            int left = 2*index +1;
            int right = left + 1;
            if(right < n && heapTree[right].getKey() > heapTree[left].getKey())
                largerChild=right;
            else
                largerChild = left;
            if(top.getKey() > heapTree[largerChild].getKey() )
                break;
            heapTree[index] = heapTree[largerChild];
            index = largerChild;
        }
        heapTree[index] = top;
    }
    public Node remove(){
        Node root = heapTree[0];
        heapTree[0] = heapTree[--n];
        trickleDown(0);
        return root;
    }
    public void display(){
        for(int j=0;j<n;j++)
            System.out.print(heapTree[j].getKey() + ", ");
        System.out.println();
    }
    
}

public class HeapApp {
    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(4);
        myHeap.insert(3);
        myHeap.insert(-1);
        myHeap.insert(5);
       
        myHeap.remove();
        myHeap.display();
        
    }
    
}
