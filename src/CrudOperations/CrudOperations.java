package CrudOperations;

import java.util.Scanner;

public interface CrudOperations {
    void adicionar(Scanner sc);  // Método para adicionar um novo registro
    void listar();               // Método para listar registros
    void atualizar(Scanner sc);  // Método para atualizar um registro existente
    void remover(Scanner sc);
}
