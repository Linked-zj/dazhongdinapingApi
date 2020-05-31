package com.linked.dazhongdianpingapi.system.enums;
/**
 * @author Linked
 * @date 2020/5/30 16:36
 */
public enum CacheKey {
    HASH_KEY("flash_hash"),
    LIMIT_KEY("flash_limit");

    private String key;

    private CacheKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
