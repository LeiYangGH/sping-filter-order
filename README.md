# sping-filter-order
demo project to show springboot mvc filter order problem

## curl as client

```bash
curl  -H "Content-Type: application/json" http://localhost:8080 --data '{"from":"jim","message":"nice to meet you!"}'
```

response:

```bash
Hello jim
```

## invalid json

```bash
curl  -H "Content-Type: application/json" http://localhost:8080 --data '{"from":"jim","message""nice to meet you!"}'
```

response:

```bash
2022-01-26 21:16:15.585  WARN 62072 --- [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Unexpected character ('"' (code 34)): was expecting a colon to separate field name and value; nested exception is com.fasterxml.jackson.core.JsonParseException: Unexpected character ('"' (code 34)): was expecting a colon to separate field name and value<EOL> at [Source: (PushbackInputStream); line: 1, column: 25]]
```
if log first:
```bash
2022-01-26 22:45:47.196 ERROR 84456 --- [nio-8080-exec-1] com.example.demo.GreetController         : Required request body is missing: public java.lang.String com.example.demo.GreetController.greet(com.example.demo.WelcomeMessage)
```