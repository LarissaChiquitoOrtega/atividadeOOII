package org.example;

import org.example.dominios.Aluno;
import org.example.dominios.Boletim;
import org.example.dominios.Disciplina;
import org.example.dominios.Nota;
import org.example.repository.BoletimRepository;
import org.example.servicos.EnviarBoletimPorEmail;
import org.example.servicos.EnviarBoletimPorSMS;
import org.example.servicos.ExibirBoletim;
import org.example.servicos.ImprimirBoletim;

/*
Uma escola esta pedindo a sua ajuda para criar um sistema que permita o cadastro de novos alunos,
bem como o lançamento e a exibição das notas de uma determinada disciplina e a exibição do boletim escolar.
A funcionalidade de exibição do boletim permite o envio da mesma para os pais e esta pode ser enviada de três formas.
        Email
        Mensagem no celular
        Impressão do boletim e entrega na reunião de pais e alunos
Construa esse sistema utilizando os príncipios de responsabilidade única e Aberto-fechado do SOLID.

 */
public class Main {
    public static void main(String[] args) {

        //cadastro aluno
        Aluno larissa = new Aluno("Larissa", "HT3000184" ,"larissa.ortega@email.com", "18981246801");
        //cadastra disciplina
        Disciplina matematica = new Disciplina("MAT", "Matemática");
        Disciplina portugues = new Disciplina("POR", "Português");
        //lançar notas de determinada disciplina
        Nota nota1 = new Nota(matematica,10);
        Nota nota2 = new Nota(portugues,9);
        Boletim boletimLarissa1 = new Boletim("1",larissa,nota1);
        Boletim boletimLarissa2 = new Boletim("2",larissa,nota2);
        BoletimRepository.getInstance().save(boletimLarissa1);
        BoletimRepository.getInstance().save(boletimLarissa2);

        // exibir boletim forma 1 - EMAIL
        ExibirBoletim email = new EnviarBoletimPorEmail();
        email.executar(larissa);
        // exibir boletim forma 2 - SMS Celular
        ExibirBoletim sms = new EnviarBoletimPorSMS();
        sms.executar(larissa);
        // impressão boletim
        ExibirBoletim impresso = new ImprimirBoletim();
        impresso.executar(larissa);

    }
}

