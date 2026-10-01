# spring-authorization-server

A small OAuth2 setup with Spring Authorization Server: three Spring Boot apps that each play one role.

| App | Port | What it does |
|---|---|---|
| `auth-server` | 9090 | Issues JWT access tokens (client credentials flow, scope `articles.read`) |
| `resource-server` | 9091 | `GET /articles`, protected. Validates the JWT against the auth server. |
| `client-server` | 9092 | `GET /test` fetches a token, then calls the resource server with it |

All three include the OpenTelemetry Spring Boot starter, so you can trace a request across them.

Companion code for my article [Spring Boot Authorization Server](https://blog.devgenius.io/spring-boot-authorization-server-825230ae0ed2). The same `auth-server` also issues the tokens in [grpc-oauth2-example](https://github.com/kumarprabhashanand/grpc-oauth2-example).

## Run it

Start the apps in this order: `auth-server`, `resource-server`, `client-server`. Then:

```
curl http://localhost:9092/test
```

Spring Boot 3, Java 17. The client id and secret are hardcoded demo values.
