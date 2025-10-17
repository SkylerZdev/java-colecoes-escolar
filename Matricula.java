public class Matricula{
    private int codigoDisciplina;
    private float nota;

    public Matricula(int codigoDisciplina){
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodigoDisciplina(){
        return codigoDisciplina;
    }

    public float getNota(){
        return nota;
    }

    public void setNota(float nota){
        this.nota = nota;
    }
}