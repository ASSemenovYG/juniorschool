package ru.liga.dcs.lesson01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FolderTreeTest {

    @Test
    public void testFindFoldersContainingPron() {
        FolderTree02 tree = new FolderTree02();
        FolderTree02.Folder root = new FolderTree02.Folder("root");
        FolderTree02.Folder subFolder1 = new FolderTree02.Folder("pronunciation");
        FolderTree02.Folder subFolder2 = new FolderTree02.Folder("documents");
        FolderTree02.Folder subFolder3 = new FolderTree02.Folder("programs");
        root.addChild(subFolder1);
        root.addChild(subFolder2);
        subFolder2.addChild(subFolder3);

        List<String> expected = Arrays.asList("pronunciation");
        List<String> actual = tree.findFoldersContainingPron(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindFoldersContainingPron_NoMatch() {
        FolderTree02 tree = new FolderTree02();
        FolderTree02.Folder root = new FolderTree02.Folder("root");
        FolderTree02.Folder subFolder1 = new FolderTree02.Folder("documents");
        FolderTree02.Folder subFolder2 = new FolderTree02.Folder("reports");
        root.addChild(subFolder1);
        root.addChild(subFolder2);

        List<String> expected = Arrays.asList();
        List<String> actual = tree.findFoldersContainingPron(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindFoldersContainingPron_AllMatch() {
        FolderTree02 tree = new FolderTree02();
        FolderTree02.Folder root = new FolderTree02.Folder("root");
        FolderTree02.Folder subFolder1 = new FolderTree02.Folder("pronunciation");
        FolderTree02.Folder subFolder2 = new FolderTree02.Folder("report");
        FolderTree02.Folder subFolder3 = new FolderTree02.Folder("pronrams");
        root.addChild(subFolder1);
        root.addChild(subFolder2);
        root.addChild(subFolder3);

        List<String> expected = Arrays.asList("pronunciation", "pronrams");
        List<String> actual = tree.findFoldersContainingPron(root);

        assertEquals(expected, actual);
    }
}
