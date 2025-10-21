# **Trabalho de POO — Coleções Java**

## **Integrantes**

| **Nome**                     | **Nick GitHub**   |
|------------------------------|------------------|
| Éric Santos Moura Lima       | ZpexLakip        |
| Carlos Benedito Maciel II    | SkylerZdev       |
| Rodrigo Tavares Bezerra      | lb_Rodrigo_dl    |

---

## **Descrição do Projeto**

Este projeto foi desenvolvido como parte da disciplina de **Programação Orientada a Objetos (POO)**, com o objetivo de aplicar os conceitos de **coleções Java (List, Set e Map)** em um sistema que gerencia informações de estudantes, disciplinas e matrículas em uma escola.

O sistema é capaz de:
- Cadastrar e gerenciar uma lista de estudantes;
- Controlar disciplinas, garantindo que não existam duplicatas;
- Associar cada estudante às suas notas e disciplinas cursadas;
- Calcular médias por estudante e por disciplina;
- Exibir relatórios organizados com os dados processados;
- Exportar os resultados para um arquivo `output.txt`.

---

## **Estrutura do Projeto**

A estrutura segue a organização padrão de um projeto Java simples, conforme demonstrado abaixo:

```text
📁 Projeto
├── 📁 Input
│ ├── estudantes.csv
│ ├── disciplinas.csv
│ └── matriculas.csv
├── CadastroDisciplinas.java
├── ComparadorNome.java
├── Disciplina.java
├── Estudante.java
├── HistoricoNotas.java
├── ListaEstudantes.java
├── Main.java
├── Matricula.java
└── README.md
```
---

## **Justificativa das Coleções Utilizadas**

### **List (ArrayList)**
Foi utilizada na classe **ListaEstudantes** para armazenar e manipular os dados dos alunos, permitindo:
- Inserção e remoção dinâmica de elementos;
- Ordenação de estudantes por nome com o uso de um comparador;
- Busca de estudantes por partes do nome.

A escolha pelo **ArrayList** se deu por sua eficiência em acesso direto por índice e pela necessidade de ordenação e iteração frequente.

---

### **Set (LinkedHashSet)**
Utilizado na classe **CadastroDisciplinas** para garantir que **não existam disciplinas duplicadas** no sistema.

A implementação **LinkedHashSet** foi escolhida para:
- Preservar a **ordem de inserção** das disciplinas;
- Evitar elementos repetidos de forma automática;
- Garantir legibilidade ao exibir as disciplinas na mesma sequência em que foram inseridas.

---

### **Map (HashMap)**
Aplicado na classe **HistoricoNotas**, associando:
- O `id` do estudante (chave);
- À lista de suas matrículas e notas (valor).

O **HashMap** foi escolhido por oferecer:
- Acesso e inserção rápidos (O(1));
- Facilidade na associação de múltiplas disciplinas a um mesmo estudante;
- Suporte ideal para cálculos de médias e filtragens por chave.

---

## **Como Executar o Programa**

### **Pré-requisitos**
- Ter o **Java JDK 17** (ou superior) instalado.
- Certificar-se de que todos os arquivos `.java` e a pasta `Input` estão no mesmo diretório.

### **Passo a Passo**

1. **Abra o terminal** na pasta do projeto.  

2. Compile todas as classes Java com o comando:
   ```bash
   javac *.java
   ```

3. Execute o programa principal:
   ```bash
   java Main
   ```

4. Após a execução, o sistema irá:
   - Ler os arquivos `.csv` dentro da pasta `Input`;  
   - Processar estudantes, disciplinas e notas;  
   - Gerar um arquivo `output.txt` com o relatório completo dos resultados.

---

## **Geração do Arquivo `output.txt`**

O arquivo `output.txt` é criado automaticamente ao final da execução, contendo:
- Lista de estudantes (original e ordenada);
- Lista de disciplinas (sem duplicatas);
- Relação completa de matrículas e médias;
- Médias por disciplina;
- Top 3 alunos por desempenho;
- Alunos com média ≥ 8.0 e disciplinas com média < 6.0.

---

## **Desafios Enfrentados**

Durante o desenvolvimento, o grupo enfrentou os seguintes desafios:
- Integração das três coleções (`List`, `Set` e `Map`);
- Manutenção da **ordem de inserção** nas disciplinas sem duplicação;
- Implementação de **buscas dinâmicas** por nome e substring;
- Cálculo de médias gerais e específicas de forma eficiente;
- Organização e formatação da saída no `output.txt` de maneira legível e estruturada.

A superação desses pontos permitiu consolidar o aprendizado sobre o uso prático das coleções Java e reforçar o domínio sobre **orientação a objetos e manipulação de dados em memória**.

---

## **Conclusão**

O trabalho cumpre todos os requisitos propostos no enunciado, demonstrando o uso correto de **coleções genéricas Java**, o tratamento de duplicatas e a manipulação eficiente de dados em estruturas dinâmicas.  
