# Agenda
 Aplicação com front em angular e back em java 
 
 Para a execução correta da aplicação é necessário que seja instalado o postgres "https://www.postgresql.org/download/" e nele seja criado o database "Pessoas" pelo pgAdmin ou pelo shell com o
 comando "CREATE DATABASE "Pessoas"
          WITH 
          OWNER = postgres
          ENCODING = 'UTF8'
          LC_COLLATE = 'Portuguese_Brazil.1252'
          LC_CTYPE = 'Portuguese_Brazil.1252'
          TABLESPACE = pg_default
          CONNECTION LIMIT = -1;"
          
para o usuário e senha escolhido juntamente com a porta que o postgres será executado essas informações devem ser colocadas no aplication.yml do pessoa-serivice que fica dentro da pasta "Agenda\pessoa-service\src\main\resources" como exemplificado aba  
  #datasource
    #driverClassName: org.postgresql.Driver
    #url: jdbc:postgresql://localhost:5432/Pessoas (porta e nome do datasouce criado)
    #username: postgres (usuario)
    #password: postgres (senha)
    
para a o acionamento do back-end é necessário criar o jar ou instanciar pela ide, existem algumas formas, possuindo o maven basta dentro da pasta Agenda\pessoa-service\ executar o comando "mvn spring-boot:run", para outras opções http://www.appsdeveloperblog.com/run-spring-boot-app-from-a-command-line/, requisitado jdk8 ou superior e maven

para a aplicação angular é necessário instalar o Node Js "https://nodejs.org/en/" e o angular cli "https://cli.angular.io/", nessa ordem necessariamente, após ambos feitos basta dar o comando "ng serve -o" dentro da pasta Agenda\angular\ que o serviço será startado.
 
 
