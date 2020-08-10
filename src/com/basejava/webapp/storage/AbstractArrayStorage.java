package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = searchResume(resume.getUuid());            //резюме есть в storage?
        if (index < 0) {
            System.out.println("ERROR: resume " + resume.getUuid() + " not found, update command failed");
        } else {
            storage[index] = resume;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     * /
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void save(Resume resume) {
        int index = searchResume(resume.getUuid());            //резюме нет в storage?
        if (index >= 0) {
            System.out.println("ERROR: resume " + resume.getUuid() + " is already there, save command failed");
        } else if (size >= STORAGE_LIMIT) {              // проверка на переполнение
            System.out.println("ERROR: array is full");
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {                 //резюме есть в storage?
        int index = searchResume(uuid);
        if (index < 0) {
            System.out.println("ERROR: resume " + uuid + " not found, delete command failed");
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        int index = searchResume(uuid);                       //резюме есть в storage?
        if (index < 0) {
            System.out.println("ERROR: resume " + uuid + " not found, get command failed");
            return null;
        }
        return storage[index];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract int searchResume(String uuid);
}
