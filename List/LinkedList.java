package List;

public class LinkedList<T> {
    
    // Node class - inner class for the nodes in our linked list
    private static class Node<T> {
        private T data;           // The data stored in this node
        private Node<T> next;     // Reference to the next node in the list
        
        // Constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // LinkedList fields
    private Node<T> head;     // Points to the first node in the list
    private int size;         // Tracks the number of elements in the list
    
    // Constructor - creates an empty list
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Get the current size of the list
    public int size() {
        return size;
    }
    
    // Add an element to the beginning of the list (prepend)
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        size++;
    }
    
    // Add an element to the end of the list (append)
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            // Need to find the last node
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
        size++;
    }
    
    // Add an element at a specific position
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        // Special case: adding at the beginning
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        // Special case: adding at the end
        if (index == size) {
            addLast(data);
            return;
        }
        
        // Find the node just before where we want to insert
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        // Create new node and insert it into the list
        Node<T> newNode = new Node<>(data);
        newNode.next = current.next;
        current.next = newNode;
        
        size++;
    }
    
    // Remove the first element from the list
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove from an empty list");
        }
        
        T removedData = head.data;
        head = head.next;
        size--;
        
        return removedData;
    }
    
    // Remove the last element from the list
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove from an empty list");
        }
        
        // Special case: only one element in the list
        if (head.next == null) {
            T removedData = head.data;
            head = null;
            size--;
            return removedData;
        }
        
        // Find the second-to-last node
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        T removedData = current.next.data;
        current.next = null;
        size--;
        
        return removedData;
    }
    
    // Remove an element at a specific position
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        // Special case: removing the first element
        if (index == 0) {
            return removeFirst();
        }
        
        // Special case: removing the last element
        if (index == size - 1) {
            return removeLast();
        }
        
        // Find the node just before the one we want to remove
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        T removedData = current.next.data;
        current.next = current.next.next;
        size--;
        
        return removedData;
    }
    
    // Get an element at a specific position
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    // Check if the list contains a specific element
    public boolean contains(T data) {
        Node<T> current = head;
        
        while (current != null) {
            if ((current.data == null && data == null) || 
                (current.data != null && current.data.equals(data))) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    // Clear the entire list
    public void clear() {
        head = null;
        size = 0;
    }
    
    // Convert the list to a string representation
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        
        result.append("]");
        return result.toString();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        
        // Test adding elements
        list.addLast("apple");
        list.addLast("banana");
        list.addFirst("orange");
        list.add(2, "grape");
        
        System.out.println("List after additions: " + list);
        System.out.println("Size: " + list.size());
        
        // Test getting elements
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Contains 'banana': " + list.contains("banana"));
        System.out.println("Contains 'mango': " + list.contains("mango"));
        
        // Test removing elements
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("Removed at index 0: " + list.remove(0));
        
        System.out.println("List after removals: " + list);
        System.out.println("Size: " + list.size());
        
        // Test clear
        list.clear();
        System.out.println("List after clear: " + list);
        System.out.println("Is empty: " + list.isEmpty());
    }
}