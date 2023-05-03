package Item.demo;


import Item.demo.repository.ItemRepository;
import Item.demo.repository.JPAItemRepository;
import Item.demo.repository.MemoryItemRepository;
import Item.demo.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
  private EntityManager em;
  @Bean
  public ItemService itemService() {
    return new ItemService(itemRepository());
  }
  @Bean
  public ItemRepository itemRepository() {
//    return new MemoryItemRepository();
    return new JPAItemRepository(em);
  }
}
