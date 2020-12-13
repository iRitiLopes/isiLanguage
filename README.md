# isiLanguage
This is a repository for the Project of UFABC Compilers discipline


# Milestones
- ~~Possui 2 tipos de variáveis~~
- ~~Possui a estrutura If.. else~~
- ~~Estrutura de Repetição~~
- ~~Verificar se Variável foi atribuída ou não~~
- ~~Possui operações de Entrada e Saída~~
- ~~Aceita números decimais~~
- ~~Verificar se variável foi declarada~~
- ~~Verificar se variável declarada foi ou não usada~~
- Qual linguagem destino? Java
- **ITENS OPCIONAIS (Se houver)**
- **Extras**
  - ~~Adicionado Listener ao parser e ao Lexer para que os erros mostrem a linha e a coluna que os erros aconteceram~~
  - ~~Verificando tipos compativeis de variaveis na atribuição.~~
  - ~~Aceitando Strings literais. Exemplo: "Hello World".~~
  - ~~Operações booleanas podem aceitar os IDs em ambas posições~~
  - ~~Operações booleanas apenas fazem comparacoes do tipo numero~~
  - ~~Operações booleanas aceitam encadeamento com operadores "&&" (and) e "||" (or)~~
  - ~~Adicionado reconhecimento de parenteses em expressoes algebricas e booleanas para definir precedencia forçada~~
  - ~~Adicionado reconhecimento do operador de negacao numa expressao booleana~~


# Vídeo de apresentação
https://youtu.be/hzZ7pN8a5Yo


## Exemplo da linguagem
```
programa
  numero a, b, f;
  texto  c, d;

  leia(b);
  leia(c);

  a = 1 + 2 * 3 / b ;
  b = ((1 + (9 + 4)) + 2) + (a + (4 + 5)) * (123 + 2);
  f = b / a;
  se(a > 2 && a == 2){
    escreva(a);
    se(a > 2){
        leia(b);
        se(a < 5){
            leia(a);
        }
    }
  }senao{
    escreva(b);
  }

  se(b > a){
    escreva(b);
  }


  enquanto(!(a > 2 && a < 5) || a == 5){
    escreva(a);
    se(a < b){
        escreva(b);
    }senao{
        escreva(a);
    }
  }

  a = 1;
  b = 1.43;

  d = "Hello World";

fimprog;
```

Output
```java
import java.util.Scanner;

public class MainClass {
    public static void main(String args[]) {
        Scanner _key = new Scanner(System.in);
        double a;
        double b;
        String c;
        String d;
        double f;
        b = _key.nextDouble();
        c = _key.next();
        a = 1 + 2 * 3 / b;
        b = ((1 + (9 + 4)) + 2) + (a + (4 + 5)) * (123 + 2);
        f = b / a;
        if (a > 2 && a == 2) {
            System.out.println(a);
            if (a > 2) {
                b = _key.nextDouble();
                if (a < 5) {
                    a = _key.nextDouble();
                }
            }
        } else {
            System.out.println(b);
        }

        if (b > a) {
            System.out.println(b);
        }
        while (!(a > 2 && a < 5) || a == 5) {
            System.out.println(a);
            if (a < b) {
                System.out.println(b);
            } else {
                System.out.println(a);
            }
        }
        a = 1;
        b = 1.43;
        d = "Hello World";
    }
}
```
