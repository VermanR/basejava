package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = searchResume(uuid);                       //резюме есть в storage?
        if (index == -1) {
            System.out.println("ERROR: resume " + uuid + " not found, get command failed");
            return null;
        }
        return storage[index];
    }

    protected abstract int searchResume(String uuid);
}
