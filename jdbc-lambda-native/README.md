# Descrição

Este é um módulo com micronaut que recebe um evento de uma fila SQS, 
consulta uma base RDS postgres, usando uma conexão JDBC básica, e retorna o resultado.

# Execução

JSON do evento (SQS):

    {
      "Records": [
        {
          "messageId": "19dd0b57-b21e-4ac1-bd88-01bbb068cb78",
          "receiptHandle": "MessageReceiptHandle",
          "body": "jonas@arlequim.com.br",
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

O resultado esperado é retornar:

    hey Joao Silva!