Run endpoint **authenticate** with:
```
    {
     "password": "pas3",
     "username": "User3"
   }
```
or 

run in generated-request.http to authenticate:
```
POST http://localhost:8080/authenticate
accept: */*
Content-Type: application/json

{
  "password": "pas3",
  "username": "User3"
}

###


```