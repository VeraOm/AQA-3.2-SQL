set DB_URL=jdbc:mysql://192.168.99.101:3306/vera
set DB_USER=vera
set DB_PASS=pass
d:\zero\virt\DockerToolbox\docker.exe exec -it aqa4-sql bash -c "mysql -u %DB_USER% %DB_USER% --password=%DB_PASS% < /docker-entrypoint-initdb.d/20_data_clean.sql"
d:\zero\virt\jdk-11.0.7+10\bin\java.exe -jar app-deadline.jar
