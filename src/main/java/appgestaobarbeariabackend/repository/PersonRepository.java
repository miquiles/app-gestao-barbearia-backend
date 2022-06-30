package appgestaobarbeariabackend.repository;

import appgestaobarbeariabackend.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByPersonDocument(String document);

    @Modifying
    @Query(nativeQuery = true, value = "update Person set firstName = :firstName, secondName = :secondName, " +
            "bornDate = :bornDate, document = :document, ddd = :ddd, numberPhone = :numberPhone, " +
            "mail = :mail WHERE id = :id")
    void updatePerson(@Param("id") Long id, @Param("firstName") String firstName, @Param("secondName") String secondName,
                      @Param("bornDate") String bornDate, @Param("document") String document, @Param("ddd") String ddd,
                      @Param("numberPhone") String numberPhone, @Param("mail") String mail);
}
