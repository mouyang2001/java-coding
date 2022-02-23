package code.patterns.design.creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder("Matthew", "Ouyang")
                .age(20)
                .phone("123456")
                .address("Auckland New Zealand");

        User user = userBuilder.build();
        System.out.println(user.toString());
    }
}
