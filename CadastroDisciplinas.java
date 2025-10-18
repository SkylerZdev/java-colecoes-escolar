import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class CadastroDisciplinas {
    private final LinkedHashSet<Disciplina> disciplinas = new LinkedHashSet<>();
    private final List<Disciplina> duplicatas = new ArrayList<>();

    
    public boolean adicionarDisciplina(Disciplina d) {
        if (disciplinas.contains(d)) {
            duplicatas.add(d);
            return false;
        }
        disciplinas.add(d);
        return true;
    }

    public boolean verificarDisciplina(int codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigo) return true;
        }
        return false;
    }

    public void removerDisciplina(int codigo) {
        disciplinas.removeIf(d -> d.getCodigo() == codigo);
    }

    // retorna lista mantendo ordem de inserção
    public List<Disciplina> obterTodasDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    public List<Disciplina> obterDuplicatas() {
        return new ArrayList<>(duplicatas);
    }
}
