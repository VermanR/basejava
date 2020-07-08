package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void save(Resume resume) {
        int index = searchResume(resume.getUuid());            //резюме нет в storage?
        if (index > 0) {
            System.out.println("ERROR: resume " + resume.getUuid() + " is already there, save command failed");
        } else if (size >= storage.length) {              // проверка на переполнение
            System.out.println("ERROR: array is full");
        } else {
            int j = - index - 1;
            System.arraycopy(storage, j, storage, j + 1, size - j);
            storage[j] = resume;
        }
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int searchResume(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
