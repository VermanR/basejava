package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<Object, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        for (Map.Entry<Object, Resume> pair : map.entrySet()) {   // поиск значения по ключу
            if(pair.getKey().equals(uuid)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {  // ?
        map.put(searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;                  // возвращает true если резюме есть
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {  // добавляем новую пару ключ-значение
        map.put(searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {  // удаляем по ключу
        map.remove(searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {  // возвращаем значение по ключу
        Resume resume = map.get(searchKey);
        return resume;
    }

    @Override
    public void clear() {          // очистить мапу
        map.clear();
    }

    @Override
    public Resume[] getAll() {  // ?      map.values();
        return new Resume[0];
    }

    @Override
    public int size() {      // возвращаем размер мапы
        return map.size();
    }
}
