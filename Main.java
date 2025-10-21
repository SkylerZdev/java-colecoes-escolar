import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // --- estudantes ---
        ListaEstudantes lista = new ListaEstudantes();
        CadastroDisciplinas disciplinas = new CadastroDisciplinas();
        File arquivo = new File("input/estudantes.csv");
        Scanner leitor = new Scanner(arquivo);
        leitor.nextLine();
        leitor.useDelimiter(",|\n" );
        while (leitor.hasNext()) {
            lista.adicionarEstudante(new Estudante(leitor.nextInt(), leitor.next()));
        }
        leitor.close();
        HistoricoNotas matriculas = new HistoricoNotas(lista);
        
        
        System.out.println("LISTA DE ESTUDANTES // (INSERCAO)");
        System.out.println("");
        System.out.println("");
        lista.imprimirLista();
        System.out.println("");
        lista.ordenarEstudantesPorNomes();
        
        arquivo = new File("input/disciplinas.csv");
        leitor = new Scanner(arquivo);
        leitor.nextLine();
        leitor.useDelimiter(",|\n" );
        while (leitor.hasNext()) {
            disciplinas.adicionarDisciplina(new Disciplina(leitor.next(), leitor.next()));
        }
        leitor.close();
        System.out.println("");
        System.out.println("");
        System.out.println("DISCIPLINAS (INSERCAO)");
        System.out.println("");
        disciplinas.imprimirDisciplinas();
        System.out.println("");
        System.out.println("");

        if(!disciplinas.obterDuplicatas().isEmpty()){
            System.out.println("DUPLICATAS:");
            System.out.println("");
            for (Disciplina disciplina : disciplinas.obterDuplicatas()) {
              System.out.println(disciplina.getNome());
            }
            System.out.println("");
            System.out.println("");
        }
        
            arquivo = new File("input/matriculas.csv");
            leitor = new Scanner(arquivo);
            leitor.nextLine();
            leitor.useDelimiter(" |\n" );
            while (leitor.hasNext()) {
                matriculas.adicionarMatricula(leitor.nextInt(), leitor.next(), leitor.nextDouble());
                leitor.next();
                
            }
            leitor.close();
            System.out.println("MATRICULAS:");
            for (int i = 0; i < lista.getSize(); i++) {
                Estudante e = lista.obterEstudantePorIndice(i);
                System.out.println("");
                System.out.println("ALUNO: " + e.getNome());
               for (Matricula matricula : matriculas.obterMatriculas(e.getId())) {
                System.out.println(matricula.getCodigoDisciplina() + " " + matricula.getNota());
               } 
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("MEDIA DE TODAS DISCIPLINAS:");
            System.out.println("");
            for (Disciplina disciplina : disciplinas.obterTodasDisciplinas()) {
                System.out.printf("%s: %.2f \n", disciplina.getCodigo(), matriculas.mediaDaDisciplina(disciplina.getCodigo()));
            }
            

            System.out.println("");
            System.out.println("");
            System.out.println("Alunos com media acima de 8: ");
            System.out.println("");
            for (Estudante estudante : lista.obterTodos()) {
                double media = matriculas.mediaDoEstudante(estudante.getId());
                if(media>=8){
                    System.out.println("Media - " + media + " | Aluno: " + estudante.getNome());
                }
            }
            System.out.println("");
            System.out.println("");
            int j = 1;
            System.out.println("TOP 3 ALUNOS");
            System.out.println("");
            for (Estudante estudante : matriculas.topNEstudantesPorMedia(3)) {
                System.out.printf("%d) ",j);
                System.out.println(matriculas.mediaDoEstudante(estudante.getId()) + " - " + estudante.getNome());
                j++;
            }
           System.out.println("");
           System.out.println("");
           System.out.println("DISCIPLINAS COM MEDIA < 6");
            for (Disciplina disciplina : disciplinas.obterTodasDisciplinas()) {
                double media = matriculas.mediaDaDisciplina(disciplina.getCodigo());
                if(media<6){
                    System.out.println(media + " - " + disciplina.getNome());
                }
            }
    }
}