import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCircularList<E> implements CircularListADT<E> {
    private E[] storage;
    private int first, last, size, maxSize;
    
    public ArrayCircularList(int maxCapacity) {
        maxSize=maxCapacity;
        storage=(E[]) new Object[maxCapacity];
        first=size=0;
        last=maxSize-1;
    }
    
    public ArrayCircularList() {
        this(MAXIMUM);
    }

    public boolean insertFirst(E obj) {
        if (isFull()) return false;
        size++;
        if (first==0)
            first=maxSize-1;
        else
            first--;
        
        storage[first]=(E)obj;
        return true;
    }

    public boolean insertLast(E obj) {
        if (!isFull()) return false;
        size++;
        if (last==maxSize-1)
            last=0;
        else
            last++;
        
        storage[last]=(E)obj;
        return true;
    }

    public E deleteFirst() {
        if (!isEmpty()) return null;
        E tmp = storage[first];
        size--;
        if (first==maxSize-1) 
            first=0;
        else
            first++;
        
        return tmp;
    }

    public E deleteLast() {
        if (!isEmpty()) return null;
        E tmp = storage[last];
        size--;
        if (last==0)
            last=maxSize-1;
        else
            last--;
        
        return tmp;
    }

    public E delete(E obj) {
    	if (isEmpty())
    		return null;
    	
    	int index=first;
    	while(((Comparable<E>)storage[index]).compareTo(obj)!=0) {
            if(index==last) return null;
            index++;
            if(index==maxSize)
                index=0;
    	}
	E ourObject = storage[index];
        
        while (index!=last) {
            if (index==maxSize-1) {
               storage[index]=storage[0];
               index=-1;
            }
            else
               storage[index]=storage[index+1];
            index++;
         }
        size--;
        if (last==0) last=maxSize-1;
        else last--;
        return ourObject;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==maxSize;
    }

    public E first() {
        return (!isEmpty()) ? storage[first] : null;
    }

    public E last() {
        return (!isEmpty()) ? storage[last] : null;
    }

    public boolean contains(E obj) {
        return search(obj)!=null;
    }

    public E search(E obj) {
        for (E tmp : this)
            if(((Comparable<E>)obj).compareTo(tmp)==0)
                return tmp;
        return null;
    }
    
    public void reset() {
        first=size=0;
        last=maxSize-1;
    }

    public Iterator<E> iterator() {
    	return new IteratorClass();
    }
    
    class IteratorClass implements Iterator<E> {
    	private int count, index;
    	public IteratorClass() {
            index=first;
            count=0;
    	}
        
        public boolean hasNext() {
            return count!=size;
        }
        
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E tmp = storage[index++];
            if (index == maxSize) index = 0;
            count++;
            return tmp;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}