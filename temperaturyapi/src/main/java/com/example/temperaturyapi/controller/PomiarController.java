package com.example.temperaturyapi.controller;

import com.example.temperaturyapi.entity.Pomiar;
import com.example.temperaturyapi.repository.PomiarRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
public class PomiarController {

    private static final Logger logger = LoggerFactory.getLogger(PomiarController.class);
    private final PomiarRepository repo;

    public PomiarController(PomiarRepository repo) {
        this.repo = repo;
    }

    // 📡 GET /dane (jak w Node)
    @GetMapping("/dane")
    public List<Pomiar> getDane() {
        logger.info("Pobrano listę pomiarów.");
        return repo.findAll();
    }

    // ➕ POST /dodaj (jak w Node)
    @PostMapping("/dodaj")
    public String dodaj(@RequestBody Pomiar p) {
        logger.info("Próba dodania pomiaru: {}", p.getTemperatura());

if (p.getTemperatura() < -100 || p.getTemperatura() > 100) {
    logger.warn("Odrzucono nieprawidłową temperaturę: {}", p.getTemperatura());
    return "Nieprawidlowa temperatura";
}

repo.save(p);

logger.info("Pomiar zapisany do bazy danych. ID: {}", p.getId());

return "OK";
    }
}