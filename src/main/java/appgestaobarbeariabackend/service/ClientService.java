package appgestaobarbeariabackend.service;

import appgestaobarbeariabackend.model.Client;
import appgestaobarbeariabackend.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientPersonRepository;

    public Client saveClient(Client client) throws Exception {
        var clientExists = clientPersonRepository.findByDocument(client.getDocument()).isEmpty();
        if (clientExists){
            return this.clientPersonRepository.save(client);
        }else {
            throw new Exception("Client exists");
        }
    }

    public Optional<Client> findClientByDocument(String document){
        return this.clientPersonRepository.findByDocument(document);
    }

    public List<Client> findAllClients(){
        return clientPersonRepository.findAll();
    }

}
