import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

// Lista que armazena e organiza Estudantes

public class ListaEstudantes {

    //Cria uma nova ArrayList que armazena Estudantes
    private final ArrayList<Estudante> lista = new ArrayList<>();

    //Metodo Basico que Adiciona um Estudante na lista. O(1)
    void adicionarEstudante(Estudante e) {
        lista.add(e);
    }

    //Metodo que percorre a lista removendo todos os estudantes que tiverem um Id especifico. O(n)
    void removerEstudantePorId(int id) {
        Iterator<Estudante> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
            }
        }
    }

    //Metodo que retorna um estudante em um indice especifico. O(1)
    Estudante obterEstudantePorIndice(int indice) {
        if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException("Indice invalido: " + indice + " (tamanho: " + lista.size() + ")");
        }
        return lista.get(indice);
    }

    //Metodo que retorna uma lista encadeada de todos os Estudantes que tem o nome escrito. case-insensitive
    LinkedList<Estudante> buscarEstudantesPorNome(String substring) {
        if (substring == null || substring.length() < 1) {
            throw new IllegalArgumentException("Substring invalida (min 1 caractere)");
        }
        String sub = substring.toLowerCase(Locale.ROOT);
        LinkedList<Estudante> busca = new LinkedList<>();
        for (Estudante estudante : lista) {
            if (estudante.getNome() != null && estudante.getNome().toLowerCase(Locale.ROOT).contains(sub)) {
                busca.add(estudante);
            }
        }
        return busca;
    }

    //Metodo que ordena a lista pelo nome alfabeticamente, utilizando um Comparador. O(N log N)
    void ordenarEstudantesPorNomes() {
        lista.sort(new ComparadorNome());
    }

    //Metodo que imprime os atributos de todos os estudantes da lista. O(n)
    void imprimirLista() {
        if (lista.isEmpty()) {
            System.out.println("A Lista esta vazia");
            return;
        }
        for (Estudante estudante : lista) {
            System.out.println("Nome: " + estudante.getNome() + " || Id: " + estudante.getId());
        }
    }
    //Metodo que retorna uma copia da lista de estudantes como um ArrayList 
    public ArrayList<Estudante> obterTodos() {
        return new ArrayList<>(lista);
    }

}