FROM mysql:8.0

# Copy the SQL scripts to the docker-entrypoint-initdb.d directory
COPY ./scripts/ /docker-entrypoint-initdb.d/ 
EXPOSE 3306