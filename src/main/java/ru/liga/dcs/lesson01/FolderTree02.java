package ru.liga.dcs.lesson01;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.String;

/**
 * Класс FolderTree02 представляет собой структуру дерева папок.
 * Этот класс предоставляет методы для работы с деревом папок, включая поиск папок по заданному критерию.
 */
public class FolderTree02 {

    static class Folder {
        private final String name;
        private final List<Folder> children;

        Folder(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        void addChild(Folder child) {
            children.add(child);
        }

        public String getName() {
            return name;
        }

        public List<Folder> getChildren() {
            return children;
        }
    }

    /**
     * Возвращает список имен папок, содержащих подстроку "pron".
     *
     * @param folder Корневая папка для поиска.
     * @return Список имен папок.
     */
    public List<String> findFoldersContainingPron(Folder folder) {
        List<String> pronList = new ArrayList<>();
        for (int i = 0; i < folder.children.size(); i++)
            if (folder.children.get(i).name.contains("pron")) pronList.add(folder.children.get(i).name);
        return pronList;
    }

}
