package ru.liga.dcs.lesson07.kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LibraryKata02Test {
    @Test
    public void testAggregateBooksInfo() {
        Author author1 = new Author("Author1", Arrays.asList(new Book("Book1", 2001), new Book("Book2", 2005)));
        Author author2 = new Author("Author2", Arrays.asList(new Book("Book3", 2003), new Book("Book2", 2005)));
        List<Author> authors = Arrays.asList(author1, author2);

        List<String> aggregatedBooks = LibraryKata02.aggregateBooksInfo(authors);

        Assertions.assertThat(aggregatedBooks)
                .containsExactly("Book1", "Book3", "Book2")
                .hasSize(3);
    }

}