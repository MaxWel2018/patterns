package org.pattern.gof.creational.builder.wrong;

public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .withName("Alex")
                .build();

        Student alex =(Student) new Student.StudentBuilder()
                .withEmail("alex@gmail.com")
                .withName("alex")
                .build();
    }
}
