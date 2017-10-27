import java.util.Iterator;

public interface CircularListADT<E> extends Iterable<E> {
    public static final int MAXIMUM = 200;
    
    // Inserts an object before the first item
    public boolean insertFirst(E obj);
    
    // Inserts an object after the last item
    public boolean insertLast(E obj);   
    
    // Deletes the first item and returns it
    public E deleteFirst();   
    
    // Deletes the last item and returns it
    public E deleteLast();   
    
    // Deletes the specefied object, returns it and shifts the remaining objects
    public E delete(E obj);
    
    // Returns the current number of objects in the list
    public int size();

    // Returns true if nothing exists in the list
    public boolean isEmpty();

    // Returns true if the list is at maximum capacity
    public boolean isFull();    

    // Returns the first object in the list
    public E first();
    
    // Returns the last object in the list
    public E last();                        

    // Returns true if the specified object exists in the list
    public boolean contains(E obj);  
    
    // Returns the specified object if it exists in the list, null if it doesn't
    public E search(E obj);       

    // Restores the list to its initial state
    public void reset();

    // Returns the iterator of the list
    public Iterator<E> iterator();
    
}