

package com.example.temperaturyapi.repository;

import com.example.temperaturyapi.entity.Pomiar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PomiarRepository extends JpaRepository<Pomiar, Long> {
}