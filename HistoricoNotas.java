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
    
    // Remove uma matrícula de um estudante
    public void removerMatricula(int idEstudante, String codigoDisciplina) {
        List<Matricula> listaM = mapa.get(idEstudante);
        if (listaM == null) return;
        listaM.removeIf(m -> m.getCodigoDisciplina().equals(codigoDisciplina));
        if (listaM.isEmpty()) mapa.remove(idEstudante); // limpa se ficar vazio
    }

    // Calcula a média das notas de um estudante
    public double mediaDoEstudante(int idEstudante) {
        return mediaDoEstudante(obterMatriculas(idEstudante));
    }

    // utilitário: média a partir de uma lista de matrículas (evita duplicar código)
    public static double mediaDoEstudante(List<Matricula> listaM) {
        if (listaM == null || listaM.isEmpty()) return 0.0;
        double soma = 0.0;
        for (Matricula m : listaM) soma += m.getNota();
        return soma / listaM.size();
    }

    public double mediaDaDisciplina(String codigoDisciplina) {
        return mediaDaDisciplina(this.mapa, codigoDisciplina);
    }

    // Utilitário estático para calcular média de disciplina a partir de um Map externo
    public static double mediaDaDisciplina(Map<Integer, List<Matricula>> hist, String codigoDisciplina) {
        if (hist == null || hist.isEmpty()) return 0.0;
        double soma = 0.0;
        int contador = 0;
        for (List<Matricula> listaM : hist.values()) {
            if (listaM == null) continue;
            for (Matricula m : listaM) {
                if (m.getCodigoDisciplina() == codigoDisciplina) {
                    soma += m.getNota();
                    contador++;
                }
            }
        }
        return contador == 0 ? 0.0 : soma / contador;
    }

    // Usa a lista interna (Se fornecida)
    public List<Estudante> topNEstudantesPorMedia(int N) {
        if (listaEstudantes == null) {
            throw new IllegalStateException("ListaEstudantes não foi fornecida. Use topNEstudantesPorMedia(int, List<Estudante>)");
        }
        return topNEstudantesPorMedia(N, listaEstudantes.obterTodos());
    }

    // Aceita a lista de estudantes
    public List<Estudante> topNEstudantesPorMedia(int N, List<Estudante> estudantes) {
        if (estudantes == null) return new ArrayList<>();
        return estudantes.stream() //Coleção de Estudantes
                .sorted(Comparator.comparingDouble((Estudante e) -> mediaDoEstudante(obterMatriculas(e.getId()))).reversed()) //Organiza por Média de Notas
                .limit(N) //Limita para um tamanho N
                .toList(); //Transforma em Lista
    }

    // Retorna uma copia imutável do Mapa
    public Map<Integer, List<Matricula>> getMapa() {
        return Collections.unmodifiableMap(mapa);
    }
}
