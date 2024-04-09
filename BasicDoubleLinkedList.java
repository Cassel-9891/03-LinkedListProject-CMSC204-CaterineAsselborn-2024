import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * STUDENT class BasicDoubleLinkedList
 * 
 * @author Caterine Asselborn
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>
{
    // Attributes
    Node<T> head;
    Node<T> tail;
    int size;

    // Constructor
    /**
     * Creates an empty double linked list with no head, no tail, and a size of 0.
     */
    public BasicDoubleLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * This method returns an object of the DoubleLinkedListIterator.
     */
    @Override
    public ListIterator<T> iterator()
    {
        return new DoubleLinkedListIterator<>(head, tail);
    }

    /**
     * Checks if the Collection is empty
     * 
     * @return true if is empty, otherwise returns false
     */
    protected boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Adds an element to the end of the list and updates the size of the list
     * 
     * @param data The data to add to the end of the linked list.
     */
    public void addToEnd(T data)
    {
        // Created temporary node before necessary checks
        Node<T> newNode = new Node<>(data);

        // Case we have an empty collection
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        } else
        {
            // Setting links
            tail.setNextNode(newNode);
            newNode.setPreviousNode(tail);

            // Setting new tail
            tail = newNode;
        }

        // Size increase no matter which case when adding
        size++;
    }

    /**
     * Adds element to the front of the list and updates the size of the list
     * 
     * @param data Data to add to the front of the linked list.
     */
    public void addToFront(T data)
    {
        // Created temporary node before necessary checks
        Node<T> newNode = new Node<>(data);

        // Case we have an empty collection
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        } else
        {
            // Setting links
            head.setPreviousNode(newNode);
            newNode.setNextNode(head);

            // Setting new head
            head = newNode;
        }

        size++;
    }

    /**
     * Returns but does not remove the first Node from the list.
     * 
     * @return first Node's data
     */
    public T getFirst()
    {
        return head.getData();
    }

    /**
     * Returns but does not remove the last element from the list.
     * 
     * @return last Node's data
     */
    public T getLast()
    {
        return tail.getData();
    }

    /**
     * Returns the number of nodes in the list.
     * 
     * @return size of Double Linked List Collection (amount of nodes in Collection)
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Removes the first instance of the targetData from the list.
     * 
     * @param targetData The data to find and remove
     * @param  Comparator The comparator to use to determine if two items are a match
     * @return removed targetted Node's data
     */
    public Node<T> remove(T targetData, Comparator<T> Comparator)
    {
        Node<T> currentNode = this.head;

        while (currentNode != null)
        {
            // returns 0 if object1 == object2
            int comparatorResult = Comparator.compare(targetData, currentNode.getData());
            boolean areEqual = comparatorResult == 0;

            if (areEqual)
            {

                if (currentNode == this.head)
                {
                    return retrieveFirstNode();
                }

                if (currentNode == this.tail)
                {
                    return retrieveLastNode();
                } 
                
                Node<T> previousNode = currentNode.getPreviousNode();
                Node<T> nextNode = currentNode.getNextNode();

                previousNode.setNextNode(nextNode);
                nextNode.setPreviousNode(previousNode);
                
                size--;
                return currentNode;
            }

            currentNode = currentNode.getNextNode();
        }

        return null;
    }

    private Node<T> retrieveFirstNode()
    {
        // Case Collection is empty
        if (this.isEmpty())
        {
            return null;
        }

        // Retrieve data from Node before removing
        Node<T> result = head;
        if (this.size == 1)
        {
            head = null;
            tail = null;
        } else // we have at least two (or more Nodes)
        {
            // Re-assigning the head of the Collection
            head = head.getNextNode();
            head.setPreviousNode(null);
        }

        size--;
        return result;
    }

    /**
     * Removes and returns the first element from the list.
     * 
     * @return first Node
     */
    public T retrieveFirstElement()
    {
        Node<T> firstNode = retrieveFirstNode();
        if(firstNode == null)
        {
            return null;
        }

        return firstNode.getData();
    }

    private Node<T> retrieveLastNode()
    {
        // Case Collection is empty
        if (this.isEmpty())
        {
            return null;
        }

        // Retrieve data from Node before removing
        Node<T> result = tail;
        if (this.size == 1)
        {
            head = null;
            tail = null;
        } else // we have at least two (or more Nodes)
        {
            // Re-assigning tail of the Collection
            tail = tail.getPreviousNode();
            tail.setNextNode(null);
        }

        size--;
        return result;
    }

    /**
     * Removes and returns the last element from the list.
     * 
     * @return last Node
     */
    public T retrieveLastElement()
    {
        Node<T> lastNode = retrieveLastNode();
        if(lastNode == null)
        {
            return null;
        }

        return lastNode.getData();
    }

    /**
     * Returns an arraylist of all the items in the Double Linked list
     * 
     * @return an arrayList
     */
    public ArrayList<T> toArrayList()
    {
        // Array list to store data and current node to start
        ArrayList<T> resutArrayList = new ArrayList<>();
        Node<T> currentNode = this.head;

        while (currentNode != null)
        {
            resutArrayList.add(currentNode.data);
            currentNode = currentNode.getNextNode();
        }

        return resutArrayList;
    }

    /**
     * Inner Iterator class
     */
    protected class DoubleLinkedListIterator<E> implements ListIterator<T>
    {
        // Attributes
        Node<T> head;
        Node<T> tail;
        Node<T> currentNode;

        // Constructor
        public DoubleLinkedListIterator(Node<T> head, Node<T> tail)
        {
            this.head = head;
            this.tail = tail;
            currentNode = head;
        }

        @Override
        public boolean hasNext()
        {
            // If the Collection is NOT empty(meaning is not null) or we are NOT passed the tail, there must be a next Node
            return currentNode != null;
        }

        @Override
        public T next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }

            // Saving data from current Node before moving iterator to next node
            T resultOfCurrent = currentNode.getData();

            //Moving iterator to the next node
            currentNode = currentNode.getNextNode();

            return resultOfCurrent;
        }

        @Override
        public boolean hasPrevious()
        {
            // If the Collection is Not at the head, there must be previous Node
            return currentNode != head;
        }

        @Override
        public T previous()
        {
            if(!hasPrevious())
            {
                throw new NoSuchElementException();
            }
            
            currentNode = currentNode == null ? tail : currentNode.getPreviousNode();

            return currentNode.getData();
        }

        /***************************************************************************
         * These methods will not be implemented in this project
         ***************************************************************************/
        @Override
        public int nextIndex() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T e) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Inner Node class that will contain the data elements and the references
     * (pointers) to the previous and the next node for a Double Linked List
     */
    public class Node<E>
    {
        // Attributes
        private E data;
        private Node<E> previous;
        private Node<E> next;

        // Constructor
        /**
         * Creates an instance of Node with no previous, no next, and the data provided.
         * @param dataNode The data to be placed within the node.
         */
        public Node(E dataNode)
        {
            this.data = dataNode;
            previous = null;
            next = null;
        }

        // Good-old setters
        /**
         * Sets the node that is after this one.
         * @param next The node after this node.
         */
        public void setNextNode(Node<E> next)
        {
            this.next = next;
        }

        /**
         * Sets the node that is before this one.
         * @param previous The node before this node.
         */
        public void setPreviousNode(Node<E> previous)
        {
            this.previous = previous;
        }

        // Fancy getters
		/**
		 * Gets the node that is after this one in a linked list.
		 * @return A reference to the node after this one.
		 */
        public Node<E> getNextNode()
        {
            return next;
        }
        
		/**
		 * Gets the node that is before this one in a linked list.
		 * @return A reference to the node before this one.
		 */
        public Node<E> getPreviousNode()
        {
            return previous;
        }

        /**
         * Gets the data within the node.
         * @return The data within the node.
         */
        public E getData()
        {
            return data;
        }
    }
}
