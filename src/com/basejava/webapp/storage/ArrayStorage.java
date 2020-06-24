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
        if (r == null) {
            System.out.println("ERROR: no resume found, update command failed");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[size] = r;
            }
        }
    }

    public void save(Resume r) {                     //резюме нет в storage?
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                //  if (storage[i].getUuid().equals(r.setUuid())) {
                System.out.println("ERROR: this resume is already there, save command failed");
                return;
            } else if (size == storage.length) {              // проверка на переполнение
                System.out.println("ERROR: array is full");
            } else {
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {                 //резюме есть в storage?
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("ERROR: no resume found, get command failed");
        return null;
    }

    public void delete(String uuid) {                 //резюме есть в storage?
        if (uuid == null) {
            System.out.println("ERROR: no resume found, delete command failed");
            return;
        }
        for (int j = 0; j < size; j++) {
            if (uuid.equals(storage[j].getUuid())) {
                for (int k = j; k < size - 1; k++) {
                    storage[k] = storage[k + 1];
                }
                size--;
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
}
