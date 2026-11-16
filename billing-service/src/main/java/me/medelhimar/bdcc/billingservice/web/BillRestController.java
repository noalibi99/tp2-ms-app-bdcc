package me.medelhimar.bdcc.billingservice.web;

import lombok.AllArgsConstructor;
import me.medelhimar.bdcc.billingservice.entities.Bill;
import me.medelhimar.bdcc.billingservice.feign.CustomerServiceRestClient;
import me.medelhimar.bdcc.billingservice.feign.InventoryServiceRestClient;
import me.medelhimar.bdcc.billingservice.model.Customer;
import me.medelhimar.bdcc.billingservice.repositories.BillRepository;
import me.medelhimar.bdcc.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/api")
//@AllArgsConstructor
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired

    private ProductItemRepository productItemRepository;
    @Autowired

    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired

    private InventoryServiceRestClient inventoryServiceRestClient;
    @GetMapping("/bills")
    public List<Bill> getBills(){

        return billRepository.findAll();
    }
    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer =
                customerServiceRestClient.findCustomerById(bill.getCustomerId());
                bill.setCustomer(customer);

        bill.getProductItems().forEach(pi -> {
         pi.setProduct(
                    inventoryServiceRestClient.findProductById(pi.getProductId()));
        });
        return bill;
}


}
