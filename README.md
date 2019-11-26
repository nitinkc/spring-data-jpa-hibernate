# Spring 5 Learning

use Docker to run the DB


docker pull mysql

docker run -d
--name=mysql_learning
--env="MYSQL_ROOT_PASSWORD=root"
--env="MYSQL_PASSWORD=root"
-v /Users/nitin/Downloads/docker_data:/var/lib/mysql
-p=3306:3306
mysql

docker exec -it mysql_learning mysql -uroot -p

## Brew Mysql
mysql.server start
# spring-data-jpa
