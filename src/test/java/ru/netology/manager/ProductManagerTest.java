package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final Product firstProduct = new Product(1,"firstProduct_me", 1);
    private final Product secondProduct = new Product(2,"secondProduct", 2);
    private final Book firstBook = new Book(3,"firstBook_me",3, "me");
    private final Book secondBook = new Book(4,"secondBook",4, "you");
    private final Smartphone firstSmartphone = new Smartphone(5,"firstBook",5, "me");
    private final Smartphone secondSmartphone = new Smartphone(6,"secondBook",6, "you");

    private final ProductManager manager = new ProductManager(new ProductRepository());

    @BeforeEach
    void setUp() {
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmartphone);
        manager.save(secondSmartphone);

    }
    @Test
    void shouldReturnByText() {

        Product[] expected = {firstProduct, firstBook, firstSmartphone};
        Product[] actual = manager.searchBy("me");

        assertArrayEquals(expected, actual);
    }


}