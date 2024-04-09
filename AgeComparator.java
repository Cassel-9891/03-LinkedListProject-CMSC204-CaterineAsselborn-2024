import java.util.Comparator;

/**
 * STUDENT COMPARATOR test class to support BasicDoubleLinkedList and SortedDoubleLinkList testing
 * 
 * @author Caterine Asselborn
 */
public class AgeComparator implements Comparator<Person_STUDENT_TEST>
{

    @Override
    public int compare(Person_STUDENT_TEST person, Person_STUDENT_TEST otherPerson)
    {
        return person.getAge() - otherPerson.getAge();
    }

}
