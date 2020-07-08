package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        int index = searchResume(resume.getUuid());            //резюме нет в storage?
        if (index > 0) {
            System.out.println("ERROR: resume " + resume.getUuid() + " is already there, save command failed");
        } else if (size >= storage.length) {              // проверка на переполнение
            System.out.println("ERROR: array is full");
        } else {
            storage[size] = resume;
            size++;
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
