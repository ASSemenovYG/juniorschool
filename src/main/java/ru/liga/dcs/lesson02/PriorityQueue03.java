package ru.liga.dcs.lesson02;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Цель: Написать программу на Java, реализующую очередь с приоритетами.
 * Эта структура данных должна поддерживать вставку элементов с определенным приоритетом
 * и извлечение элемента с наивысшим приоритетом.
 * Также написать хорошие джавадоки и добавить ещё тестов
 * Чем меньше число тем выше приоритет
 *
 * @param <T> - Object
 */
public class PriorityQueue03<T> {

    //TODO: написать джавадоки
    /*
    Что такое T:
    https://docs.oracle.com/javase/tutorial/java/generics/types.html

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }*/

    //элемент очереди
    class QueueItem {
        private final T t;
        private final int priority;

        QueueItem(T t, int priority) {
            this.t = t;
            this.priority = priority;
        }
    }

    private final LinkedList<QueueItem> queue;

    // Конструктор
    public PriorityQueue03() {
        this.queue = new LinkedList<>();
    }

    // Вставляет элемент с указанным приоритетом
    public void insert(T item, int priority) {
        if (queue.isEmpty()) {
            queue.add(new QueueItem(item, priority));
        } else {
            ListIterator<QueueItem> iterator = queue.listIterator();
            int index = 0;
            while (iterator.hasNext()) {
                index = iterator.nextIndex();
                if (iterator.next().priority <= priority) break;
            }
            //queue.add((index == queue.size() ? queue.size() : (index == 0) ? 1 : index), new QueueItem(item, priority));
            queue.add(((index == 0) ? 1 : index), new QueueItem(item, priority));
        }

    }

    // Извлекает и возвращает элемент с наивысшим приоритетом
    public T extractMax() {
        if (queue.peekFirst() != null) {
            return queue.pollFirst().t;
        } else {
            return null;
        }
    }

    // Проверяет, пуста ли очередь
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
