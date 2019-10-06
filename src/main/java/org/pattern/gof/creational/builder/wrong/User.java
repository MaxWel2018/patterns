package org.pattern.gof.creational.builder.wrong;

public class User {
    private final String name;

    public User(UserBuilder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public static class UserBuilder {
        private String name;

        public UserBuilder() {
        }

        public User build() {
            return new User(this);
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }
    }
}
