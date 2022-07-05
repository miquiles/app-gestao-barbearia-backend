package appgestaobarbeariabackend.service;

import appgestaobarbeariabackend.exception.BadRequestException;
import appgestaobarbeariabackend.model.Person;
import appgestaobarbeariabackend.model.dto.PersonDto;
import appgestaobarbeariabackend.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person saveClient(PersonDto personDto) throws Exception {
        var clientExists = personRepository.findByPersonDocument(personDto.getPersonDocument()).isEmpty();
        if (clientExists) {
            Person person = Person.builder()
                    .firstName(personDto.getFirstName())
                    .secondName(personDto.getSecondName())
                    .bornDate(personDto.getBornDate())
                    .personDocument(personDto.getPersonDocument())
                    .ddd(personDto.getDdd())
                    .numberPhone(personDto.getNumberPhone())
                    .mail(personDto.getMail())
                    .build();
            return this.personRepository.save(person);
        } else {
            throw new Exception("Client exists");
        }
    }

    public Person findClientByDocument(String document) {
        return personRepository.findByPersonDocument(document).orElseThrow(() -> new BadRequestException("Object not found! DOCUMENT: "
                + document + ", Tipo: " + PersonService.class.getName()));
    }

    public void replace(PersonDto personDto, String document) {
        var savedPerson = findClientByDocument(document);
        Person person = Person.builder()
                .id(savedPerson.getId())
                .firstName(personDto.getFirstName())
                .secondName(personDto.getSecondName())
                .bornDate(personDto.getBornDate())
                .personDocument(personDto.getPersonDocument())
                .ddd(personDto.getDdd())
                .numberPhone(personDto.getNumberPhone())
                .mail(personDto.getMail())
                .build();
        personRepository.save(person);
    }


    public void delete(String document) {
        personRepository.delete(findClientByDocument(document));
    }
}
