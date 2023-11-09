# Descrição

Aplicação de exemplo adaptada para implantação em lambda aws com código nativo compilado em graalvm.

## Publicação normal

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

## Publicação nativa

Na publicação nativa, é necessário gerar um executável no formato do sistema operacional alvo, no caso linux 2 da Amazon.

### build

Gerar uma imagem docker local para compilação nativa:

```
docker build - < Dockerfile -t aws-lambda-native-builder
```

O artefato para publicação fica em **target/product-binary.jar**

### lambda

Manipulador:
        
    com.hello.SimpleHandler::handleRequest

Tempo de execução:

    Java 17

Arquitetura

    x86_64

#### Building the native image

Note that it requires `native-image` installed in your environment

```
mvn clean package -P native-image
```
After it finishes, you can find the generated native image in the `target
` folder. 


docker build - < Dockerfile
docker run -v /home/jonas/src/hello-lambda:/project 2db2f42546ccb6f323f046ad9eda299bb9d0a7d19bde1ffbc783486d406decf4  /usr/bin/mvn clean package -P native-image



### Run

You can run the following command to execute it.

```
target/product-binary
```


### Package

Deploy package:

```
target/function.zip
```
