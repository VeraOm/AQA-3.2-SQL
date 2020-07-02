### Запуск теста
 - Перед запуском контейнера необходимо настроить volume `mysqldb` (ссылка на `/var/lib/mysql/`) и `dbini` (ссылка на `/docker-entrypoint-initdb.d/`)
 - Перед первым запуском контейнера mysql с помощью docker-compose необходимо поместить в папку `/docker-entrypoint-initdb.d/` файлы `10_schema.sql` и `20_data_clean.sql`
 - Перед каждым запуском теста необходимо запустить SUT заново с помощью `app-deadline.bat` (для windows) или `app-deadline` (Linux) из папки `./artifacts/`. С помощью данных скриптов выполняется очистка таблиц и запуск SUT
 
### Окружение:
**ОС:** Windows 7 x64 Home

**Java:** 
openjdk version "11.0.6" 2020-01-14
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.6+10)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.6+10, mixed mode)
 
**Docker** DockerToolbox-19.03.1
