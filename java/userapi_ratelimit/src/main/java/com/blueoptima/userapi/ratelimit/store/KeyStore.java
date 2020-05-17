package com.blueoptima.userapi.ratelimit.store;

import java.util.Objects;

public final class KeyStore {
    private final String api;
    private final String userName;

    public KeyStore(String api, String userName) {
        this.api = api;
        this.userName = userName;
    }

    public String getApi() {
        return api;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyStore)) return false;
        KeyStore that = (KeyStore) o;
        return Objects.equals(api, that.api) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(api, userName);
    }
}
