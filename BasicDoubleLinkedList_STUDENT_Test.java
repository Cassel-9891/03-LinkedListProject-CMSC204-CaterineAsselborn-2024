import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of BasicDoubleLinkedList
 * 
 * @author Caterine Asselborn
 */
public class BasicDoubleLinkedList_STUDENT_Test 
{
	BasicDoubleLinkedList<Person_STUDENT_TEST> people;
	LastNameComparator comparatorLastName = new LastNameComparator();
	AgeComparator comparatorAge = new AgeComparator();

    public Person_STUDENT_TEST person1 = new Person_STUDENT_TEST("Penelope" , "Cruz", 49);    
    public Person_STUDENT_TEST person2 = new Person_STUDENT_TEST("Sarah", "Connor", 67);
    public Person_STUDENT_TEST person3 = new Person_STUDENT_TEST("Natalie", "Portman", 42);
    public Person_STUDENT_TEST person4 = new Person_STUDENT_TEST("Lucy", "Liu", 55);
    public Person_STUDENT_TEST person5 = new Person_STUDENT_TEST("Salma", "Hayek", 57);
    public Person_STUDENT_TEST person6 = new Person_STUDENT_TEST("Emma", "Watson", 33);   

    @Before
    public void setUp() throws Exception
    {
        people = new BasicDoubleLinkedList<Person_STUDENT_TEST>();
        comparatorLastName = new LastNameComparator();

        people.addToEnd(person3); // added Natalie Portman
        people.addToEnd(person4); // added Lucy Liu
    }

    @After
    public void tearDown() throws Exception
    {
        people = null;
        comparatorLastName = null;
    }

    @Test 
    public void testAddToEnd()
    {
        // Arrange
        Person_STUDENT_TEST expectedPerson = person5; 
        int expectedSize = 3;
        
        // Act
        people.addToEnd(person5);
        
        Person_STUDENT_TEST actualPerson = people.getLast();
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedPerson, actualPerson);
        assertEquals(expectedSize, actualSize);
    }

    @Test 
    public void testAddToFront()
    {
        // Arrange
        Person_STUDENT_TEST expectedPerson = person2;
        int expectedSize = 3;

        // Act
        people.addToFront(person2);
        
        Person_STUDENT_TEST actualPerson = people.getFirst();
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedPerson, actualPerson);
        assertEquals(expectedSize, actualSize);
    }

    @Test 
    public void testGetFirst()
    {
        // Arrange
        people.addToFront(person2);
        people.addToFront(person1);

        Person_STUDENT_TEST expectedFirstPerson = person1;
        int expectedSize = 4;

        // Act
        Person_STUDENT_TEST actualFirstPerson = people.getFirst();
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedFirstPerson, actualFirstPerson);
        assertEquals(expectedSize, actualSize);
    }

    @Test 
    public void testGetLast()
    {
        // Arrange
        people.addToEnd(person5);
        people.addToEnd(person6);

        Person_STUDENT_TEST expectedLastPerson = person6;
        int expectedSize = 4;

        // Act
        Person_STUDENT_TEST actualLastPerson = people.getLast();
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedLastPerson, actualLastPerson);
        assertEquals(expectedSize, actualSize);
    }

    @Test 
    public void testGetSize()
    {
        // Arrange
        people.addToEnd(person1);
        people.addToEnd(person2);
        people.addToEnd(person5);
        people.addToEnd(person6);

        int expectedSize = 6;

        // Act
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test 
    public void testRemove()
    {
        // Arrange
        people.addToEnd(person1);
        people.addToEnd(person2);
        people.addToEnd(person5);
        people.addToEnd(person6);

        Person_STUDENT_TEST expectedPersonRemoved = person1;
        int expectedSizeAfterRemovedPerson = 5;

        // Act
        var actualPersonRemoved = people.remove(person1, comparatorLastName);
        int actualSizeAfterRemovedPerson = people.getSize();

        // Assert
        assertEquals(expectedPersonRemoved, actualPersonRemoved.getData());
        assertEquals(expectedSizeAfterRemovedPerson, actualSizeAfterRemovedPerson);

    }

    @Test 
    public void testRetrieveFirstElement()
    {
        // Arrange
        people.addToFront(person1);
        people.addToFront(person2);

        Person_STUDENT_TEST expectedData = person2;
        int expectedSize = 3;

        // Act
        Person_STUDENT_TEST actualData = people.retrieveFirstElement();
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedSize, actualSize);
        assertEquals(expectedData, actualData);
    }

    @Test 
    public void testRetrieveFirstElementWhenListIsEmpty()
    {
        // Arrange
        people.remove(person3, comparatorAge);
        people.remove(person4, comparatorAge);

        Person_STUDENT_TEST expectedData = null;
        int expectedSize = 0;

        // Act
        Person_STUDENT_TEST actualData = people.retrieveFirstElement();
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedData, actualData);
        assertEquals(expectedSize, actualSize);

    }

    @Test 
    public void testRetrieveLastElement()
    {
        // Arrange
        people.addToEnd(person5);
        people.addToEnd(person6);

        Person_STUDENT_TEST expectedData = person6;
        int expectedSize = 3;

        // Act
        Person_STUDENT_TEST actualData = people.retrieveLastElement();
        int actualSize = people.getSize();

        // Assert
        assertEquals(expectedData, actualData);
        assertEquals(expectedSize, actualSize);
    }

    @Test 
    public void testRetrieveLastElementWhenListIsEmpty()
    {
        {
            // Arrange
            people.remove(person3, comparatorAge);
            people.remove(person4, comparatorAge);
    
            Person_STUDENT_TEST expectedData = null;
            int expectedSize = 0;
    
            // Act
            Person_STUDENT_TEST actualData = people.retrieveLastElement();
            int actualSize = people.getSize();
    
            // Assert
            assertEquals(expectedData, actualData);
            assertEquals(expectedSize, actualSize);
    
        }

    }

    @Test 
    public void testToArrayList()
    {
        // Arrange
        ArrayList<Person_STUDENT_TEST> expectedPeopleArray = new ArrayList<>();
        int expectedArraySize = 6;

            // Fill array
        expectedPeopleArray.add(person3);
        expectedPeopleArray.add(person4);
        expectedPeopleArray.add(person1);
        expectedPeopleArray.add(person2);
        expectedPeopleArray.add(person5);
        expectedPeopleArray.add(person6);

            // Fill Linked List
        people.addToEnd(person1);
        people.addToEnd(person2);
        people.addToEnd(person5);
        people.addToEnd(person6);

        // Act
        ArrayList<Person_STUDENT_TEST> actualPeopleArray = people.toArrayList();
        int actualArraySize = actualPeopleArray.size();

        // Assert
        assertEquals(expectedArraySize, actualArraySize);
        
        for(int i = 0; i < actualArraySize; i++)
        {
            assertEquals(expectedPeopleArray.get(i), actualPeopleArray.get(i));
        }

    }
}