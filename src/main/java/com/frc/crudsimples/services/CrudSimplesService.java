package com.frc.crudsimples.services;

import com.frc.crudsimples.models.CrudSimplesModel;
import com.frc.crudsimples.repositories.CrudSimplesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


}
