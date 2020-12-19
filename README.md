##Web Project: Pazu 


Ce projet à été réalisé avec différents technologies : Java, Js, Vuejs, Pug. 
Le projet ce divise en deux parties front et back.

Rappel des problèmatiques 

"Une API permettant la gestion d'utilisateur (inscription, login, édition du compte etc ...)

Une API permettant de créer des sondages sur des lieux et date de rendez-vous. 

Une API permettant de voté sur les sondages."

Comme base de donnée nous avons utilisé postgresql que nous initialison avec Docker. (lien de DL : https://www.docker.com/products/docker-desktop)

Pour initialiser le projet, suivre les instructions de "Project setup"

## Project setup
```
Démarer Docker puis :

Activation de la base de donnée :
    cd /Back
    docker-compose up -d

Activation du back :
    ./mvnw spring-boot:run (! ou .\mvnw spring-boot:run)

Activation du front :
    npm install
    npm run serve
```




Author : Delisle Simon - Galloy Arnaud - Augere Baptiste