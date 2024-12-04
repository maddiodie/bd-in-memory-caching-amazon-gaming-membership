package com.amazon.ata.inmemorycaching.classroom.activity;

import com.amazon.ata.inmemorycaching.classroom.dao.GroupMembershipCachingDao;
import com.amazon.ata.inmemorycaching.classroom.dao.GroupMembershipDao;

import javax.inject.Inject;

/**
 * Handles requests to check if a user is in a group.
 */
public class CheckUserInGroupActivity {

//    private final GroupMembershipDao groupMembershipDao;

    private final GroupMembershipCachingDao groupMembershipCachingDao;

    /**
     * Constructs an Activity with the given DAOs.
     * @param groupMembershipCachingDao The GroupMembershipDao to use for checking the user's membership
     */
    @Inject
    public CheckUserInGroupActivity(final GroupMembershipCachingDao groupMembershipCachingDao) {
        this.groupMembershipCachingDao = groupMembershipCachingDao;
    }

    /**
     * Returns true if the userId is a member in the group with the provided groupId.
     * @param userId the userId to check for membership
     * @param groupId - the id of the group to check that the userId is a member of
     * @return true if the userId has a membership in the group, false otherwise
     */
    public boolean handleRequest(final String userId, final String groupId) {
        return groupMembershipCachingDao.isUserInGroup(userId, groupId);
    }
}
