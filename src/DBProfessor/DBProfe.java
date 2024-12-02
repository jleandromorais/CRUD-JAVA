package DBProfessor;

import DB.DB;
import DB.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBProfe {

    // Método para adicionar um professor
    public static void adicionarProf(DadosProfessor dadosProfessor){
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            String sql = "INSERT INTO funcionarios(nome, materia, salario) VALUES(?, ?, ?)";

            st = conn.prepareStatement(sql);
            st.setString(1, dadosProfessor.getNome());
            st.setString(2, dadosProfessor.getMateria());
            st.setDouble(3, dadosProfessor.getSalario());

            st.executeUpdate();
            System.out.println("Dados salvos com sucesso");
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            // Fechar recursos (PreparedStatement e Connection)
            try {
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new DbException("Erro ao fechar os recursos: " + e.getMessage());
            }
        }
    }

    // Método para listar os professores
    public void listar() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            String sql = "SELECT * FROM funcionarios";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Materia: " + rs.getString("materia"));
                System.out.println("Salario: " + rs.getDouble("salario"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            throw new DbException("Erro ao listar: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close(); // Certifique-se de sempre fechar
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static   void removerProfessor(int id){
        Connection conn=null;
        PreparedStatement st=null;

        try {
            conn=DB.getConnection();

            String sql= "DELETE FROM  funcionarios WHERE id =?";

            st=conn.prepareStatement(sql);
            st.setInt(1,id);

            int rowsAffected= st.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("Registro removido com sucesso! Linhas afetadas: " + rowsAffected);
            } else {
                System.out.println("Nenhum registro encontrado com o ID fornecido.");
            }


        }catch (Exception e){
            throw  new DbException(e.getMessage());
        }
        finally {

        }

    }
    public static void atualizarCampo(String campo, String novoValor, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            // Obtenha a conexão com o banco de dados
            conn = DB.getConnection();

            // Verifica se a conexão foi bem-sucedida
            if (conn == null) {
                System.out.println("Erro: Não foi possível obter a conexão com o banco de dados.");
                return;
            }

            // Valida o campo
            if (!campo.matches("^(nome|materia|salario)$")) {
                System.out.println("Erro: Campo inválido.");
                return;
            }

            // SQL ajustado para a tabela 'funcionarios' e seus campos
            String sql = "UPDATE funcionarios SET " + campo + " = ? WHERE id = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, novoValor); // Define o novo valor para o campo
            st.setInt(2, id); // Define o ID do professor que será atualizado

            // Executa a atualização
            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Atualização realizada com sucesso! Linhas afetadas: " + linhasAfetadas);
            } else {
                System.out.println("Erro: Nenhum registro encontrado com o ID fornecido.");
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                // Fechar a conexão e o PreparedStatement
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


