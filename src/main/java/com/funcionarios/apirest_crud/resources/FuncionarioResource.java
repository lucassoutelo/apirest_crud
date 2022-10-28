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
import com.funcionarios.apirest_crud.repository.FuncionarioRepo;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lucas
 */
@Controller
public class FuncionarioResource{
    
    @Autowired
    private FuncionarioRepo funcionarioRepo;
   
    @GetMapping({"/mostrarFuncionarios", "/", "/list"})
    public ModelAndView mostrarFuncionarios(){
        ModelAndView mav = new ModelAndView("index");
        List<Funcionarios> lista = funcionarioRepo.findAll();
        mav.addObject("funcionarios", lista);
        return mav;
    }
    
    @GetMapping("/novoFuncionario")
    public ModelAndView novoFuncionario(Funcionarios funcionario){
        ModelAndView mav = new ModelAndView("cadastro");
        mav.addObject("funcionarios", funcionario);
        return mav;
    }
    
    @PostMapping("/salvarFuncionario")
        public String salvarFuncionario(@Valid @ModelAttribute Funcionarios funcionario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cadastro";  
        }
        funcionarioRepo.save(funcionario);
        return "redirect:/mostrarFuncionarios";
    }
    
    @GetMapping("/atualizarFuncionario")
        public ModelAndView atualizarFuncionario(@RequestParam Long funcionarioId){
        ModelAndView mav = new ModelAndView("cadastro");
        Funcionarios funcionario = funcionarioRepo.findById(funcionarioId).get();
        mav.addObject("funcionarios", funcionario);
        return mav;
    }
    
    @PutMapping("/alterarFuncionario")
        public String alterarFuncionario(@ModelAttribute Funcionarios funcionario){
        funcionarioRepo.save(funcionario);
        return "redirect:/mostrarFuncionarios";
    }
    
    @GetMapping("/excluirFuncionario")
    public String excluirFuncionario(@RequestParam Long funcionarioId){
        funcionarioRepo.deleteById(funcionarioId);
        return "redirect:/mostrarFuncionarios";
    }
    
    
}
