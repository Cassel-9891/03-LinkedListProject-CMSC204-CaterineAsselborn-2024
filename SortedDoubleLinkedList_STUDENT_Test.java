import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of SortedDoubleLinkedList
 * 
 * @author Caterine Asselborn
 */
public class SortedDoubleLinkedList_STUDENT_Test 
{
    SortedDoubleLinkedList<Person_STUDENT_TEST> peopleByLastName;
    SortedDoubleLinkedList<Person_STUDENT_TEST> peopleByAge;

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
        peopleByLastName = new SortedDoubleLinkedList<>(comparatorLastName);
        peopleByLastName.add(person1); // added Penelope Cruz
        peopleByLastName.add(person2); // added Sarah Connor
        
        peopleByAge = new SortedDoubleLinkedList<>(comparatorAge);
        peopleByAge.add(person1); // added Penelope Cruz
        peopleByAge.add(person2); // added Sarah Connor
    }

    @After
    public void tearDown() throws Exception
    {
        peopleByLastName = null;
        peopleByAge = null;
    }

    @Test
    public void testAddInSortedByLastName()
    {
        // Arrange
        ArrayList<Person_STUDENT_TEST> expectedSortedByLastNameArray = new ArrayList<>();
        expectedSortedByLastNameArray.add(person1);
        expectedSortedByLastNameArray.add(person2);
        expectedSortedByLastNameArray.add(person3);
        expectedSortedByLastNameArray.add(person4);
        expectedSortedByLastNameArray.add(person5);
        expectedSortedByLastNameArray.add(person6);

        Collections.sort(expectedSortedByLastNameArray, comparatorLastName);
        int expectedSize = 6;

        // Act
        peopleByLastName.add(person3);
        peopleByLastName.add(person4);
        peopleByLastName.add(person5);
        peopleByLastName.add(person6);

        ArrayList<Person_STUDENT_TEST> actualSortedByLastNameArray = peopleByLastName.toArrayList();
        int actualSize = actualSortedByLastNameArray.size();

        // Assert
        assertEquals(expectedSize, actualSize);
        
        for(int i = 0; i < actualSize; i++)
        {
            assertEquals(expectedSortedByLastNameArray.get(i), actualSortedByLastNameArray.get(i));
        }

    }

    @Test
    public void testAddInSortedByAge()
    {
        // Arrange
        ArrayList<Person_STUDENT_TEST> expectedSortedByAge = new ArrayList<>();
        expectedSortedByAge.add(person1);
        expectedSortedByAge.add(person2);
        expectedSortedByAge.add(person3);
        expectedSortedByAge.add(person4);
        expectedSortedByAge.add(person5);
        expectedSortedByAge.add(person6);

        Collections.sort(expectedSortedByAge, comparatorAge);
        int expectedSize = 6;

        // Act
        peopleByAge.add(person3);
        peopleByAge.add(person4);
        peopleByAge.add(person5);
        peopleByAge.add(person6);

        ArrayList<Person_STUDENT_TEST> actualSortedByAge = peopleByAge.toArrayList();
        int actualSize = actualSortedByAge.size();

        // Assert
        assertEquals(expectedSize, actualSize);
        
        for(int i = 0; i < actualSize; i++)
        {
            assertEquals(expectedSortedByAge.get(i), actualSortedByAge.get(i));
        }

    }

    @Test
    public void testAddOnEmptyList()
    {
        // Arrange
        SortedDoubleLinkedList<Person_STUDENT_TEST> emptyList = new SortedDoubleLinkedList<>(comparatorAge); 
        int expectedSize = 1;
        Person_STUDENT_TEST personToAdd = person1;

        // Act
        emptyList.add(personToAdd);
        int actualSize = emptyList.getSize();

        // Assert
        assertEquals(expectedSize, actualSize);
        assertEquals(personToAdd, emptyList.head.getData());
        assertEquals(personToAdd, emptyList.tail.getData());
        assertEquals(emptyList.head, emptyList.tail);
    }

    @Test 
    public void testAddToEndThrowsException()
    {
        try
        {
            peopleByAge.addToEnd(person1);
        }
        catch(UnsupportedOperationException InvalidMethod)
        {
            // This is the expected UnsupportedOperationException
			// Here it has failed successfully by throwing this Exception
        }
        catch(Exception e)
        {
            // If any other exception, other than UnsupportedOperationException, is thrown
			// then this test has failed
			fail("Wrong exception thrown. Expected: UnsupportedOperationException.");
        }
    }

    @Test 
    public void testAddToFrontThrowsException()
    {
        try
        {
            peopleByLastName.addToFront(person1);
        }
        catch(UnsupportedOperationException InvalidMethod)
        {
            // This is the expected UnsupportedOperationException
			// Here it has failed successfully by throwing this Exception
        }
        catch(Exception e)
        {
            // If any other exception, other than UnsupportedOperationException, is thrown
			// then this test has failed
			fail("Wrong exception thrown. Expected: UnsupportedOperationException.");
        }
    }
}
