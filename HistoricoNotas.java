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

    // adiciona ou atualiza nota da matrícula
    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        List<Matricula> l = mapa.computeIfAbsent(idEstudante, k -> new ArrayList<>());
        for (Matricula m : l) {
            if (m.getCodigoDisciplina() == codigoDisciplina) {
                m.setNota(nota);  // atualiza nota existente
                return;
            }
        }
        // se não existir, cria nova matrícula
        Matricula m = new Matricula(codigoDisciplina);
        m.setNota(nota);
        l.add(m);
    }
     // Retorna todas as matrículas de um estudante
    public List<Matricula> obterMatriculas(int idEstudante) {
        List<Matricula> l = mapa.get(idEstudante);
        return l == null ? new ArrayList<>() : new ArrayList<>(l);
    }

    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        List<Matricula> l = mapa.get(idEstudante);
        if (l == null) return Optional.empty();
        for (Matricula m : l) {
            if (m.getCodigoDisciplina() == codigoDisciplina) return Optional.of(m.getNota());
        }
        return Optional.empty();
    }  
}