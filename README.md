# SpeedyDineMonolith

- [SpeedyDineMonolith](#speedydinemonolith)
  - [Running the program using Docker and building locally](#running-the-program-using-docker-and-building-locally)
  - [Running the program by pulling the images from DockerHub](#running-the-program-by-pulling-the-images-from-dockerhub)
  - [Running the program by using docker-compose](#running-the-program-by-using-docker-compose)
  - [Running the program using kubernetes deployment configuration](#running-the-program-using-kubernetes-deployment-configuration)
      - [Kompose](#kompose)
      - [Kubernetes](#kubernetes)
  - [Using the program](#using-the-program)

## Running the program using Docker and building locally

1. Run the MySQL container first:

   Open your terminal and navigate to the `mysql` folder. Then execute these commands:

   ```shell
   docker build -t pradiph31/speedy-dine-monolith-mysql .
   docker run --name mysql -e MYSQL_ROOT_PASSWORD=0143642180 -e MYSQL_USER=pradip -e MYSQL_PASSWORD=1234WXYZ -e MYSQL_DATABASE=speedy_dine --publish 3306:3306 -d pradiph31/speedy-dine-monolith-mysql
1. Run the Spring Flux App container:

   Open your terminal and navigate to the project folder. Then execute these commands:
   ```shell
   mvn clean package
   docker build -t pradiph31/speedy-dine-monolith .
   docker run --detach --link mysql:mysql --publish 8080:8080 pradiph31/speedy-dine-monolith
These commands will build the application, create and run the MySQL container, and finally run the Spring Flux App container.

## Running the program by pulling the images from DockerHub

   Check the images in DockerHub:

   https://hub.docker.com/r/pradiph31/speedy-dine-monolith-mysql

   https://hub.docker.com/r/pradiph31/speedy-dine-monolith
   
1. Run the MySQL container first:


   Open your terminal and navigate to the `mysql` folder. Then execute these commands:

   ```shell
   docker run --name mysql -e MYSQL_ROOT_PASSWORD=0143642180 -e MYSQL_USER=pradip -e MYSQL_PASSWORD=1234WXYZ -e MYSQL_DATABASE=speedy_dine --publish 3306:3306 -d pradiph31/speedy-dine-monolith-mysql
1. Run the Spring Flux App container:

   Open your terminal and navigate to the project folder. Then execute these commands:
   ```shell
   docker run --detach --link mysql:mysql --publish 8080:8080 pradiph31/speedy-dine-monolith
These commands will build the application, create and run the MySQL container, and finally run the Spring Flux App container.

Make sure you have Docker and Maven installed before executing these commands.

## Running the program by using docker-compose

- #### Using the source code

Open your terminal and navigate to the project's root folder. Then execute these commands:

`docker-compose -f kubernetes+docker/docker/docker-compose-local.yml up`

- #### Using dockerhub images

Open your terminal and navigate to the project's root folder. Then execute these commands:

`docker-compose -f kubernetes+docker/docker/docker-compose-dockerhub.yml up`

You can use -d flag to run them detached and if you don't want to specify a file for docker-compose, you can delete one of the files and rename the remaining to docker-compose.yml

Make sure you have buil the war package and have Docker installed before executing these commands.

## Running the program using kubernetes deployment configuration

#### Kompose

These kubernetes configuration files were generated using kompose on docker-compose.yml

`kompose convert`

You can also use it on a file:

`kompose convert -f kubernetes+docker/docker/docker-compose-dockerhub.yml`

#### Kubernetes

Change directory to kubernetes+docker.

Applying the configurations and deploying them to kubernetes:

`kubectl apply -f mysql-deployment.yaml,mysql-service.yaml`

`kubectl apply -f speedy-dine-monolith-deployment.yaml,speedy-dine-monolith-service.yaml`

## Using the program

The program runs on the localhost:8080 or any other port that you specified in Step 2.
The available endpoints are:
| Authenticated | Endpoint                        | Method | Request                                                                                                                                                              | Response                     |
| ------------- | ------------------------------- | ------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------- |
| ✔️             | /api/restaurants                | GET    | headers:<br>Authorization: JWT                                                                                                                                       |                              |
| ✔️             | /api/restaurants/{id}           | GET    | headers:<br>Authorization: JWT                                                                                                                                       |                              |
| ✔️             | /api/restaurants                | POST   | headers:<br>Authorization: JWT                                                                                                                                       |                              |
| ✔️             | /api/menuitems/{id}             | GET    | headers:<br>Authorization: JWT                                                                                                                                       |                              |
| ✔️             | /api/menuitems                  | POST   | headers:<br>Authorization: JWT                                                                                                                                       |                              |
| ✔️             | /api/restaurants/{id}/menuitems | GET    | headers:<br>Authorization: JWT                                                                                                                                       |                              |
| ❌             | /sign-up                        | POST   | {<br>&nbsp;&nbsp;&nbsp;"username":"----",<br>&nbsp;&nbsp;&nbsp;"email":"----",<br>&nbsp;&nbsp;&nbsp;"password":"----",<br>&nbsp;&nbsp;&nbsp;"roles":"----,----"<br>} |                              |
| ❌             | /userinfo                       | GET    | headers:<br>Authorization: Basic base64encode(username:password)                                                                                                     | JWT in Authentication header |