# Descrição

Este é um módulo com micronaut compatível com dois tipos de gatilhos do lambda: API Gateway e SQS..
Este módulo não está apto a ser compilado de forma nativa.

# Execução

## Execução SQS

Recebe evento de uma fila.

### handler

    com.hello.SimpleHandler

### JSON do evento (SQS):

    {
      "Records": [
        {
          "messageId": "19dd0b57-b21e-4ac1-bd88-01bbb068cb78",
          "receiptHandle": "MessageReceiptHandle",
          "body": "Joao Silva",
          "attributes": {
            "ApproximateReceiveCount": "1",
            "SentTimestamp": "1523232000000",
            "SenderId": "123456789012",
            "ApproximateFirstReceiveTimestamp": "1523232000001"
          },
          "messageAttributes": {},
          "md5OfBody": "{{{md5_of_body}}}",
          "eventSource": "aws:sqs",
          "eventSourceARN": "arn:aws:sqs:us-east-1:123456789012:MyQueue",
          "awsRegion": "us-east-1"
        }
      ]
    }

### Resultado

    "hey Joao Silva!"

## Execução REST API

Recebe uma chamada REST vinda do API Gateway.

### handler

    io.micronaut.function.aws.proxy.MicronautLambdaHandler

### JSON do evento (API Gateway Proxy):

{
  "body": "{\"req\": {\"key1\": \"Joao Silva\"}}",
  "path": "/demo",
  "httpMethod": "POST",
  "isBase64Encoded": false
}

### Resultado

  {
    "statusCode": 200,
    "headers": {
      "Date": "Tue, 14 Nov 2023 18:31:15 GMT",
      "Content-Type": "application/json"
    },
    "multiValueHeaders": {
      "Date": [
        "Tue, 14 Nov 2023 18:31:15 GMT"
      ],
      "Content-Type": [
        "application/json"
      ]
    },
    "body": "hey Joao Silva!",
    "isBase64Encoded": false
  }
