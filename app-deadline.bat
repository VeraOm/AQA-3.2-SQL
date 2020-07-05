set DB_URL=jdbc:mysql://192.168.99.101:3306/vera
set DB_USER=vera
set DB_PASS=pass
docker exec -i aqa4-sql bash -c "mysql -u %DB_USER% %DB_USER% --password=%DB_PASS%" < data_clean.sql
java -jar .\artifacts\app-deadline.jar
