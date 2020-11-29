package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getIndex(String uuid) {
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

    /*
   @Override
   public Resume[] getAll() {
   List<Resume> list = new ArrayList<>(map.values());
   Collections.sort(list);
   return list.toArray(new Resume[list.size()]);
   }
   */

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }

    // возвращаем размер мапы
    @Override
    public int size() {
        return map.size();
    }
}

