package ru.liga.dcs.lesson01;


import java.util.Arrays;
import java.util.*;

public class DuplicateRemover01 {

    public List<String> removeDuplicates(List<String> originalList) {
        if (originalList != null) {
            //при попытке сделать remove из originalList ошибка UnsupportedOperationException, т.к. в тесте создается Unmodifiable collection
            List<String> returnList = new ArrayList<>(originalList);
            String currEl = null;
            List<String> copyList;
            for (int i = 0; i < returnList.size(); i++) {
                currEl = returnList.get(i);
                copyList = returnList.subList(i + 1, returnList.size());
                if (copyList.contains(currEl)) {
                    for (int y = i + 1; y < returnList.size(); y++) {
                        if (Objects.equals(returnList.get(y), currEl)) returnList.remove(y);
                    }
                }
            }
            return returnList;
        } else {
            return null;
        }
    }
}
