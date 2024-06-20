/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teste.testetecnico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alessandra
 */
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public String getNome() {
        return nome;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + nome + ", Data de Nascimento: " + dataNascimento.format(formatter);
    }
}