import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

// Gerencia disciplinas sem permitir duplicatas
public class CadastroDisciplinas {

    // Armazena disciplinas únicas, mantendo a ordem de inserção
    private final LinkedHashSet<Disciplina> disciplinas = new LinkedHashSet<>();

    // Guarda disciplinas que tentaram ser adicionadas repetidas
    private final List<Disciplina> duplicatas = new ArrayList<>();

    // Adiciona disciplina; retorna false se for duplicada
    public boolean adicionarDisciplina(Disciplina d) {
        if (disciplinas.contains(d)) {
            duplicatas.add(d);
            return false;
        }
        disciplinas.add(d);
        return true;
    }

    // Verifica se uma disciplina existe pelo código
    public boolean verificarDisciplina(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) return true;
        }
        return false;
    }

    // Remove disciplina pelo código
    public void removerDisciplina(String codigo) {
        disciplinas.removeIf(d -> d.getCodigo().equals(codigo));
    }

    // Retorna todas as disciplinas na ordem de inserção
    public List<Disciplina> obterTodasDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    // Retorna disciplinas duplicadas
    public List<Disciplina> obterDuplicatas() {
        return new ArrayList<>(duplicatas);
    }

    void imprimirDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada");
            return;
        }
        for (Disciplina disciplina : disciplinas) {
            System.out.println("Codigo: " + disciplina.getCodigo() + "  //  Nome: " + disciplina.getNome());
        }
    }
}