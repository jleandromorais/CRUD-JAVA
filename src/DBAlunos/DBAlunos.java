package DBAlunos;

import DB.DB;
import DB.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAlunos {

    // Método para mostrar todos os registros
    public void mostartodos() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement(); // Cria um objeto Statement para enviar comandos SQL
            rs = st.executeQuery("SELECT * FROM aluno"); // Consulta todos os registros

            // Loop para iterar sobre os resultados
            while (rs.next()) {
                // Imprime os dados de cada registro
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("name"));
                System.out.println("Nota: " + rs.getDouble("nota"));
                System.out.println("Turma: " + rs.getString("turma"));
                System.out.println("Aprovado: " + rs.getString("aprovado"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para inserir novos dados
    public static void insertdados(DadosAlunos dados) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            String sql = "INSERT INTO aluno(name,nota,turma,aprovado) VALUES(?,?,?,?)";

            st = conn.prepareStatement(sql);
            st.setString(1, dados.getName());
            st.setDouble(2, dados.getNota());
            st.setString(3, dados.getTurma());
            st.setString(4, dados.getMateria());

            st.executeUpdate();
            System.out.println("Dados inseridos com sucesso!");
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para remover um registro
    public static void remove(int ip) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            String sql = "DELETE FROM aluno WHERE id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, ip);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registro removido com sucesso! Linhas afetadas: " + rowsAffected);
            } else {
                System.out.println("Nenhum registro encontrado com o ID fornecido.");
            }

        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para atualizar um campo de um registro
    public static void atualizarCampo(String campo, String novoValor, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            String sql = "UPDATE aluno SET " + campo + " = ? WHERE id = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, novoValor);
            st.setInt(2, id);

            int linhasAfetadas = st.executeUpdate();
            System.out.println("Atualização realizada com sucesso! Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
