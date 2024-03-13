package ru.liga.dcs.lesson03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Класс представляет собой реализацию кэша, который удаляет наименее недавно использованные элементы,
 * когда достигнута его максимальная ёмкость.
 * The Least Recently Used (LRU)
 */
public class LruCache05 {
    private final Map<String, Object> cache;
    private final int capacity;
    private final LinkedList<String> usageHistory;

    /**
     * Конструктор для создания кэша с определённой ёмкостью.
     *
     * @param capacity Максимальная ёмкость кэша.
     */
    public LruCache05(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.usageHistory = new LinkedList<>();
    }

    /**
     * Получает значение по ключу из кэша.
     *
     * @param key Ключ, по которому нужно получить значение.
     * @return Значение, соответствующее ключу, или {@code null}, если ключ не найден.
     */
    public Object get(String key) {
        if (!cache.containsKey(key)) return null;
        this.moveKeyToTop(key);
        return cache.get(key);
    }

    /**
     * Добавляет пару ключ-значение в кэш. Если кэш достигает своей максимальной ёмкости,
     * наименее недавно использованный элемент удаляется.
     *
     * @param key   Ключ для добавляемого значения.
     * @param value Значение, которое нужно добавить.
     */
    public void put(String key, Object value) {
        cache.put(key, value);
        if (usageHistory.contains(key)) this.moveKeyToTop(key);
        else this.addNewKeyAndRemoveLeastUsed(key);
    }

    /**
     * Перемещает ключ использованного элемента наверх в usageHistory
     *
     * @param key Ключ для добавляемого/извлекаемого значения.
     */
    private void moveKeyToTop(String key) {
        usageHistory.remove(key);
        usageHistory.addFirst(key);
    }

    /**
     * Добавляет новый ключ в начало usageHistory и удаляет из кеша самый старый использованный элемент при переполнении ёмкости
     *
     * @param key Ключ для добавляемого значения.
     */
    private void addNewKeyAndRemoveLeastUsed(String key) {
        if (capacity - usageHistory.size() > 0) usageHistory.addFirst(key);
        else {
            cache.remove(usageHistory.removeLast());
            usageHistory.addFirst(key);
        }
    }
}
