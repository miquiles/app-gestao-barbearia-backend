package appgestaobarbeariabackend.repository;

import appgestaobarbeariabackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OsRepository extends JpaRepository<Order,Long> {
    Optional<List<Order>> findByOsDate(LocalDate localDate);



}
