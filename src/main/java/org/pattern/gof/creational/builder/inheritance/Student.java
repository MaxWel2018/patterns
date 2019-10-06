package org.pattern.gof.creational.builder.inheritance;

import java.util.List;

public class Student extends User {
    private List<String> ids;
    private Address address;

    protected Student(StudentBuilder userUserBuilder) {
        super(userUserBuilder);
    }

    public static class StudentBuilder extends UserBuilder<StudentBuilder> {
        private List<String> ids;
        private Address address;

        public StudentBuilder() {
        }

        @Override
        public StudentBuilder self() {
            return this;
        }

        public Student build() {
            return new Student(self());
        }

        public StudentBuilder withIds(List<String> ids) {
            this.ids = ids;
            return self();
        }

        public StudentBuilder withAddress(Address address) {
            this.address = address;
            return self();
        }
    }
}
