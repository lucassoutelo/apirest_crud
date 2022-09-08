/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.funcionarios.apirest_crud.controllers;

import com.funcionarios.apirest_crud.models.Funcionarios;
import com.funcionarios.apirest_crud.repository.FuncionarioRepo;
import com.funcionarios.apirest_crud.resources.FuncionarioResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lucas
 */
@Controller
public class FuncionarioController {
    @Autowired
    //private FuncionarioRepo funcionarioRepo;
    FuncionarioResource fresource;
    
    @GetMapping({"/cadastro", "/", "/list"})
    public ModelAndView mostrarFuncionarios(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("funcionarios", fresource.listaFuncionarios());
        return mav;
    }
    
    @GetMapping("/novoFuncionario")
    public ModelAndView novoFuncionario(){
        ModelAndView mav = new ModelAndView("cadastro");
        Funcionarios funcionario = null;
        mav.addObject("funcionarios", fresource.postFuncionario(funcionario));
        return mav;
    }
}
