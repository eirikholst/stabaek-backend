#Stabæk backend

####run mysql on local docker
 
    docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=ultrasecretpassword -e MYSQL_DATABASE=stabaek -e MYSQL_PASSWORD=ultrasecretpassword -e MYSQL_USER=eirik -p 3306:3306 mysql
    