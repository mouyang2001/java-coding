package code.patterns.design.creational.builder;

public class UserBuilder {
    public final String firstName;
    public final String lastName;
    public int age;
    public String phone;
    public String address;

    public UserBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UserBuilder age(int age) {
        this.age = age;
        return this; // The reason why we return this, is that is enables us to chain it.
    }
    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }
    //Return the finally constructed User object
    public User build() {
        User user =  new User(this);
        validateUserObject(user);
        return user;
    }
    private void validateUserObject(User user) {
        //Do some basic validations to check
        //if user object does not break any assumption of system
    }
}
