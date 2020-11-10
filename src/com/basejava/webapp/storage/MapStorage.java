package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    // ?
    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put((String) searchKey, r);
    }

    // есть ли данный ключ в HashMap или нет
    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((String) searchKey);
    }

    // добавляем новую пару ключ-значение
    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put((String) searchKey, r);
    }

    // удаляем по ключу
    @Override
    protected void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }

    // возвращаем значение по ключу
    @Override
    protected Resume doGet(Object searchKey) {
        return map.get((String) searchKey);
    }

    // очистить мапу
    @Override
    public void clear() {
        map.clear();
    }

    // ?      map.values();
    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    // возвращаем размер мапы
    @Override
    public int size() {
        return map.size();
    }
}
