package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorageId extends AbstractStorage {
    private Map<Integer, Resume> map = new HashMap<>();

    @Override
    protected Object getIndex(Integer id) {
        return id;
    }

    // ?
    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put((Integer) searchKey, r);
    }

    // есть ли данный ключ в HashMap или нет
    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((Integer) searchKey);
    }

    // добавляем новую пару ключ-значение
    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put((Integer) searchKey, r);
    }

    // удаляем по ключу
    @Override
    protected void doDelete(Object searchKey) {
        map.remove((Integer) searchKey);
    }

    // возвращаем значение по ключу
    @Override
    protected Resume doGet(Object searchKey) {
        return map.get((Integer) searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }


    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }

    @Override
    public int size() {
        return map.size();
    }
}
