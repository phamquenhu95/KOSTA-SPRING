package Order.miniproject.service;


import Order.miniproject.domain.Item;
import Order.miniproject.domain.Member;
import Order.miniproject.domain.dto.MemberDto;
import Order.miniproject.repository.ItemRepository;
import Order.miniproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

  private final ItemRepository itemRepository;
  @Transactional
  public Long saveItem(Item item) {
    itemRepository.save(item);
    return item.getId();

//    Item item = new Item();
//    item.setId();
//    item.setName();
//    item.setPrice();
//    item.setStockQuantity();
//    itemRepository.save(item);
//    return item.getId();
  }
  public List<Item> findAllItems() {
    return itemRepository.findAll();
  }
  public Item findItem(Long id) {
    return itemRepository.findById(id);
  }
}



