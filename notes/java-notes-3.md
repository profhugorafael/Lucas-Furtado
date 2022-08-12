# OOP - Oriented Object Programming

## Classe e Objeto

Classe é um molde e um objeto é um fruto desse molde.

```java
public class Pessoa {

  public String name;
  public int age;
  public double height;

  public void makeBirthday(){
    age++;
  }

}
```

## Como trocar valores

```java
int a = 2, b = 3;
int copy = a; // a = 2 b = 3 copy = 2
a = b; // a = 3 b = 3 copy = 2
b = copy; // a = 2 b = 2 copy = 2
```