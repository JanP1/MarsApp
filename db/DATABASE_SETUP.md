# Database setup

> [!NOTE]
> The whole proces will be later automated by using Docker Compose

The project uses a PostgreSQL database inside a Docker container.

It is using a volume called `postgres_data` that can be created by running

```bash
docker volume create postgres_data

```

The container itself can be created using

```bash
docker run 
    -d --name local_postgres \
    -p 127.0.0.1:5432:5432 \
    -e POSTGRES_PASSWORD="*********" \
    -e POSTGRES_INITDB_ARGS="--auth-host=scram-sha-256 --auth-local=scram-sha-256" \
    -v postgres_data:/var/lib/postgresql postgres

```

### Db and user

Next a user and a project database are created
The database tables can be craeted and populated using provided SQL scripts

### Env variables

It is important to make sure the username and the db name match the exported env variables
used in Spring Boots `application.properties`

```java

spring.application.name=marsapp

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}


```

