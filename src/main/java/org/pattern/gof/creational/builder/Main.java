package org.pattern.gof.creational.builder;

import org.pattern.gof.creational.builder.inheritance.Address;
import org.pattern.gof.creational.builder.inheritance.Student;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        new Student.StudentBuilder()
                .withAddress(new Address())
                .withId(1L)
                .withEmail("alex@gmail.com")
                .withIds(asList("one", "two"))
                .build();
    }
}
