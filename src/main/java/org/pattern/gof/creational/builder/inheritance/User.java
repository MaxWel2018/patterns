package org.pattern.gof.creational.builder.inheritance;

public class User {
    private final Long id;
    private final String name;
    private final String password;
    private final String email;

    protected User(UserBuilder<? extends UserBuilder> userUserBuilder) {
        this.id = userUserBuilder.id;
        this.name = userUserBuilder.name;
        this.password = userUserBuilder.password;
        this.email = userUserBuilder.email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public static class UserBuilder<SELF extends UserBuilder<SELF>> {
        private Long id;
        private String name;
        private String password;
        private String email;

        protected UserBuilder() {
        }

        @SuppressWarnings("unchecked")
        public SELF self() {
            return (SELF) this;
        }

        public User build() {
            return new User(self());
        }

        public SELF withId(Long id) {
            this.id = id;
            return self();
        }

        public SELF withName(String name) {
            this.name = name;
            return self();
        }

        public SELF withPassword(String password) {
            this.password = password;
            return self();
        }

        public SELF withEmail(String email) {
            this.email = email;
            return self();
        }
    }
}
