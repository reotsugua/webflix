package br.com.webflix.webflix.view;
import br.com.webflix.webflix.controller.FilmeController;
import br.com.webflix.webflix.model.Filme;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static FilmeController controller;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        controller = new FilmeController();

        int opcao;
        do {
            System.out.println("1. Adicionar filme");
            System.out.println("2. Editar filme");
            System.out.println("3. Remover filme");
            System.out.println("4. Listar filmes");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha pendente
                switch (opcao) {
                    case 1:
                        adicionarFilme();
                        break;
                    case 2:
                        editarFilme();
                        break;
                    case 3:
                        removerFilme();
                        break;
                    case 4:
                        listarFilmes();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida!");
                sc.nextLine(); // Consumir entrada inválida pendente
                opcao = -1;
            }

            System.out.println();
        } while (opcao != 0);

        sc.close();
    }

    private static void adicionarFilme() {
        System.out.println("Adicionar filme");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Gênero: ");
        String genero = sc.nextLine();
        int duracao = -1;
        while (duracao <= 0) {
            try {
                System.out.print("Duração (em minutos): ");
                duracao = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha pendente
            } catch (InputMismatchException e) {
                System.out.println("Duração inválida!");
                sc.nextLine(); // Consumir entrada inválida pendente
                duracao = -1;
            }
        }
        System.out.print("Sinopse: ");
        String sinopse = sc.nextLine();
        System.out.print("URL da imagem: ");
        String imagem = sc.nextLine();
        controller.adicionarFilme(titulo, genero, duracao, sinopse, imagem);
        System.out.println("Filme adicionado com sucesso!");
    }

    private static void editarFilme() {
        System.out.println("Editar filme");
        int id = buscarFilmePorId();
        if (id != -1) {
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Gênero: ");
            String genero = sc.nextLine();
            int duracao = -1;
            while (duracao <= 0) {
                try {
                    System.out.print("Duração (em minutos): ");
                    duracao = sc.nextInt();
                    sc.nextLine(); // Consumir quebra de linha pendente
                } catch (InputMismatchException e) {
                    System.out.println("Duração inválida!");
                    sc.nextLine(); // Consumir entrada inválida pendente
                    duracao = -1;
                }
            }
            System.out.print("Sinopse: ");
            String sinopse = sc.nextLine();
            System.out.print("URL da imagem: ");
            String imagem = sc.nextLine();

            controller.editarFilme(id, titulo, genero, duracao, sinopse, imagem);
            System.out.println("Filme editado com sucesso!");
        }
    }

    private static void removerFilme() {
        System.out.println("Remover filme");
        int id = buscarFilmePorId();
        if (id != -1) {
            controller.removerFilme(id);
            System.out.println("Filme removido com sucesso!");
        }
    }

    private static void listarFilmes() {
        System.out.println("Listar filmes");
        String listaFilmes = controller.listarFilmes();
        System.out.print(listaFilmes);
    }

    private static int buscarFilmePorId() {
        int id = -1;
        while (id == -1) {
            try {
                System.out.print("ID do filme: ");
                id = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha pendente
                Filme filme = controller.buscarFilmePorId(id);
                if (filme == null) {
                    System.out.println("Filme não encontrado!");
                    id = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("ID inválido!");
                sc.nextLine(); // Consumir entrada inválida pendente
                id = -1;
            }
        }
        return id;
    }
}
