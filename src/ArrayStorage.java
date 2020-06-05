import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                return;
            }
         storage[i] = r;

        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int size = 0;
        for (int j = 0; j < storage.length; j++) { //поиск удаляемого элемента
            if (uuid.equals(storage[j].uuid))
                break;
            for (int k = j; k < size - 1; k++) //сдвиг последующих элементов
                storage[k] = storage[k + 1];
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        return storage.length;
    }
}
