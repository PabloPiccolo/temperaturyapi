package com.example.temperaturyapi.service;
import com.example.temperaturyapi.entity.Pomiar;
import com.example.temperaturyapi.repository.PomiarRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PomiarService {

    private final PomiarRepository repo;

    

    public PomiarService(PomiarRepository repo){
        this.repo = repo;
    }

    public List<Pomiar> pobierzWszystkie() {
    return repo.findAll();
    }

    public void zapisz(Pomiar pomiar) {

    if (pomiar.getTemperatura() < -100 || pomiar.getTemperatura() > 100) {
        throw new IllegalArgumentException("Nieprawidłowa temperatura");
    }

    repo.save(pomiar);
}

    

}