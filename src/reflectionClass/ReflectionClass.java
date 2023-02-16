package reflectionClass;

public class ReflectionClass
{
    private int age;
    public String firstName;
    protected String lastName;
    public ReflectionClass(String firstName, String lastName, int age)
    {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    private void setFirstName(String firstName)
    {
        this.firstName = firstName;

    }
    private void displayInfo()
    {
        System.out.println(firstName + "\n" + lastName + "\n" + age);
    }

}
