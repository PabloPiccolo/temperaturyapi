package com.example.temperaturyapi.controller;
import com.example.temperaturyapi.service.PomiarService;
import com.example.temperaturyapi.entity.Pomiar;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
public class PomiarController {

    private static final Logger logger = LoggerFactory.getLogger(PomiarController.class);

    private final PomiarService pomiarService;

    public PomiarController(PomiarService pomiarService) {
    this.pomiarService = pomiarService;
    }


    // @Value("${api.key}")
    // private String apiKey;

    // 📡 GET /dane (jak w Node)
    @GetMapping("/dane")
    public List<Pomiar> getDane() {
        logger.info("Pobrano listę pomiarów.");
        return pomiarService.pobierzWszystkie();
    }

    // ➕ POST /dodaj (jak w Node)
    @PostMapping("/dodaj")
    public ResponseEntity<String> dodaj(@RequestBody Pomiar p) {
    // public ResponseEntity<String> dodaj(@RequestHeader("X-API-Key") String key, @RequestBody Pomiar p) {
         logger.info("Próba dodania pomiaru: {}", p.getTemperatura());
        
    //     if (!key.equals(apiKey)) {
    // logger.warn("Niepoprawny klucz API");
    // return ResponseEntity.status(401).body("Brak dostępu");
    //     }

    // if (!pomiarService.zapisz(p)) {
    // logger.warn("Odrzucono nieprawidłową temperaturę: {}", p.getTemperatura());
    // return ResponseEntity.status(400).body("Nieprawidłowa temperatura");
    //     }       

    pomiarService.zapisz(p);
    logger.info("Pomiar zapisany do bazy danych. ID: {}", p.getId());
    return ResponseEntity.ok("OK");
    }

}