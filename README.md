# SpeedyDineMonolith

## Running the program using Docker and building locally:

1. Run the MySQL container first:

   Open your terminal and navigate to the `mysql` folder. Then execute these commands:

   ```shell
   docker build -t mysql .
   docker run --name mysql -e MYSQL_ROOT_PASSWORD=0143642180 -e MYSQL_USER=pradip -e MYSQL_PASSWORD=1234WXYZ -d mysql
1. Run the Spring Flux App container:

   Open your terminal and navigate to the project folder. Then execute these commands:
   ```shell
   mvn clean package
   docker build -t pradiph31/speedy-dine-monolith .
   docker run --detach --link mysql:mysql --publish 8080:8080 pradiph31/speedy-dine-monolith
These commands will build the application, create and run the MySQL container, and finally run the Spring Flux App container.

Make sure you have Docker and Maven installed before executing these commands.