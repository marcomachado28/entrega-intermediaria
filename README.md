# Caixa Eletrônico em Java

## Descrição

Projeto de um sistema de caixa eletrônico desenvolvido em Java no terminal.

O sistema permite realizar operações bancárias básicas e integração com API pública.

---

## Funcionalidades

- Consultar saldo
- Depositar dinheiro
- Sacar dinheiro
- Consultar endereço por CEP

---

## API Utilizada

### ViaCEP

API pública utilizada para consulta de CEP.

Site oficial:
https://viacep.com.br/

---

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- API REST
- HttpURLConnection 
- JSON

---

## Estrutura do Projeto

```bash
caixa-eletronico-java/
│
├── src/
│   └── CaixaEletronico.java
│
├── README.md
└── .gitignore
```

---

## Como Executar

1. Abrir o projeto no VS Code ou IntelliJ
2. Compilar o arquivo Java
3. Executar a classe `CaixaEletronico`

---

## Exemplo da API

CEP consultado:

```bash
01001000
```

Resposta:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}

## Como executar

```bash
javac CaixaEletronico.java

java CaixaEletronico
```

## API utilizada

ViaCEP

https://viacep.com.br/
```
