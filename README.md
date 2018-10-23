# Headless CMS Proof of Concept - Squidex

A simple Spring Boot application that reads from and writes to a headless CMS. For this proof of concept, the headless
CMS solution being showcased is [Squidex](https://squidex.io/).

## Setting up Squidex

Squidex provides a number of different [compose files](https://github.com/Squidex/squidex-docker/) that you can use
to start up the application. The simplest one to use for the sake of this proof of concept is the [standalone
without a proxy](https://github.com/Squidex/squidex-docker/blob/master/standalone/docker-compose-noproxy.yml),
although I made some slight modifications. The final file I used is this:

```yml
version: '2.1'
services:
  squidex_mongo:
    image: mongo:latest
    container_name: squidex-mongo
    ports:
      - "27017:27017"
    volumes:
      - ./db:/data/db
    networks:
      - internal
    restart: unless-stopped

  squidex_squidex:
    image: "squidex/squidex:dev"
    container_name: squidex-api
    ports:
      - "80:80"
    environment:
      - URLS__BASEURL=http://squidex.dev/
      - URLS__ENFORCEHTTPS=false
      - EVENTSTORE__CONSUME=true
      - EVENTSTORE__MONGODB__CONFIGURATION=mongodb://squidex_mongo
      - STORE__MONGODB__CONFIGURATION=mongodb://squidex_mongo
      - IDENTITY__ADMINEMAIL=admin@squidex.dev
      - IDENTITY__ADMINPASSWORD=udjcmwIskqAl8dsj4klf&fdjKW/jQ=d5Q2
      - IDENTITY__GOOGLECLIENT=
      - IDENTITY__GOOGLESECRET=
      - IDENTITY__MICROSOFTCLIENT=
      - IDENTITY__MICROSOFTSECRET=
    depends_on:
      - squidex_mongo
    volumes:
      - ./assets:/app/Assets
    networks:
      - internal
    restart: unless-stopped

networks:
  internal:
    driver: bridge
```

Note that Squidex enforces strong password requirements for the admin user, so whatever you use as a password, make
sure it's a strong one. My first three attempts were rejected before using the long crazy one in the above file.

I also mapped `squidex.dev` to the IP address that Squidex was running on in my workstation's `hosts` file.

Now start the application:

```bash
$ docker-compose up -d
```

You can now access the Squidex admin application at `http://YOUR_DOCKER_HOST/`. Log in using the username
`admin@squidex.dev` and the password `udjcmwIskqAl8dsj4klf&fdjKW/jQ=d5Q2`.

## Configuring Proof of Concept Application

By default, the application will attempt to connect to the Squidex API on `localhost`. If the API is running
somewhere else, you can override the default behaviour by setting the `SQUIDEX_API_HOST` environment variable to
the correct host and port for your Squidex API instance.

The Proof of Concept application will run on port 8080. If the Squidex API is also running on port 8080, you will
need to run the Proof of Concept application on a different port. Change the port by setting the `SERVER_PORT`
environment variable.

## Running the Proof of Concept Application

```bash
$ mvn spring-boot:run
```

If you do not have Maven installed, you can use the Maven Wrapper that is included with the project instead.

```bash
$ ./mvnw spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Setting up Data

Some things need to be set up in the Squidex admin application before the proof of concept application can begin to
access the API. The application will attempt to read simple items that have "id" and "name" fields from two schemas
called "stuff" and "things" in an app called "myapp". The app, its schemas, and the client information to use to
connect must all be defined manually.

1. Create an app.
   * Click "New App".
   * Enter the name "myapp".
   * Click "Create".
2. Define a client and generate a token for the client.
   * Select the "myapp" app.
   * Click "Settings" and then "Clients".
   * Enter the client name "poc-squidex" and click "Add Client".
   * Note the "Client Id" and "Client Secret". You will need to set the SQUIDEX_CLIENT_ID and SQUIDEX_CLIENT_SECRET
     environment variables to these values.
3. Create a schema.
   * Click "Schemas" and then the "+" (New Schema) button.
   * Select "Single content", enter "stuff" as the name, and click "Create".
   * Select the "stuff" schema and click "Add Field".
   * Select "Number", enter "id" as the name, and click "Create and new field".
   * Enter "name" as the field name and click "Create and close".
   * Repeat all steps in this item to create another schema called "things".

## Observations

* The custom API documentation generated using Swagger is really nice.
* Apps, schemas, and schema item fields cannot be defined using the API.