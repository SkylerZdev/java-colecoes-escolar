import java.util.Objects;

public class Disciplina {
    private String codigo;
    private String nome;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    //Retorna verdadeiro se comparar duas disciplinas iguais, mesmo se forem objetos diferentes, comparando pelo codigo.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
         Disciplina that = (Disciplina) o;
        return Objects.equals(codigo, that.codigo);
    }

    //Retorna o hashCode do codigo ao invés do objeto.
    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ")";
    }
}