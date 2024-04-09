//import java.util.List;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * STUDENT SortedDoubleLinkedList class
 * 
 * @author Caterine Asselborn
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
    // Attribute
    Comparator<T> compareableObject;


    /**
     * Constructor
     * Creates an empty list that is associated with the specified comparator.
     * @param compareableObject The comparator to use when sorting this linked list.
     */
    public SortedDoubleLinkedList(Comparator<T> compareableObject)
    {
        this.compareableObject = compareableObject;
    }

    /**
     * Inserts the specified element at the correct position in the sorted list.
     * @param data The data to be added to the linked list.
     */
    public void add(T data)
    {
        // Case Collection has NO nodes
        if(isEmpty())
        {
            super.addToFront(data);
            return;
        }
        
        // Cases where other node(s) are in the Collection
        // Node to add
        Node<T> newNode = new Node<>(data);

        // Node to compare
        Node<T> currentNode = this.head;

        while(currentNode != null)
        {
            T currentNodeData = currentNode.getData();
            int resultOfComparison = compareableObject.compare(data, currentNodeData);
            
            // Case we find the same data I will add new node after the match
            // data == currentNodeData, returns 0
            if(resultOfComparison == 0)
            {
                if(currentNode == tail)
                {
                    super.addToEnd(data);

                    // leave the method
                    return;
                }
                
                // Saved next node
                Node<T> newNext = currentNode.getNextNode();

                // Re-assigned new node connections to node before
                currentNode.setNextNode(newNode);
                newNode.setPreviousNode(currentNode);

                // Re-assigned new node to node after
                newNode.setNextNode(newNext);
                newNext.setPreviousNode(newNode);

                // Match found leaving loop
                break;
            }

            // data < currentNodeData, returns less than 0 int 
            if(resultOfComparison < 0)
            {
                if(currentNode == head)
                {
                    super.addToFront(data);

                    // leave the method
                    return;
                }

                // Saved newPrevious node
                Node<T> newPrevious = currentNode.getPreviousNode();

                // Re-assigned new node connections to node after
                currentNode.setPreviousNode(newNode);
                newNode.setNextNode(currentNode);

                // Re-assigned new node to node before
                newNode.setPreviousNode(newPrevious);
                newPrevious.setNextNode(newNode);

                // leave the loop
                break;
            }
            
            // data > currentNodeData, returns greater than zero int
            if(resultOfComparison > 0 && currentNode == tail)
            {
                super.addToEnd(data);
                
                // leave method
                return;
            }
            
            // moves to next node to compare
            currentNode = currentNode.getNextNode();
        }
        
        this.size++;
    }

    /**
     * Invalid method for SortedDoubleLinkList
     */
    @Override
    public void addToEnd(T data)
    {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Invalid method for SortedDoubleLinkList
     */
    @Override
    public void addToFront(T data)
    {
        throw new UnsupportedOperationException("addToFront is not supported in SortedDoubleLinkList");
    }

    /**
     * Implements the iterator by calling the super class iterator method.
     * 
     * Note: This is a great exercise in inheritance but this is not necessary since not writing the method 
     * would automatically call the parent's class method
     */
    @Override
    public ListIterator<T> iterator()
    {
        return super.iterator();
    }

    /**
     * Implements the remove operation by calling the super class remove method.
     * 
     * Note: This is a great exercise in inheritance but this is not necessary since not writing the method 
     * would automatically call the parent's class method
     */
    @Override
    public Node<T> remove(T data, Comparator<T> comparator)
    {
        return super.remove(data, comparator);
    }
}
