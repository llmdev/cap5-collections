package br.com.gulliver.view;

import br.com.gulliver.beans.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AvaliarParceiro {

    public ArrayList<Parceiro> parceiros = new ArrayList<Parceiro>();
    public Usuario usuario;
    protected Scanner leitor = new Scanner(System.in);

    public AvaliarParceiro() {
        Estado estado = new Estado(1, "Sao Paulo", "SP");
        Cidade cidade = new Cidade(1, "Sao Paulo", "SP");
        Endereco enderecoBarDoZe = new Endereco(1, "Avenida dos Amigos", "12345-123","123","Bairro viagem", "Casa Unica",estado, cidade);
        Endereco enderecoRestauranteMaria = new Endereco(1, "Avenida dos Amigos da maria", "12345-123","124","Bairro viagem", "Casa Unica",estado, cidade);

        this.parceiros.add(new Parceiro(1, "Bar do Ze" , "0000000/0000-00", "byecodeLogoMarca", "bardoze@bardoze.com.br", "Bar do ze um local Agradavel", enderecoBarDoZe));
        this.parceiros.add(new Parceiro(2, "Restaurante da Maria" , "0000000/0000-10", "byecodeLogoMarca", "mariarestaurante@mariarestaurante.com.br", "Restaurante 5 estrelas", enderecoRestauranteMaria));
    }

    public void criandoUsuarioEavaliando() {
        System.out.println("Bem vindo ao sistema de avaliacao Gulliver, insira seu nome:");

        String nomeUsuario = leitor.nextLine();
        this.usuario = new Usuario(1, nomeUsuario);

        this.iniciarAvaliacao();

    }


    public void iniciarAvaliacao() {

        this.opcoesParaAvaliar();
        Integer parceiroParaAvaliarIndex = leitor.nextInt();

        this.criarAvaliacao(parceiros.get(parceiroParaAvaliarIndex));

        this.etapaFinal();
    }

    public void opcoesParaAvaliar() {
        System.out.println("Escolha um dos parceiros abaixo para avaliar:");
        for(Parceiro parceiro:parceiros) {
            System.out.println(parceiro.imprimirParaAvaliar(parceiros.indexOf(parceiro)));
        }
        System.out.println("Digite a opcao desejada:");
    }

    public void criarAvaliacao(Parceiro parceiro) {
        System.out.println("Vamos avaliar o parceiro: " + parceiro.getNomeFantasia());
        System.out.println("De 0 a 5 qual a sua nota para este parceiro ?");
        int nota = leitor.nextInt();

        System.out.println("Qual mensagem gostaria de deixar sobre este parceiro ? \n");
        String mensagem="";

        mensagem= leitor.nextLine();
        mensagem+=leitor.nextLine();


        LocalDate diaHoje = LocalDate.now();
        Avaliacao novaAvaliacao = new Avaliacao(1, mensagem, diaHoje, nota, this.usuario );

        parceiro.avaliar(novaAvaliacao);

        System.out.println("Avalicao criada com sucesso!");
    }

    public void exibirAvaliacoes() {
        for(Parceiro parceiro:parceiros) {
            parceiro.exibirAvaliacoes();
        }

        this.etapaFinal();
    }

    public void etapaFinal() {
        System.out.println("\n\n Deseja criar uma nova avaliacao ou exibir avaliacoes ? \n 1 - para nova avaliacao \n 2 - Para exibir Avaliacoes");
        int opcao = leitor.nextInt();

        if (opcao == 1) {
            this.iniciarAvaliacao();
        } else {
            this.exibirAvaliacoes();
        }

    }
}
