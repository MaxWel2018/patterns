package org.pattern.gof.creational.builder.wrong;

public class Student extends User {
    private final String email;

    public Student(StudentBuilder builder) {
        super(builder);
        this.email=builder.email;
    }

    public String getEmail() {
        return email;
    }

    public static class StudentBuilder extends UserBuilder{
        private String email;

        public StudentBuilder() {
        }

        @Override
        public Student build() {
            return new Student(this);
        }

        public StudentBuilder withEmail(String email) {
            this.email = email;
            return this;
        }
    }
}
