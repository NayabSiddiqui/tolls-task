# Tolls Spring Cloud Task

### How to set up Dev Environment

> Prerequisites:
- Docker. To install docker on your machine, go [here](https://www.docker.com/)
- Gradle

---

> Start MySql database:

Start a local mysql database and publish mysql's default port 
`3306` to the host with the following command
```
docker run --name task-sql -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306 mysql
```

---

> Create new database to be used by this application:

Start another container with the mysql command line and link it with the above started
mysql container with the following command:

```
docker run -it --link task-sql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'
```

Provide the password `password` when prompted for. Now you should be at the mysql command prompt.

Check the connection by typing in `show databases`; This should list out the default databases in the server.
Create a new database `tasklogs` to be used by the application, by issuing the command: `create database tasklogs;`

---

> Run the application:

Run the application by issuing following command on command line:

```
gradle bootRun
```

Enjoy !

---

