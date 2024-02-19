package ru.liga.dcs.lesson02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Класс PriorityQueue03 представляет собой структуру очереди.
 * Этот класс предоставляет методы по встравке элементов в очередь, извлечению элемента с наивысшим приортетом, проверке очереди на пустоту.
 * Чем меньше число тем выше приоритет.
 * При равном приоритете у добавляемого элемента и элемента в очереди, добавление происходит сразу после крайнего элемента с этим приоритетом
 *
 * @param <T> - элемент очереди
 */
public class PriorityQueue03<T> {
    class QueueItem {
        private final T t;
        private final int priority;

        QueueItem(T t, int priority) {
            this.t = t;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        /**
         * @return Индекс элемента в родительском LinkedList
         */
        public int getIndex() {
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
        } else {
            //хешмап K<приоритет>/V<индекс в листе>
            HashMap<Integer, Integer> priorityMap = queue
                    .stream()
                    //оставляем только элементы, у которых приоритет выше чем у добавляемого или равен
                    .filter(queueItem -> queueItem.getPriority() <= priority)
                    .collect(Collectors.toMap(
                            QueueItem::getPriority,
                            QueueItem::getIndex,
                            (first, second) -> second,
                            HashMap::new));

            if (priorityMap.containsKey(priority)) {
                queue.add(priorityMap.get(priority) + 1, new QueueItem(item, priority));
            } else if (priority < queue.peekFirst().getPriority()) {
                //если приоритет выше самого высокого текущего
                queue.addFirst(new QueueItem(item, priority));
            } else if (priority > priorityMap.values().stream().max(Comparator.naturalOrder()).get()) {
                //если нет элементов с добавляемым приоритетом, но есть с приоритетом выше
                queue.add(priorityMap.values().stream().max(Comparator.naturalOrder()).get() + 1, new QueueItem(item, priority));
            } else {
                //добавляемый приоритет ниже всех в очереди - добавляем в конец
                queue.addLast(new QueueItem(item, priority));
            }
        }

    }

    /**
     * Извлекает из очереди и возвращает элемент с наивысшим приоритетом
     *
     * @return Элемент с наивысшим приоритетом, если очередь пуста - возвращает null
     */
    public T extractMax() {
        return (queue.peekFirst() != null) ? queue.pollFirst().t : null;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
