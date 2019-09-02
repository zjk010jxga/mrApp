package com.bsl.mrapp.base;

public class Lock {
    private String LockId;

    public String getLockId() {
        return LockId;
    }

    public Lock(String lockId) {
        LockId = lockId;
    }

    public void setLockId(String lockId) {
        LockId = lockId;
    }
}
