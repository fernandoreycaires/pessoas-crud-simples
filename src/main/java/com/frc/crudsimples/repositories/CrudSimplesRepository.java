package com.frc.crudsimples.repositories;

import com.frc.crudsimples.models.CrudSimplesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CrudSimplesRepository extends JpaRepository<CrudSimplesModel, UUID> {
}
