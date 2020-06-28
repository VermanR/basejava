package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public void update(Resume r) {                    //резюме есть в storage?
        if (searchResume(r.getUuid()) == 0) {
            System.out.println("ERROR: resume " + r.getUuid() + " not found, get command failed");
            return;
        }
        searchResume(r.getUuid());
    }

    public void save(Resume r) {                     //резюме нет в storage?
        if (searchResume(r.getUuid()) != 0) {
            System.out.println("ERROR: this resume is already there, save command failed");
            return;
        } else if (size == storage.length) {              // проверка на переполнение
            System.out.println("ERROR: array is full");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {                 //резюме есть в storage?
        if (searchResume(uuid) == 0) {
            System.out.println("ERROR: resume " + uuid + " not found, get command failed");
            return null;
        }
        return storage[searchResume(uuid)];
        //searchResume(uuid);
    }

    public void delete(String uuid) {                 //резюме есть в storage?
        if (searchResume(uuid) == 0) {
            System.out.println("ERROR: resume " + uuid + " not found, delete command failed");
            return;
        } else {
            for (int j = 0; j < size; j++) {
                if (uuid.equals(storage[j].getUuid())) {
                    if (size - 1 - j >= 0) System.arraycopy(storage, j + 1, storage, j, size - 1 - j);
                    size--;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     * /
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int searchResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return 0;
    }
}
