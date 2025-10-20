import java.util.*;

public class HistoricoNotas {
     // Mapeia o ID do estudante para a lista de matrículas dele
    private final Map<Integer, List<Matricula>> mapa = new HashMap<>();
    // Referência opcional à lista de estudantes
    private final ListaEstudantes listaEstudantes; 
    
    // Construtor sem lista de estudantes
    public HistoricoNotas() {
        this.listaEstudantes = null;
    }
    // Construtor com lista de estudantes
    public HistoricoNotas(ListaEstudantes listaEstudantes) {
        this.listaEstudantes = listaEstudantes;
    }

    // Adiciona ou atualiza nota da matrícula
    //listaM -> Lista de Matriculas do Estudante
    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        List<Matricula> listaM = mapa.computeIfAbsent(idEstudante, k -> new ArrayList<>());
        for (Matricula matricula : listaM) {
            if (matricula.getCodigoDisciplina() == codigoDisciplina) {
                matricula.setNota(nota);  // atualiza nota existente
                return;
            }
        }
        // se não existir, cria nova matrícula
        Matricula m = new Matricula(codigoDisciplina);
        m.setNota(nota);
        listaM.add(m);
    }
     // Retorna todas as matrículas de um estudante
    public List<Matricula> obterMatriculas(int idEstudante) {
        List<Matricula> listaM = mapa.get(idEstudante);
        return listaM == null ? new ArrayList<>() : new ArrayList<>(listaM);
    }

    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        List<Matricula> listaM = mapa.get(idEstudante);
        if (listaM == null) return Optional.empty();
        for (Matricula matricula : listaM) {
            if (matricula.getCodigoDisciplina().equals(codigoDisciplina)) return Optional.of(matricula.getNota());
        }
        return Optional.empty();
    }
    
}
