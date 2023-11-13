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

docker run -v <local project>:/project aws-lambda-native-builder ./gradlew nativeCompile