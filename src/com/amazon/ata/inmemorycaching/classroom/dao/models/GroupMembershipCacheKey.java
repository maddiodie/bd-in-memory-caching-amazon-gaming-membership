package com.amazon.ata.inmemorycaching.classroom.dao.models;

import java.util.Objects;

// this is the key for accessing the cache
// since it requires multiple values, we need to hold and manage both values into one object

// this class is immutable
// (1) declared with 'final'
// (2) contains final instance data
// (3) no setters
// (4) only uses immutable data (both strings which are in and of themselves immutable)

public final class GroupMembershipCacheKey {

    private final String userId;
    private final String groupId;

    public GroupMembershipCacheKey(final String userId, final String groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, groupId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        GroupMembershipCacheKey request = (GroupMembershipCacheKey) obj;

        return userId.equals(request.userId) && groupId.equals(request.groupId);
    }

}
