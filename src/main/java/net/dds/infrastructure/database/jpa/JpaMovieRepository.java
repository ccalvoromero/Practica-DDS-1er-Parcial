package net.dds.infrastructure.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository<JpaMovie, Long> {

}