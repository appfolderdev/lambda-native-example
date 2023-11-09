# Descrição

Aplicação de exemplo adaptada para implantação em lambda aws com código nativo compilado em graalvm.

# Requisitos

- Docker
- Maven
- Java 17 
- AWS

# Publicação

## Java 

Na publicação por vias normais, é gerado um jar com todas dependência e implantado diretamente no lambda com runtime java 17.

### build

Para gerar um jar com todas as dependências:

```
mvn clean package
```

O artefato para publicação fica em **target/product-binary.jar**

### lambda

Manipulador:
        
    com.hello.SimpleHandler::handleRequest

Tempo de execução:

    Java 17

Arquitetura

    x86_64

## Nativa

Na publicação nativa, é necessário gerar um executável no formato do sistema operacional alvo, no caso linux 2 da Amazon.

### build

Gerar uma imagem docker local para compilação nativa:

```
docker build - < Dockerfile -t aws-lambda-native-builder
```


Gerar o executável nativo:


```
docker run -v <caminho do projeto>:/project aws-lambda-native-builder  /usr/bin/mvn clean package -P native-image
```

**ATENÇÂO: alterar o caminho do projeto no comando acima!**

O artefato para publicação fica em **target/function.zip**

### lambda

Manipulador:
        
    com.hello.SimpleHandler::handleRequest

Tempo de execução:

    Custom runtime on Amazon Linux 2

Arquitetura

    x86_64

# Execução

Para execução, leia o README da cada módulo.