# Entradas

```java
  System.out.println("Hello World!");
  // sysout
```

## Variáveis (primitivas)

```java
  int a = 2;
  int b;
  b = 2;
```
|tipo|ideia|
|:-:|:-:|
|`int`/`long`| inteiros |
|`float`/`double`| reais |
|`boolean`|guarda `true` ou `false`|
|`char`| guarda um caracter |
|`String`| essa classe pode guardar frases |


## Function `main()`

```java
public class Program {

  // entrypoint
  public static void main(String[] args) {

    // digita aqui
    int age = 20;
    String name = "Jhon";

    System.out.println("Hello my name is " + name + "and i'm" + age);

  }
}
```

## Estrutura condicional

## (` if - else if - else`)

```java
  if ( /*condição*/ ) {
    // código a ser executado se ela for verdadeira
  }
```

```java
  int idade = 20;
  boolean expression = (idade > 18);

  if( expression ) {
    System.out.println("é maior de idade");
  }
```

```java
  if( nota >= 7.0 ){
    System.out.println("Aprovado");
  } else {
    System.out.println("Reprovado");
  }
```

```java
  if(nota >= 7.0){
    System.out.println("Aprovado");
  } else if(nota >= 4.0 ) {
    System.out.println("Recuperação");
  } else {
    System.out.println("Reprovado");
  }
```

## Entrada de dados

```java
import java.util.Scanner;

public class Program {

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();

  }

}

```