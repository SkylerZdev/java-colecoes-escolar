import java.util.ArrayList;
import java.util.LinkedList;


// Lista que armazena e organiza Estudantes

public class ListaEstudantes{

//Cria uma nova ArrayList que armazena Estudantes
private ArrayList<Estudante> lista = new ArrayList<>(); 

    //Metodo Basico que Adiciona um Estudante na lista. O(1)
    void adicionarEstudante(Estudante e){
        lista.add(e);
    }

    //Metodo que percorre a lista removendo todos os estudantes que tiverem um Id especifico. O(n)
    void removerEstudantePorId(int id){
        for (Estudante estudante : lista) {
            if (estudante.getId() == id){
                lista.remove(estudante);
            }
        }
    }
    
    //Metodo que retorna um estudante em um indice especifico. O(1)
    Estudante obterEstudantePorIndice(int indice){
        if (lista.size() >= indice || indice < 0){
            throw new IndexOutOfBoundsException("Indice invalido: " + indice + "\nO Indice precisa ser maior que 0 e menor que o tamanho da lista. \nTamanho atual: " + lista.size());
        }
        return lista.get(indice);
    }

    //Metodo que retorna uma lista encadeada de todos os Estudantes que tem o nome escrito. O(N log N)
    LinkedList<Estudante> buscarEstudantesPorNome(String substring){
        if(substring.length()<3){
            throw new IndexOutOfBoundsException("Digite um nome de no minimo 3 caracteres");
        }
        LinkedList<Estudante> busca = new LinkedList<>();
        for (Estudante estudante : lista) {
            if(estudante.getNome().contains(substring)){
                busca.add(estudante);
            }
        }
        return busca;
    }

    //Metodo que ordena a lista pelo nome alfabeticamente, utilizando um Comparador. O(N log N)
    void ordenarEstudantesPorNomes(){
       lista.sort(new ComparadorNome());
    }

    //Metodo que imprime os atributos de todos os estudantes da lista. O(n)
        void imprimirLista(){
        if (lista.size() == 0){
            System.out.println("A Lista esta vazia "); 
            return; 
        }
        for (Estudante estudante : lista) {
            System.out.println("Nome: " + estudante.getNome() + " || Id: " + estudante.getId());
        }
    }



}