package com.amazon.ata.inmemorycaching.classroom.dao;

import com.amazon.ata.inmemorycaching.classroom.dao.models.GroupMembershipCacheKey;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

// be sure to mimic the behavior of the original dao (same parameters, same return)

public class GroupMembershipCachingDao {

    private final LoadingCache<GroupMembershipCacheKey, Boolean> theCache;

    @Inject
    public GroupMembershipCachingDao(final GroupMembershipDao delegateDao) {
        theCache = CacheBuilder.newBuilder()
                .maximumSize(20000)
                .expireAfterWrite(3, TimeUnit.HOURS)
                .build(CacheLoader.from(delegateDao::isUserInGroup));
    }

    public boolean isUserInGroup(String userId, String groupId) {
        return theCache.getUnchecked(new GroupMembershipCacheKey(userId, groupId));
    }

}
