package ru.liga.dcs.lesson02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс PriorityQueue03 представляет собой структуру очереди.
 * Этот класс предоставляет методы по вставке элементов в очередь, извлечению элемента с наивысшим приоритетом, проверке очереди на пустоту.
 * Чем меньше число тем выше приоритет.
 * При равном приоритете у добавляемого элемента и элемента в очереди, добавление происходит сразу после крайнего элемента с этим приоритетом
 *
 * @param <T> - элемент очереди
 */
public class PriorityQueue03<T> {
    class QueueItem {
        private final T item;
        private final int priority;

        QueueItem(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        private int getPriority() {
            return priority;
        }

        /**
         * @return Индекс элемента в родительском LinkedList
         */
        private int getIndex() {
            return queue.indexOf(this);
        }
    }

    private final LinkedList<QueueItem> queue;

    public PriorityQueue03() {
        this.queue = new LinkedList<>();
    }

    /**
     * Добавление элемента в очередь
     * Если уже есть элементы с передаваемым приоритетом, добавление происходит сразу после крайнего элемента с этим приоритетом
     *
     * @param item     - элемент очереди
     * @param priority - приоритет элемента
     */
    public void insert(T item, int priority) {
        if (queue.isEmpty()) {
            queue.add(new QueueItem(item, priority));
            return;
        }
        tryAddItemAfterExistingPriority(item, priority);
    }

    /**
     * Извлекает из очереди и возвращает элемент с наивысшим приоритетом
     *
     * @return Элемент с наивысшим приоритетом, если очередь пуста - возвращает null
     */
    public T extractMax() {
        return (queue.peekFirst() != null) ? queue.pollFirst().item : null;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Возвращает HashMap с элементами очереди, у которых приоритет выше либо равен добавляемому.
     * Для каждого приоритета из очереди в HashMap попадает <strong>только элемент с крайним индексом</strong>
     * (если элементов с таким приоритетом в очереди больше одного).
     *
     * @param priority Приоритет добавляемого элемента
     * @return HashMap K<приоритет>/V<индекс в очереди>
     */
    private Map<Integer, Integer> getPriorityMap(int priority) {
        return queue.stream()
                .filter(queueItem -> queueItem.getPriority() <= priority)
                .collect(Collectors.toMap(
                        QueueItem::getPriority,
                        QueueItem::getIndex,
                        (first, second) -> second,
                        HashMap::new));
    }

    /**
     * Проверяет, есть ли в очереди элемент с таким же приоритетом, что и добавляемый.
     * Если есть, добавляет новый элемент в очередь после крайнего элемента с таким же приоритетом.
     * Иначе, вызывает {@link #tryAddItemWithTopPriority(T item, int priority, Map priorityMap)}
     *
     * @param item     - элемент очереди
     * @param priority - приоритет элемента
     */
    private void tryAddItemAfterExistingPriority(T item, int priority) {
        Map<Integer, Integer> priorityMap = this.getPriorityMap(priority);
        if (priorityMap.containsKey(priority)) {
            queue.add(priorityMap.get(priority) + 1, new QueueItem(item, priority));
            return;
        }
        tryAddItemWithTopPriority(item, priority, priorityMap);
    }

    /**
     * Проверяет приоритет первого элемента в очереди.
     * Если он ниже, чем добавляемый, добавляет новый элемент в очередь в начало.
     * Иначе, вызывает {@link #tryAddItemAfterCurrentTopPriority(T item, int priority, Map priorityMap)}
     *
     * @param item        - элемент очереди
     * @param priority    - приоритет элемента
     * @param priorityMap - HashMap, возвращаемый {@link #getPriorityMap(int priority)}
     */
    private void tryAddItemWithTopPriority(T item, int priority, Map<Integer, Integer> priorityMap) {
        if (priority < queue.peekFirst().getPriority()) {
            queue.addFirst(new QueueItem(item, priority));
            return;
        }
        tryAddItemAfterCurrentTopPriority(item, priority, priorityMap);
    }

    /**
     * Проверяет, есть ли в очереди элемент с таким же приоритетом, что и добавляемый.
     * Если есть, добавляет новый элемент в очередь после крайнего элемента с таким же приоритетом.
     * Иначе, добавляет элемент в конец очереди
     *
     * @param item        - элемент очереди
     * @param priority    - приоритет элемента
     * @param priorityMap - HashMap, возвращаемый {@link #getPriorityMap(int priority)}
     */
    private void tryAddItemAfterCurrentTopPriority(T item, int priority, Map<Integer, Integer> priorityMap) {
        int lastIndexTopPriority = priorityMap.values().stream()
                .max(Comparator.naturalOrder())
                .get();
        if (priority > lastIndexTopPriority) {
            queue.add(lastIndexTopPriority + 1, new QueueItem(item, priority));
            return;
        }
        queue.addLast(new QueueItem(item, priority));
    }
}
