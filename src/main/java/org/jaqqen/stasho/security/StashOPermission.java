package org.jaqqen.stasho.security;

public enum StashOPermission {
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String perm;

    StashOPermission(String perm) {
        this.perm = perm;
    }

    public String getPerm() {
        return perm;
    }
}
