package main;

import caracteristicas.Aluno;
import caracteristicas.Pessoa;

public class Main {
    public static void main(String[] args) {
        // Criando novo objeto e dando valor a eles
        Aluno a1 = new Aluno("Jonathan Calleri", "123.456.789-09", 70, 1.75, 9, 76);
        Aluno a2 = new Aluno("Welligton Rato", "987.654.321-00", 60, 1.60, 8, 80);
        
        // Exibindo a descrição da pessoa e do aluno
        System.out.println(a1.descricao());
        System.out.println(a2.descricao());
    }
}