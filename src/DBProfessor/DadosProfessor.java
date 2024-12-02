package DBProfessor;

public class DadosProfessor {
    private String nome;
    private  String materia;
    private  double salario;

    public DadosProfessor() {
    }

    public DadosProfessor(String nome, String materia, double salario) {
        this.nome = nome;
        this.materia = materia;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
