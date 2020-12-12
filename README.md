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
TODO


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
  }senao{
    escreva(b);
  }

  se(b > a){
    escreva(b);
  }


  enquanto(!(a > 2 && a < 5) || a == 5){
    escreva(a);
  }

  a = 1;
  b = 1.43;

  d = "Hello World";

fimprog;
```