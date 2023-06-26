- [SpeedyDineMonolith](#speedydinemonolith)
  - [Running the program using Docker and building locally:](#running-the-program-using-docker-and-building-locally)
  - [Running the program by pulling the images from DockerHub:](#running-the-program-by-pulling-the-images-from-dockerhub)
  - [Running the program by using docker-compose:](#running-the-program-by-using-docker-compose)
  - [Running the program using kubernetes deployment configuration:](#running-the-program-using-kubernetes-deployment-configuration)
  - [Using the program:](#using-the-program)

# SpeedyDineMonolith

## Running the program using Docker and building locally:

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

## Running the program by pulling the images from DockerHub:

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

## Running the program by using docker-compose:

- #### Using the source code:

Open your terminal and navigate to the project's root folder. Then execute these commands:
`docker-compose -f docker-compose-local.yml up`

- #### Using dockerhub images:

Open your terminal and navigate to the project's root folder. Then execute these commands:
`docker-compose -f docker-compose-dockerhub.yml up`

You can use -d flag to run them detached and if you don't want to specify a file for docker-compose, you can delete one of the files and rename the remaining to docker-compose.yml

Make sure you have buil the war package and have Docker installed before executing these commands.

## Running the program using kubernetes deployment configuration:

These kubernetes configuration files were generated using kompose on docker-compose.yml

`kompose convert -f docker-compose.yml`

You can also use it on a file:

`kompose convert -f docker-compose-dockerhub.yml`
## Using the program:

The program runs on the localhost:8080 or any other port that youi specify in Step 2.
The available endpoint is:
| Method | Endpoint              |
| ------ | --------------------- |
| GET    | /api/restaurants      |
| GET    | /api/restaurants/{id} |
| POST   | /api/restaurants      |