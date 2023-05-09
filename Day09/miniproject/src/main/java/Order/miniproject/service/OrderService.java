package Order.miniproject.service;

import Order.miniproject.domain.Item;
import Order.miniproject.domain.Member;
import Order.miniproject.domain.Order;
import Order.miniproject.domain.OrderItem;
import Order.miniproject.repository.ItemRepository;
import Order.miniproject.repository.MemberRepository;
import Order.miniproject.repository.OrderRepository;
import com.fasterxml.classmate.MemberResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final MemberRepository memberRepository;
  private final ItemRepository itemRepository;

  @Transactional
  public Long saveOrder(Long memberId, Long itemId, int orderQuantity) {
    Member member = memberRepository.findById(memberId);
    Item item = itemRepository.findById(itemId);

    // OrderItem 생성
    //for  (multiple ==> )
    OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), orderQuantity);
    //List<OrderItem> orderItems;
    // OrderItem 생성 후 orderItemlist에 추가, order 생성
    Order order = Order.createOrder(member, orderItem);
    orderRepository.save(order);
    return order.getId();
  }
}
