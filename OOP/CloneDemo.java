/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/28 16:58
 */
public class CloneDemo {
    public static void main(String[] args) {
        Person person = new Person(new Address("广州"));
        Person clone = person.clone();
        person.getAddress().setName("杭州");
        System.out.println("person: " + person.getAddress().getName());
        System.out.println("clone: " + clone.getAddress().getName());

        System.out.println(person.getAddress() == clone.getAddress());
    }
}

class Address implements Cloneable{
    private  String name;
    public Address(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Person implements Cloneable {
    private Address address;
    public Person(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            person.setAddress(person.getAddress().clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
