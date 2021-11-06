
package lab3_part1;



public class DoubleLinkedList {
    private Node head;
    private Node tail;
    
    public void addFirst(Object value){
        if (head!=null) {
            Node newNode= new Node(value);
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        } else {head=tail= new Node(value);}
    }
    
    public Object getFirst(){
        if (head==null) {return null;} 
        else {return head.value;}
    }
    
    public void removeFirst(){
        if(head==null){return;}
        
            if(head!=tail){
            head=head.next;
            head.prev=null;}
            else {head=tail=null;}
    }
    
    public Object getRemoveFromStart(){
      if (head==null) {return null;}
        if(head!=tail){
        Object znach=head.value;
        head=head.next;
        head.prev=null;
        return znach;}
        else{
        Object znach=head.value;
        head=tail=null;
        return znach;
        }
    } 
    
 
    public void addArrayFirst(Object[] objects){
        
        Node firstNode= new Node(objects[0]);       
        Node prevNode=firstNode; //1
        for (int i = 1; i < objects.length; i++) {
           Node node= new Node(objects[i]);//3
           node.prev=prevNode;//
           prevNode.next=node;
           prevNode=node;//3
           }
         prevNode.next=head;
         head.prev=prevNode;
         head=firstNode;
    }
    
    public void addListFirst(DoubleLinkedList dll){
        Node firstNode=new Node(dll);       
        Node prevNode=firstNode;
        for(int i = 1; i <dll.Size(); i++){
           Node node= new Node(dll);//3
           node.prev=prevNode;//
           prevNode.next=node;
           prevNode=node; 
        }
        prevNode.next=head;
        head.prev=prevNode;
        head=firstNode;
    }
    
    
    
    
    
    public void addLast(Object value){
        if (tail!=null) {
            Node newNode= new Node(value);
            tail.next=newNode;
            newNode.prev=tail;
            tail=tail.next;
            
        } else {head=tail= new Node(value);}
    }
    
    public Object getLast(){
        if (tail==null) {return null;} 
        else {return tail.value;}
    }
    
    public void removeLast(){
        if(tail==null){return;}
          if(head!=tail){
              tail=tail.prev;
              tail.next=null;
              return;}
          else{       
          head=tail=null;
          return;
          }
    }
    
    public Object getRemoveFromLast(){
      if (tail==null) {return null;}
        if(head!=tail){
        Object znach=tail.value;
        tail=tail.prev;
        tail.next=null;           
        return znach;}
        else{
        Object znach=tail.value;
        head=tail=null;
        return znach;
        }
    }
    
    public void addArrayLast(Object[] objects){
        
        Node firstNode= new Node(objects[0]);       
        Node prevNode=firstNode; //1
        for (int i = 1; i < objects.length; i++) {
           Node node= new Node(objects[i]);//3
           node.prev=prevNode;//
           prevNode.next=node;
           prevNode=node;//3
           }
         firstNode.prev=tail;
         tail.next=firstNode;
         tail=prevNode;
    }
    
    public void addListLast(DoubleLinkedList dll){
        Node firstNode= new Node(dll);       
        Node prevNode=firstNode;
        for (int i = 1; i <dll.Size(); i++){
           Node node= new Node(dll);//3
           node.prev=prevNode;//
           prevNode.next=node;
           prevNode=node;//3
           }
        firstNode.prev=tail;
        tail.next=firstNode;
        tail=prevNode;
    }
    
    public boolean isEmty(){
        return head == null;
    }
    
    public int Size(){
        int i;
        if(head==null) {return i=0;}
       
        if(head!=tail){
        Node n=head;
            i=2;
            while (n.next!=tail) {
                //tail.prev=n;
                n=n.next;
                i=i+1;}
            //tail=n;
            //tail.next=null; 
        return i;}
        else{       
        return i=1;
        }
    }
    
    public void printFromStart(){
        Node n=head;
        while(n!=null){
            System.out.println(n.value);
            n=n.next;
        }
    }
    
    public void printFromEnd(){
        Node n=tail;
        while(n!=null){
            System.out.println(n.value);
            n=n.prev;
        }
    }
    
    public boolean containsValue(Object value){
        Node n=head;
        while(n!=null){
            if(n.value==null && value==null || value!=null && value.equals(n.value))
            {return true;}
            else{n=n.next;}
        }
        return false;
    }
    
    public void deleteValue(Object value){
        if(head==null) return;
        
        if(head.checkValue(value)){
            removeFirst();
            //getRemoveFromStart();
        return;}
        
        Node prev = head;
        Node n = head.next;
        while(n!=null){
            if(n.checkValue(value)){
                if(n==tail)
                    removeLast();
                    //getRemoveFromLast();
                else
                    prev.next=n.next;
            return;    
            }
            prev=n;
            n=n.next;
        }
      }
    
    
    
    
    private static class Node{
        Object value;
        Node next;
        Node prev;

        public Node(Object value) {
            this.value = value;
        }
        
        boolean checkValue(Object value){
            return value==null && this.value==null  ||  value!=null && value.equals(this.value);
        }
    }
    
}
