package com.frc.crudsimples.controllers;

import com.frc.crudsimples.dtos.CrudSimplesDto;
import com.frc.crudsimples.models.CrudSimplesModel;
import com.frc.crudsimples.services.CrudSimplesService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")

public class CrudSimplesController {

    //Construtor, utilizado no lugar de autowired para fazer a injeção das dependencias do Service
    final CrudSimplesService crudSimplesService;

    public CrudSimplesController(CrudSimplesService crudSimplesService) {
        this.crudSimplesService = crudSimplesService;
    }
    //Fim do construtor

    @PostMapping
    public ResponseEntity<Object> savePessoa(@RequestBody @Valid CrudSimplesDto crudSimplesDto){
        var crudSimplesModel = new CrudSimplesModel();
        BeanUtils.copyProperties(crudSimplesDto, crudSimplesModel); //Nesta linha as propriedades do DTO esta sendo copiado pro Model
        return ResponseEntity.status(HttpStatus.CREATED).body(crudSimplesService.save(crudSimplesModel));
    }

    @GetMapping
    public ResponseEntity<List<CrudSimplesModel>> getAllCrudSimples(){
        return ResponseEntity.status(HttpStatus.OK).body(crudSimplesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePessoa(@PathVariable(value = "id") UUID id){
        Optional<CrudSimplesModel> crudSimplesModelOptional = crudSimplesService.findById(id);
        if (!crudSimplesModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(crudSimplesModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOnePessoa(@PathVariable(value = "id") UUID id){
        Optional<CrudSimplesModel> crudSimplesModelOptional = crudSimplesService.findById(id);
        if (!crudSimplesModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        crudSimplesService.delete(crudSimplesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deleteda com sucesso ! ");
    }
}
