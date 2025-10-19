public class Matricula{
    private String codigoDisciplina;
    private double nota;

    public Matricula(String codigoDisciplina){
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getCodigoDisciplina(){
        return codigoDisciplina;
    }

    public double getNota(){
        return nota;
    }

    public void setNota(double nota){
        this.nota = nota;
    }
}