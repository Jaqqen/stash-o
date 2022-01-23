package org.jaqqen.stasho.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static org.jaqqen.stasho.security.StashOPermission.*;

public enum StashORole {
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE)),
    USER(Sets.newHashSet(USER_READ, USER_WRITE));

    private final Set<StashOPermission> perms;

    StashORole(Set<StashOPermission> perms) {
        this.perms = perms;
    }

    public Set<StashOPermission> getPerms() {
        return perms;
    }
}
