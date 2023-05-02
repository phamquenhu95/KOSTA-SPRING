package Item.demo.repository;

import Item.demo.domain.Item;
import Item.demo.domain.ItemDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ItemRepository {

  // 전체 상품 조회, 상품 등록(이름, 가격, 수량), 상품조회(id), 상품 수정(id,수정하고자 나는 필드들)

public List<Item> findAll();
public Item save(ItemDto itemDto);
public Item findById(Long id);
public void update(Long id, ItemDto itemDto);

}
