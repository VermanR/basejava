import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private Resume r;
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    void save(Resume r) {
        for (int i = 0; i < size; i++)
            if (storage[i].uuid.equals(r.uuid)) {
                return;
            }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (uuid == null) {
            return;
        }
        for (int j = 0; j < size; j++) {
            if (uuid.equals(storage[j].uuid)) {
                for (int k = j; k < size - 1; k++) {
                    storage[k] = storage[k + 1];
                }
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     * /
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
