package DBAlunos;

public class DadosAlunos {
    private String name;
    private  String materia;
    private String turma;
    private  double nota;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public DadosAlunos(String materia, double nota, String name, String turma) {
        this.materia = materia;
        this.nota = nota;
        this.name = name;
        this.turma = turma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
