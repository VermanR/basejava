package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return map.get(uuid);
    }

    // ?
    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put(searchKey, r);
    }

    // возвращает true если резюме есть
    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    // добавляем новую пару ключ-значение
    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put(searchKey, r);
    }

    // удаляем по ключу
    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey);
    }

    // возвращаем значение по ключу
    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey);
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
