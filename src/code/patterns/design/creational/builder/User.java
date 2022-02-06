package code.patterns.design.creational.builder;

/**
 * Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you
 * to produce different types and representations of an object using the same construction code.
 *
 * Pros: reusability, construct objects in steps or recursively, SRP isolate complex construction code from the
 * business logic.
 *
 * Cons: massively increases lines of code.
 */
public class User
{
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //All getter, and NO setter to provide immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }
}