package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product first = new Book("The Little Prince", 1, 900,"Antoine de Saint-Exupéry");
    private Product second = new Book("Harry Potter and the Prisoner of Azkaban", 2, 1100,"J. K. Rowling");
    private Product third = new Smartphone("Galaxy S21 Ultra", 3, 85000,"Samsung");
    private Product fourth = new Smartphone("Redmi Note 10 Pro", 4, 25000,"Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void addBook() {
        Product fifth = new Book("Blood of Elves", 7, 800,"Andrzej Sapkowski");

        manager.add(fifth);

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void addSmartphone() {
        Product sixth = new Smartphone("iPhone 12 Pro", 8, 100000,"Apple");

        manager.add(sixth);

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, third, fourth, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAll() {
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, third, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        manager.removeById(2);

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, third, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookName() {
        Product[] actual = manager.searchBy("The Little Prince");
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        Product[] actual = manager.searchBy("J. K. Rowling");
        Product[] expected = new Product[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] actual = manager.searchBy("Galaxy S21 Ultra");
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNull() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }
}