package appgestaobarbeariabackend.repository;

import appgestaobarbeariabackend.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<ServiceOrder,Long> {



}
