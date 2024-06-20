/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.teste.testetecnico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author alessandra
 */
public class Principal {

    public static void main(String[] args) {
        //Inserir todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2), new BigDecimal("2799.93"), "Gerente"));

        
        
        //Remover o funcionário "João" da lista
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        
        //imprimir todos os funcionários com todas as informações
        System.out.println("Funcionários:");
        funcionarios.forEach(System.out::println);
        
        //Aumentar salário dos funcionários em 10%
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        });
        
        //Agrupar funcionários por função em um Map
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        
        //Imprimir os funcionários agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
            System.out.println();
        });
        
        //Imprimir os funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("Funcionários que fazem aniversário em outubro e dezembro:");
        funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonth() == Month.OCTOBER || funcionario.getDataNascimento().getMonth() == Month.DECEMBER)
                .forEach(System.out::println);
        
        //Imprimir o funcionário com a maior idade
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow();
        System.out.println("\nFuncionário mais velho:");
        System.out.println("Nome: " + maisVelho.getNome());
        System.out.println("Idade: " + (LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear()));
        
        //Imprimir a lista de funcionários por ordem alfabética
        List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
        System.out.println("\nFuncionários por ordem alfabética:");
        funcionariosOrdenados.forEach(System.out::println);
        
        //Imprimir o total dos salários dos funcionários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários dos funcionários: R$" + String.format("%,.2f", totalSalarios));
        
        //Imprimir quantos salários mínimos ganha cada funcionário (considerando salário mínimo R$1212.00)
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários em número de salários mínimos:");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
            System.out.println(funcionario.getNome() + ": " + salariosMinimos + " salários mínimos");
        });
    }
}
