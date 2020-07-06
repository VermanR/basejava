package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{
    /*public static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;*/

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = searchResume(resume.getUuid());            //резюме есть в storage?
        if (index == -1) {
            System.out.println("ERROR: resume " + resume.getUuid() + " not found, update command failed");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        int index = searchResume(resume.getUuid());            //резюме нет в storage?
        if (index != -1) {
            System.out.println("ERROR: resume " + resume.getUuid() + " is already there, save command failed");
        } else if (size >= storage.length) {              // проверка на переполнение
            System.out.println("ERROR: array is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    /*public Resume get(String uuid) {
        int index = searchResume(uuid);                       //резюме есть в storage?
        if (index == -1) {
            System.out.println("ERROR: resume " + uuid + " not found, get command failed");
            return null;
        }
        return storage[index];
    }*/

    public void delete(String uuid) {                 //резюме есть в storage?
        int index = searchResume(uuid);
        if (index == -1) {
            System.out.println("ERROR: resume " + uuid + " not found, delete command failed");
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     * /
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected int searchResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
