# handler

io.micronaut.function.aws.proxy.MicronautLambdaHandler


# Mensagem

{
  "body": "eyJ0ZXN0IjoiYm9keSJ9",
  "resource": "/{proxy+}",
  "path": "/demo",
  "httpMethod": "GET",
  "isBase64Encoded": true,
  "queryStringParameters": {
    "foo": "bar"
  }
}

# Build

docker run -v E:\src\lambda-native\lambda-native-example\micronaut-jdbc-gradle:/project aws-lambda-native-builder  ./gradlew clean nativeCompile