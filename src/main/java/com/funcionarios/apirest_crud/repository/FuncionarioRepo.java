/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.funcionarios.apirest_crud.repository;

import com.funcionarios.apirest_crud.models.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas
 */
public interface FuncionarioRepo extends JpaRepository<Funcionarios, Long>{
    public Funcionarios findById(long id);
}
