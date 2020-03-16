# Especificação da API de consulta das cotações do dólar cormecial

## 001 - Historia de Usuário: Consultar cotações do dolar por data:
Como um usuário
Quero consultar as cotações do dolar comercial na data informada
Para ter conhecimento do valor de compra e de venda do dolar naquela data especifica.

## Criterios de Aceite:
 CA-001. Verificar se o usuário informou a data.     
 CA-002. Verificar se a data informada é válida.     
 CA-003. Se for uma data valida consultar as cotações do dolar em um serviço externo do Banco Central.

## Cenários de Testes:

 Cenário 01: Consultar cotações do dolar por data válida.     
 Pré-requesitos: O usuário informar uma data válida.
 Procedimento: Consumir o serviço de consulta com uma data válida.   
 Resultado esperado: Responder a consulta com dados das cotações do dólar na data informada. Dados a serem retornados: ID da requisição, data da requisição, valor de compra, valor da venda, data e hora da cotação do dólar.

 Cenário 02: Consultar cotações do dolar por data inválida.  
 Pré-requesitos: O usuário informar a data inválida.  
 Procedimento: Consumir o serviço de consulta de cotações com uma data inválida.  
 Resultado esperado: Responder com uma mensagem de que a data informada está inválida.

 Cenário 03: Consultar cotações do dolar por data com formato inválido.   
 Pré-requesitos: O usuário informar a data com formato inválido.   
 Procedimento: Consumir o serviço de consulta de cotações com uma data no formato inválido.   
 Resultado esperado: Responder com uma mensagem de que a data informada está no formato inválido.   

 Cenário 04: Consultar cotações do dolar quando o serviço externo do Banco Central estiver indisponivel.   
 Pré-requesitos: O usuário informar uma data válida. Serviço do BC está indisponivel.    
 Procedimento: Consumir o serviço de consulta de cotações que tentará consumir um serviço externo fornecido pelo Banco Central.   
 Resultado esperado: Responder com uma mensagem de que o serviço do Banco Central está indisponivel. 

 Cenário 05: Consultar cotações do dolar que não há registros de cotações na data válida informada.    
 Pré-requesitos: O usuário informar uma data válida. Não ter nenhum registro de cotação para a data válida informada.   
 Procedimento: Consumir o serviço de consulta com uma data válida.   
 Resultado esperado: Responder com uma mensagem de que não há registros de cotação para a data informada.     
