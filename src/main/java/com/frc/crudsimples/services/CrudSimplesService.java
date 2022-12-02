package com.frc.crudsimples.services;

import com.frc.crudsimples.models.CrudSimplesModel;
import com.frc.crudsimples.repositories.CrudSimplesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CrudSimplesService {

    //Construtor, utilizado no lugar de autowired para fazer a injeção das dependencias do repository
    final CrudSimplesRepository crudSimplesRepository;

    public CrudSimplesService(CrudSimplesRepository crudSimplesRepository){
        this.crudSimplesRepository = crudSimplesRepository;
    }
    // fim do construtor

    @Transactional
    public CrudSimplesModel save(CrudSimplesModel crudSimplesModel) {
        return crudSimplesRepository.save(crudSimplesModel);
    }

    public List<CrudSimplesModel> findAll(){
        return crudSimplesRepository.findAll();
    }

    public Optional<CrudSimplesModel> findById(UUID id){
        return crudSimplesRepository.findById(id);
    }

    @Transactional
    public void delete(CrudSimplesModel crudSimplesModel){
        crudSimplesRepository.delete(crudSimplesModel);
    }


}
