import DBAlunos.AlunoService;
import CrudOperations.ProfessorService;
import DB.*;
import DBAlunos.DBAlunos;
import DBProfessor.DBProfe;
import Menus.Menus;

import java.util.Scanner;



public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            AlunoService alunoService = new AlunoService(sc);
            DBAlunos vertodos = new DBAlunos();
            ProfessorService professorService = new ProfessorService(sc);
            DBProfe dbProfe = new DBProfe();

            while (true) {
                Menus.Efeite();
                Menus.MenuInicial();
                int n = sc.nextInt();

                switch (n) {

                    case 1:
                        while (true) {
                            Menus.CRUD1();
                            int opcao = sc.nextInt();
                            switch (opcao) {

                                case 1:
                                    professorService.adicionar(sc);
                                    break;
                                case 2:
                                    dbProfe.listar();
                                    break;
                                case 3:
                                    professorService.atualizar(sc);
                                    break;
                                case 4:
                                    dbProfe.listar();
                                    professorService.remover(sc);
                                    break;

                                case 5:

                                    professorService.mudarSalario(sc);
                                    break;
                                case 6:
                                    System.out.println("Saindo do menu de Professores...");
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                            if (opcao == 6) {
                                System.out.println("Voce esta voltando para o menu inicial");
                                break;
                            }
                        }
                        break;


                    case 2:
                        while (true) {
                            Menus.CRUD2();
                            int op = sc.nextInt();
                            switch (op) {

                                case 1:
                                    alunoService.adicionar(sc);
                                    break;
                                case 2:
                                    vertodos.mostartodos();
                                    break;
                                case 3:
                                    vertodos.mostartodos();
                                    alunoService.atualizar(sc);
                                    break;
                                case 4:
                                    vertodos.mostartodos();
                                    alunoService.remover(sc);
                                    break;
                                case 5:
                                    alunoService.Vermedia();
                                    break;
                                case 6:
                                    System.out.println("Voce esta saindo do sistema de aluno!");
                                    break;
                                default:
                                    System.out.println("Opcao invalida");
                                    break;
                            }
                            if (op == 6) {
                                System.out.println("Voltando ao menu");
                                break;
                            }
                        }
                    case 3:System.out.println("Voce ira sair ");

                    if (n==3){
                        return;
                    }
                }
            }
        } finally {
            DB.closeConnection();
        }
    }
}



