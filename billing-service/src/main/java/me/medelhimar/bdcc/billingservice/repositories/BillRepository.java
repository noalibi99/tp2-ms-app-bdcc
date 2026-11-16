package me.medelhimar.bdcc.billingservice.repositories;

import me.medelhimar.bdcc.billingservice.entities.Bill;
import me.medelhimar.bdcc.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface BillRepository extends JpaRepository<Bill, Long> {
}
