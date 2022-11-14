package com.cydeo;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public QueryDemo(AddressRepository addressRepository, BalanceRepository balanceRepository, CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository, DiscountRepository discountRepository, OrderRepository orderRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("findByStreet " + addressRepository.findByStreet("Fordem"));
        System.out.println("findAllByCustomer " + addressRepository.findAllByCustomer(customerRepository.retrieveCustomerByEmail("mokinneally6@zimbio.com")));
        System.out.println("findAllByCustomerAndName " + addressRepository.findAllByCustomerAndName(customerRepository.retrieveCustomerByEmail("mokinneally6@zimbio.com"),"Office"));
        System.out.println("findTop3ByCustomerEmail " + addressRepository.findTop3ByCustomer_Email("mscafecd@topsy.com"));
        System.out.println("findByStreetStartingWith " + addressRepository.findByStreetStartingWith("Map"));
        System.out.println("retrieveByCustomerId " + addressRepository.retrieveByCustomerId(2L));

        System.out.println("existsByCustomerId " + balanceRepository.existsByCustomerId(1L));
        System.out.println("findByCustomerId " + balanceRepository.findByCustomer_Id(1L));
        System.out.println("retrieveTop5Amount " + balanceRepository.retrieveTop5Amount());
        System.out.println("findAllByAmountGreaterThanEqual " + balanceRepository.findAllByAmountGreaterThanEqual(BigDecimal.valueOf(950)));
        System.out.println("retrieveBalanceLessThanAmount " + balanceRepository.retrieveBalanceLessThanAmount(BigDecimal.valueOf(20)));

        System.out.println("countCartItemBy " + cartItemRepository.countCartItemBy());
        System.out.println("retrieveCartItemsByCartStateWithoutDiscount " + cartItemRepository.retrieveCartItemsByCartStateWithoutDiscount("SOLD"));
        System.out.println("retrieveCartItemsByCartStateWithDiscount " + cartItemRepository.retrieveCartItemsByCartStateWithDiscount("SOLD","RATE_BASED"));
        System.out.println("findAllByCart_CartState " + cartItemRepository.findAllByCart_CartState(CartState.CREATED));
        System.out.println("retrieveCartItemsByCartStateAndProductName " + cartItemRepository.retrieveCartItemsByCartStateAndProductName("CREATED","Chocolate - Milk"));

        System.out.println("findAllByCustomerIdAndCartState " + cartRepository.findAllByCustomerIdAndCartState(12L,CartState.CREATED));
        System.out.println("retrieveCartByCustomer " + cartRepository.retrieveCartByCustomer(12L));
        System.out.println("retrieveAllCartByCustomerAndCartStateAndDiscountIsNotNull " + cartRepository.retrieveAllCartByCustomerAndCartStateAndDiscountIsNotNull(12L,"CREATED"));
        System.out.println("findAllByDiscountDiscountType " + cartRepository.findAllByDiscountDiscountType(DiscountType.RATE_BASED));
        System.out.println("findAllByCustomerIdAndCartStateAndDiscountIsNull " + cartRepository.findAllByCustomerIdAndCartStateAndDiscountIsNull(12L,CartState.SOLD));

        System.out.println("retrieveCustomerByEmail " + customerRepository.retrieveCustomerByEmail("twemmh@feedburner.com"));
        System.out.println("findById " + customerRepository.findById(1L));

        System.out.println("findByName " + discountRepository.findByName("50 dollar"));
        System.out.println("findAllByDiscountGreaterThan " + discountRepository.findAllByDiscountGreaterThan(BigDecimal.valueOf(30)));
        System.out.println("findAllByDiscountType " + discountRepository.findAllByDiscountType(DiscountType.RATE_BASED));
        System.out.println("retrieveAllDiscountAmountBetweenRange " + discountRepository.retrieveAllDiscountAmountBetweenRange(BigDecimal.valueOf(10),BigDecimal.valueOf(30)));

        System.out.println("findTop5ByOrderByTotalPriceDesc " + orderRepository.findTop5ByOrderByTotalPriceDesc());
        System.out.println("findAllByCustomerEmail " + orderRepository.findAllByCustomerEmail("cbevissb@godaddy.com"));
        System.out.println("findAllByPaymentPaymentMethod " + orderRepository.findAllByPaymentPaymentMethod(PaymentMethod.BUY_NOW_PAY_LATER));
        System.out.println("existsByCustomerEmail " + orderRepository.existsByCustomerEmail("cbevissb@godaddy.com"));
        System.out.println("retrieveAllOrdersByTotalPriceAndPaidPriceAreEqual " + orderRepository.retrieveAllOrdersByTotalPriceAndPaidPriceAreEqual());
        System.out.println("retrieveAllOrdersByProductName " + orderRepository.retrieveAllOrdersByProductName("Sauerkraut"));
        System.out.println("retrieveAllOrdersByCategoryId " + orderRepository.retrieveAllOrdersByCategoryId(4L));
        System.out.println("retrieveAllOrdersByTotalPriceAndPaidPriceAreNotEqualAndDiscountIsNotNull " + orderRepository.retrieveAllOrdersByTotalPriceAndPaidPriceAreNotEqualAndDiscountIsNotNull());

        System.out.println("findTop3ByOrderByPriceDesc " + productRepository.findTop3ByOrderByPriceDesc());
        System.out.println("findFirstByName " + productRepository.findFirstByName("English Muffin"));
        System.out.println("findAllByCategoryListContaining " + productRepository.findAllByCategoryListContaining(categoryRepository.findByName("Wall Protection")));
        System.out.println("countProductByPriceGreaterThan " + productRepository.countProductByPriceGreaterThan(BigDecimal.valueOf(70)));
        System.out.println("findAllByQuantityIsGreaterThanEqual " + productRepository.findAllByQuantityIsGreaterThanEqual(450));
        System.out.println("retrieveProductListByCategory " + productRepository.retrieveProductListByCategory(4L));
        System.out.println("retrieveProductListByCategoryAndPriceGreaterThan " + productRepository.retrieveProductListByCategoryAndPriceGreaterThan(4L,BigDecimal.valueOf(70)));
        System.out.println("retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity " + productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(BigDecimal.valueOf(50),400));

        System.out.println("findByName " + categoryRepository.findByName("Electrical"));
        System.out.println("findTopByNameOrderByNameDesc " + categoryRepository.findTopByNameOrderByNameDesc("Electrical"));

    }

}
