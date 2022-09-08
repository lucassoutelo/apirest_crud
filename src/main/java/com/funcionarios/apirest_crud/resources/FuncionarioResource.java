/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funcionarios.apirest_crud.resources;

import com.funcionarios.apirest_crud.models.Funcionarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.funcionarios.apirest_crud.repository.FuncionarioRepo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lucas
 */
@RestController
@RequestMapping(value="/api")
public class FuncionarioResource{
    @Autowired
    FuncionarioRepo funcionarioRepo;
    
    /**
     *
     * @return
     */
    //@ModelAttribute("funcionarios")
    @GetMapping("/funcionarios")
    public List<Funcionarios> listaFuncionarios(){
        return funcionarioRepo.findAll();
    }
    
    @GetMapping("/funcionario/{id}")
    public Funcionarios getFuncionario(@PathVariable(value="id")long id){
        return funcionarioRepo.findById(id);
    }
    
    @PostMapping("/funcionario")
    public Funcionarios postFuncionario(Funcionarios funcionario){
        return funcionarioRepo.save(funcionario);
    }
    
    @DeleteMapping("/funcionario")
    public void deleteFuncionario(@RequestBody Funcionarios funcionario){
        funcionarioRepo.delete(funcionario);
    }
    
    @PutMapping("/funcionario")
    public Funcionarios updateFuncionario(@RequestBody Funcionarios funcionario){
        return funcionarioRepo.save(funcionario);
    }
    
}
