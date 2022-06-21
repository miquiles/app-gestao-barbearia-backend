package appgestaobarbeariabackend.service;

import appgestaobarbeariabackend.model.ServiceOrder;
import appgestaobarbeariabackend.model.dto.Payload;
import appgestaobarbeariabackend.repository.OsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OSService {

    private OsRepository osRepository;

    public ServiceOrder orderSave(ServiceOrder serviceOrder){
        return osRepository.save(serviceOrder);
    }

    public List<ServiceOrder> findAll(){
        return this.osRepository.findAll();
    }

}
