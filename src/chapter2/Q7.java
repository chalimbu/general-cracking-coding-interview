package chapter2;


public class Q7{
    public static void main(String args[]){
        //  1  -> 2
        //           3 -> 4
        //  5  -> 6
        //
        Node head=new Node(4,null);
        Node n3=new Node(3,head);
        Node n2=new Node(2,n3);
        Node n1=new Node(1,n2);

        Node n6=new Node(6,n3);
        Node n5=new Node(5,n6);

        Node noIntercept=new Node(10,null);

        Q7 q7=new Q7();
        Node interseption=q7.interception(n2,noIntercept);
        System.out.println("Intersection value"+ ((interseption!=null) ? (interseption.data+"") : "no interception"));
    }

    public Node interception(Node h1,Node h2){
        if(getTail(h1)!=getTail(h2)){
            return null;
        }
        int lengt1=listLengt(h1);
        int lengt2=listLengt(h2);
        Node pointer1=h1;
        Node pointer2=h2;
        int difference=Math.abs(lengt1-lengt2);
        if(lengt1>lengt2){
            pointer1=moveAheadN(pointer1,difference);
        }else{
            pointer2=moveAheadN(pointer2,difference);
        }

        while(pointer1!=pointer2){
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }

        return pointer1;
    }

    private int listLengt(Node n){
        int counter=0;
        Node pointer=n;
        while(pointer!=null && pointer.next!=null){
            counter++;
            pointer=pointer.next;
        }
        return counter;
    }

    private Node moveAheadN(Node node, int N){
        int counter=0;
        Node pointer=node;
        while(pointer!=null && pointer.next!=null && counter<N){
            counter++;
            pointer=pointer.next;
        }
        return pointer;
    }

    private Node getTail(Node n){
        Node pointer=n;
        while(pointer!=null && pointer.next!=null){
            pointer=pointer.next;
        }
        return pointer;
    }
}





