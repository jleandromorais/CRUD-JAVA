package CrudOperations;

import DBProfessor.DBProfe;
import DBProfessor.DadosProfessor;

import java.util.Scanner;

public class ProfessorService implements CrudOperations {
    DBProfe vertodos=new DBProfe();
    private final Scanner sc;

    // Construtor que recebe o Scanner como dependência
    public ProfessorService(Scanner sc) {
        this.sc = sc;  // O Scanner é passado como dependência
    }
    @Override
    public void adicionar(Scanner sc) {
        System.out.println("Qual o nome do professor a ser cadastrado?");
        String nome =sc.next();
        System.out.println("Qual a materia desse professor?");
        String materia=sc.next();
        System.out.println("Qual o salario desse professor?");
        Double salario= sc.nextDouble();

        DadosProfessor dadosProfessor=new DadosProfessor(nome,materia,salario);

        DBProfe.adicionarProf(dadosProfessor);

    }

    @Override
    public void listar() {
        vertodos.listar();

    }

    @Override
    public void atualizar(Scanner sc) {
        System.out.println("Digite o ID do registro que deseja atualizar:");
        int ip = sc.nextInt();
        sc.nextLine();  // Limpa o buffer

        System.out.println("Escolha o campo que deseja atualizar:");
        System.out.println("[1] Nome");
        System.out.println("[2] Materia");
        System.out.println("[3] Salario");
        int escolha = sc.nextInt();
        sc.nextLine(); // Limpa o buffer após o nextInt
        switch (escolha) {
            case 1:
                System.out.println("Digite o novo nome:");
                String novoNome = sc.nextLine(); // Captura corretamente o nome
                if (novoNome.isEmpty()) { // Verifica se o nome não está vazio
                    System.out.println("Nome não pode ser vazio!");
                } else {
                    DBProfe.atualizarCampo("nome", novoNome, ip); // Atualiza o nome
                }
                break;
            case 2:
                System.out.println("Digite a nova matéria:");
                String novaMateria = sc.nextLine();
                if (novaMateria.isEmpty()) { // Verifica se a matéria não está vazia
                    System.out.println("Matéria não pode ser vazia!");
                } else {
                    DBProfe.atualizarCampo("materia", novaMateria, ip); // Atualiza a matéria
                }
                break;
            case 3:
                System.out.println("Digite o novo salário:");
                if (!sc.hasNextDouble()) { // Verifica se a próxima entrada é um número
                    System.out.println("Entrada inválida. Salário deve ser um número.");
                    sc.nextLine(); // Limpa o buffer após entrada inválida
                    break;
                }
                double novoSalario = sc.nextDouble();
                if (novoSalario <= 0) { // Verifica se o salário é positivo
                    System.out.println("Salário deve ser maior que zero.");
                } else {
                    DBProfe.atualizarCampo("salario", String.valueOf(novoSalario), ip); // Atualiza o salário
                }
                sc.nextLine(); // Limpa o buffer após nextDouble()
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }


        @Override
    public void remover(Scanner sc) {
        DBProfe vertodos=new DBProfe();
        vertodos.listar();
        System.out.println("Digite o ID que você quer remover:");
        int id = sc.nextInt();
        DBProfe.removerProfessor(id);
    }
}

