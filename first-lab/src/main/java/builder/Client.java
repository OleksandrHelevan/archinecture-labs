package builder;

import lombok.Getter;

@Getter
public class Client {
    private final String id;
    private final String username;
    private final String password;

    private Client(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder {
        private String id;
        private String username;
        private String password;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = String.valueOf(password.hashCode());
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}
