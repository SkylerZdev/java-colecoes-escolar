public class Disciplina {
    private int codigo;
    private String nome;

    public Disciplina(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }

}