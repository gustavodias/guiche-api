package com.jvge.guicheapi.repository;

import com.jvge.guicheapi.model.Guiche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuicheRepository extends JpaRepository<Guiche, Long> {
}
