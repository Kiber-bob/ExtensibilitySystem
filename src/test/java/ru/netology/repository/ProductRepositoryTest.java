package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

    Product book1 = new Book(1, "book1", 500, "author1");
    Product book2 = new Book(2, "book2", 700, "author2");
    Product TShirt1 = new TShirt(3, "Nike", 900, "USA");
    Product TShirt2 = new TShirt(4, "Puma", 800, "Germany");


    @BeforeEach
    public void SetUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(TShirt1);
        repository.save(TShirt2);

        try {
            repository.removeById(11);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldRemovedByIdExistingItem() {
        repository.removeById(1);
        Product[] expected = {book2, TShirt1, TShirt2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGenerateNotFoundException() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(11);
        });
    }

}