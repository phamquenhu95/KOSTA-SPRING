package Order.miniproject.service;

import Order.miniproject.domain.Album;
import Order.miniproject.domain.Book;
import Order.miniproject.domain.Item;
import Order.miniproject.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {
  @Autowired
  private ItemRepository itemPepository;

  @Test
  void saveItem() {
    //given

//    Book book = new Book();
//    book.setName("test");
//    book.setPrice(1000);
//    book.setStockQuantity(10);
//    book.setAuthor("author");
//    book.setIsbn("test");

    Album album = new Album();
    album.setName("test");
    album.setPrice(1000);
    album.setStockQuantity(10);
    album.setArtist("artist");
    album.setEtc("test");
    //when
    itemPepository.save(album);
    //then
    Item findItem = itemPepository.findById(album.getId());
    System.out.println("album id : " + findItem);

    assertThat(findItem).isEqualTo(album);
  }

  @Test
  void findAllItems() {
  }

  @Test
  void findItem() {
  }
}