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

    public void update(Resume resume) {
        int tmp = searchResume(resume.getUuid());            //резюме нет в storage?
        if (tmp != -1) {
            System.out.println("ERROR: resume " + resume.getUuid() + " not found, update command failed");
        } else {
            storage[size] = resume;
        }
    }

    public void save(Resume resume) {
        int tmp = searchResume(resume.getUuid());            //резюме нет в storage?
        if (tmp != -1) {
            System.out.println("ERROR: resume " + resume.getUuid() + " is already there, save command failed");
        } else if (size == storage.length) {              // проверка на переполнение
            System.out.println("ERROR: array is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int tmp = searchResume(uuid);                       //резюме есть в storage?
        if (tmp == -1) {
            System.out.println("ERROR: resume " + uuid + " not found, get command failed");
            return null;
        }
        return storage[tmp];
    }

    public void delete(String uuid) {                 //резюме есть в storage?
        if (searchResume(uuid) == -1) {
            System.out.println("ERROR: resume " + uuid + " not found, delete command failed");
        } else {
            System.arraycopy(storage, 0, storage, 0, size--);
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
        return -1;
    }
}
