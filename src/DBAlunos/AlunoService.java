package DBAlunos;
import DB.DB;
import CrudOperations.CrudOperations;
import  DB.DbException;

import java.util.Scanner;

public class AlunoService implements CrudOperations {
    private final Scanner sc;

    // Construtor que recebe o Scanner como dependência
    public AlunoService(Scanner sc) {
        this.sc = sc;  // O Scanner é passado como dependência
    }

    @Override
    public void adicionar(Scanner sc) {
        System.out.println("Qual sua nota?");
        double nota = sc.nextDouble();
        sc.nextLine();  // Limpa o buffer
        System.out.println("Qual seu nome?");
        String nome = sc.nextLine();
        System.out.println("Qual sua turma?");
        String turma = sc.nextLine();
        System.out.println("Qual matieria?");
        String materia = sc.nextLine();

        DadosAlunos dados = new DadosAlunos(materia, nota, nome, turma);
        DBAlunos.insertdados(dados);
    }

    @Override
    public void listar() {
        DBAlunos vertodos = new DBAlunos();
        vertodos.mostartodos();
    }

    @Override
    public void atualizar(Scanner sc) {
        System.out.println("Digite o ID do registro que deseja atualizar:");
        int id = sc.nextInt();
        sc.nextLine();  // Limpa o buffer

        System.out.println("Escolha o campo que deseja atualizar:");
        System.out.println("[1] Nome");
        System.out.println("[2] Nota");
        System.out.println("[3] Turma");
        System.out.println("[4] Materia");
        int escolha = sc.nextInt();
        sc.nextLine();  // Limpa o buffer

        switch (escolha) {
            case 1:
                System.out.println("Digite o novo nome:");
                String novoNome = sc.nextLine();
                DBAlunos.atualizarCampo("name", novoNome, id);
                break;
            case 2:
                System.out.println("Digite a nova nota:");
                double novaNota = sc.nextDouble();
                sc.nextLine();  // Limpar o buffer após nextDouble()
                DBAlunos.atualizarCampo("nota", String.valueOf(novaNota), id);
                break;
            case 3:
                System.out.println("Digite a nova turma:");
                String novaTurma = sc.nextLine();
                DBAlunos.atualizarCampo("turma", novaTurma, id);
                break;
            case 4:
                System.out.println("Digite a nova turma:");
                String novaMateria = sc.nextLine();
                DBAlunos.atualizarCampo("materia", novaMateria, id);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }


    @Override
    public void remover(Scanner sc) {
        listar();
        System.out.println("Digite o ID que você quer remover:");
        int id = sc.nextInt();
        DBAlunos.remove(id);
    }
    public void Vermedia(){
        System.out.println("A media dos alunos é:"+ DBAlunos.MostrarMedia());

    }

}
