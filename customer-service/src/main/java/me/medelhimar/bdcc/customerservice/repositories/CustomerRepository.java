package me.medelhimar.bdcc.customerservice.repositories;

import me.medelhimar.bdcc.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
