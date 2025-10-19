import java.util.*;

public class HistoricoNotas {
    private final Map<Integer, List<Matricula>> mapa = new HashMap<>();
    private final ListaEstudantes listaEstudantes; // opcional, pode ser null

    public HistoricoNotas() {
        this.listaEstudantes = null;
    }

    public HistoricoNotas(ListaEstudantes listaEstudantes) {
        this.listaEstudantes = listaEstudantes;
    }

    // adiciona ou atualiza nota da matrícula
    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        List<Matricula> l = mapa.computeIfAbsent(idEstudante, k -> new ArrayList<>());
        for (Matricula m : l) {
            if (m.getCodigoDisciplina() == codigoDisciplina) {
                m.setNota(nota);
                return;
            }
        }
        Matricula m = new Matricula(codigoDisciplina);
        m.setNota(nota);
        l.add(m);
    }

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

    public void removerMatricula(int idEstudante, String codigoDisciplina) {
        List<Matricula> l = mapa.get(idEstudante);
        if (l == null) return;
        l.removeIf(m -> m.getCodigoDisciplina() == codigoDisciplina);
        if (l.isEmpty()) mapa.remove(idEstudante);
    }
}