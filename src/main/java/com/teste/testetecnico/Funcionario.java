/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teste.testetecnico;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author alessandra
 */
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;
    
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    
    public BigDecimal getSalario() {
        return salario;
    }
    
      public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    public String getFuncao() {
        return funcao;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Salário: " + String.format("%,.2f", salario) + ", Função: " + funcao;
    }

}