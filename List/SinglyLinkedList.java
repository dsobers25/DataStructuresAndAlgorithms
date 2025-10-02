package List;

public class SinglyLinkedList {

    // the concept of a linked list is that it is a node based data structure
    // that consist of nodes connected by a reference to the next available node
    // if the next available node is null then the end of the list is null


    // The concept of a linked list is that it is a node-based data structure
    // where each node contains both data and a reference to the next node.
    // Nodes are connected in sequence, with each node pointing to the next available node.
    // If the next reference is null, it indicates the end of the list.
    // Unlike arrays, linked lists don't require contiguous memory allocation and
    // can easily grow or shrink in size during program execution.

    Node head;
    Node next;

    void add(Node n) {
        if(head == null) {

        }

    }
    
}


class Node {
    int data;
    Node reference;

    Node(int data, Node refNode) {
        this.data = data;
        this.reference = refNode;
    }

    int getData(){
        return data;
    }

    Node getReference(){
        return reference;
    }
}