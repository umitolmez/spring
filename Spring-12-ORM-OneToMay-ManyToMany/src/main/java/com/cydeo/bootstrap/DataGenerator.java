package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.*;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository, ItemRepository itemRepository, CartRepository cartRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Payment payment1 = new Payment(LocalDate.of(2022, 4, 19), new BigDecimal(150000), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal(140000), new BigDecimal(10000),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022, 4, 25), new BigDecimal(100000), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal(90000), new BigDecimal(5000),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        Merchant merchant1 = new Merchant("AmazonSubMerch", "M123", new BigDecimal("0.25"), new BigDecimal("3,25"), 5);

        Customer customer1 = new Customer("Msmith", "Mike", "Smith", "msmith@gmail.com", "CA");

        Item item1 = new Item("Milk", "m01");
        Item item2 = new Item("Sugar", "s01");
        Item item3 = new Item("Bread", "b01");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.setItemList(Arrays.asList(item1,item2, item3));
        cart2.setItemList(Arrays.asList(item1,item2));

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);

        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);



        customerRepository.save(customer1);

        merchantRepository.save(merchant1);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
    }
}
