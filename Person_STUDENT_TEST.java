/**
 * STUDENT PERSON class to support testing in BasicDoubleLinkedList and SortedDoubleLinkList
 * 
 * @author Caterine Asselborn
 */
public class Person_STUDENT_TEST
{
    private final String name;
    private final String lastName;
    private final int age;

    public Person_STUDENT_TEST(String name, String lastName, int age)
    {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName()
    {
        return this.name;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public int getAge()
    {
        return this.age;
    }

    public String toString()
    {
        return "Name: " + getName() + ", Lastname: " + getLastName() + ", age: " + getAge();
    }

}