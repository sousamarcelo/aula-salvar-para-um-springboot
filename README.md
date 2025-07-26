# Caso 1 
### Salvando entidade associada para um PARTE 3
POST http://localhost:8080/people
{
  "name": "Nova Pessoa",
  "salary": 8000.0,
  "department": {
  "id": 1
  }
}

_______________________________________________________________________________________
# Caso 2

POST http://localhost:8080/people
{
"name": "Nova Pessoa",
"salary": 8000.0,
"departmentId": 1
}

