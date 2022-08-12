# Estruturas de repetição

```
1. inicialização
2. verificação
3. atualização
```

## Keyword `break`

A palavra interrompe o laço no ponto em que foi chamada.

## Keyword `continue`

A palavra pula o laço atual, sem sair do loop, e ignorando o código restante deste laço.

## Estruturas `while`

Basicamente um `if` que dura.


```java
// inicialização

while(/*verificação*/) {

  // atualização
}
```

```java
int n = 0;

while(n < 10){
  System.out.println(n);
  n++;
}
```

## Estrutura `for`

```java
for (/*inicialização*/; /*verificação*/; /*atualização*/){
  // seu código aqui
}
```
> imprimindo os resultados:

```java
for(int i = 0; i <= 20; i+=2){
  System.out.println(n);
}
```

## `i++` vs `++i`

código:
```java
int a = 1, b =1;

System.out.println(a++);
System.out.println(++b);

System.out.println("----");

System.out.println(a);
System.out.println(b);
```

saída:
```
1
2
----
2
2
```