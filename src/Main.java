import builders.StudentsBuilder;
import entities.Studant;

import java.util.*;

public class Main {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Escolha um número de 1 a 7!");
    int num = sc.nextInt();
    Locale.setDefault(Locale.US);
    var allStudents = StudentsBuilder.getAllStudents();
    
    switch (num) {
      case 1:
//        1. Recupere da lista os alunos que passaram de ano (nota minima 7.0).
//        - Exiba os dados nesse formato: <código> - <nome> : Média = <nota>
        for (Studant value : allStudents) {
          double nota = value.getTestOne() + value.getTestThree() + value.getTestTwo();
          double media = nota / 3;
          
          if (media > 7) {
            System.out.println(value.getCode() + " - " + value.getName() + " : " + String.format("%.2f", media) + " = " + String.format("%.2f", nota));
          }
        }
        break;
      case 2:
        //        2. Recupere da lista os alunos que não passaram de ano.
        //            - Exiba os dados nesse formato: <código> - <nome> : Média = <media> (Faltou = <nota_faltante>)
        for (Studant value : allStudents) {
          double nota = value.getTestOne() + value.getTestThree() + value.getTestTwo();
          double media = nota / 3;
          double nota_faltante = 7 - media;
          if (media < 7) {
            System.out.println(value.getCode() + " - " + value.getName() + " : " + String.format("%.2f", media) + " (Faltou = " + String.format("%.2f", nota_faltante) + ")");
          }
        }
        break;
      case 3:
//                3. Traga os alunos que tiraram a nota máxima (nota 10).
//                - Exiba os dados nesse formato: <código> - <nome>
        
        for (Studant aluno : allStudents) {
          if (aluno.getTestOne() == 10 || aluno.getTestTwo() == 10 || aluno.getTestThree() == 10) {
            System.out.println(aluno.getCode() + " - " + aluno.getName());
          }
          
        }
        break;
      case 4:
//            4. Traga o aluno que tirou a menor nota, em caso de notas iguais, traga ambos os alunos.
//            - Exiba os dados nesse formato: <código> - <nome> : Nota = <nota>
        double menorNota = allStudents.get(1).getTestOne();
        String alunoMenor = allStudents.get(1).getName();
        int codigoAlu = allStudents.get(1).getCode();
        
        for (Studant aluno : allStudents) {
          if (aluno.getTestOne() <= menorNota) {
            menorNota = aluno.getTestOne();
            alunoMenor = aluno.getName();
            codigoAlu = aluno.getCode();
            System.out.println(codigoAlu + " - " + alunoMenor + ": Nota = " + String.format("%.1f", menorNota));
          }
          if (aluno.getTestTwo() <= menorNota) {
            menorNota = aluno.getTestTwo();
            alunoMenor = aluno.getName();
            codigoAlu = aluno.getCode();
            System.out.println(codigoAlu + " - " + alunoMenor + ": Nota = " + String.format("%.1f", menorNota));
          }
          if (aluno.getTestThree() <= menorNota) {
            menorNota = aluno.getTestThree();
            alunoMenor = aluno.getName();
            codigoAlu = aluno.getCode();
            System.out.println(codigoAlu + " - " + alunoMenor + ": Nota = " + String.format("%.1f", menorNota));
          }
        }
        break;
      case 5:
//        5. Faça uma lista com top 3 notas de alunos. Em caso de notas iguais coloque todos na mesma posição.
//        - Ex:
//        1º - Fulano : Nota = 10.0;
//        - Beltrano : Nota = 10.0;
//        2º - Joãozinho : Nota = 9.0;
//        3º - Mariazinha : Nota = 8.9;
//        - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
        
        List<Double> todasNotas = new ArrayList<>();
        for (Studant aluno : allStudents) {
          todasNotas.add((double) aluno.getTestOne());
          todasNotas.add((double) aluno.getTestTwo());
          todasNotas.add((double) aluno.getTestThree());
        }
        
        Collections.sort(todasNotas);
        Collections.reverse(todasNotas);
        
        List<Double> topNotas = new ArrayList<>();
        for (Double nota : todasNotas) {
          if (!topNotas.contains(nota)) {
            topNotas.add(nota);
            if (topNotas.size() == 3) {
              break;
            }
          }
        }
        
        int posicao = 1;
        for (Double nota : topNotas) {
          System.out.println("º - Top " + posicao + " alunos:");
          for (Studant aluno : allStudents) {
            if (aluno.getTestOne() == nota || aluno.getTestTwo() == nota || aluno.getTestThree() == nota) {
              System.out.println("    - " + aluno.getName() + " : Nota = " + String.format("%.1f", nota));
            }
          }
          posicao++;
        }
        
        break;
      
      case 6:
//        6. Faça uma lista com as 3 menores notas de alunos. Em caso de notas iguais coloque todos na mesma posição. Exemplo igual a anterior
//        - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
        List<Double> menoresNotas = new ArrayList<>();
        for (Studant aluno : allStudents) {
          double nota1 = aluno.getTestOne();
          double nota2 = aluno.getTestTwo();
          double nota3 = aluno.getTestThree();
          
          
          if (menoresNotas.size() < 3) {
            menoresNotas.add(nota1);
            menoresNotas.add(nota2);
            menoresNotas.add(nota3);
            Collections.sort(menoresNotas);
            continue;
          }
          
          
          if (nota1 < menoresNotas.get(2) || nota2 < menoresNotas.get(2) || nota3 < menoresNotas.get(2)) {
            menoresNotas.add(nota1);
            menoresNotas.add(nota2);
            menoresNotas.add(nota3);
            Collections.sort(menoresNotas);
            menoresNotas.remove(3);
          }
        }
        
        
        for (int i = 0; i < 3; i++) {
          System.out.println((i + 1) + "º - Alunos com a " + (i + 1) + "ª menor nota:");
          double nota = menoresNotas.get(i);
          for (Studant aluno : allStudents) {
            if (aluno.getTestOne() == nota || aluno.getTestTwo() == nota || aluno.getTestThree() == nota) {
              System.out.println("    - " + aluno.getName() + " : Nota = " + String.format("%.1f", nota));
            }
          }
        }
        
        break;
      
      case 7:

//        7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.
//        - Exiba os dados nesse formato: <posicao> - <código> - <nome> : Média = <nota>
        
        List<Double> medias = new ArrayList<>();
        for (Studant aluno : allStudents) {
          double media = (aluno.getTestOne() + aluno.getTestTwo() + aluno.getTestThree()) / 3.0;
          medias.add(media);
        }
        
        Collections.sort(medias, Collections.reverseOrder());
        
        int posicao2 = 1;
        for (Double media : medias) {
          for (Studant aluno : allStudents) {
            if ((aluno.getTestOne() + aluno.getTestTwo() + aluno.getTestThree()) / 3.0 == media) {
              System.out.println(posicao2 + " - " + aluno.getCode() + " - " + aluno.getName() + " : Média = " + String.format("%.1f", media));
              posicao2++;
            }
          }
        }
        break;
    }
    
  }
}
