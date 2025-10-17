import java.util.Comparator;

//Comparador de nomes de estudantes, necessario para a utilizacao do metodo sort() na ListaEstudantes.

public class ComparadorNome implements Comparator<Estudante> {
    @Override
    public int compare(Estudante e1, Estudante e2){
        return e1.getNome().compareTo(e2.getNome());
    }
}
