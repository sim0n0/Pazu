        PAZU WEB PROJECT
            Author : Delisle Simon - Galloy Arnaud - Augere Baptiste

    Ce projet à été réalisé avec différents technologies comme Vuejs, Pug etc.. 
        Le projet ce divise en deux parties Front et Back

Rappel des problèmatiques 

"Une API permettant la gestion d'utilisateur (inscription, login, édition du compte etc ...)

Une API permettant de créer des sondages sur des lieux et date de rendez-vous. 

Une API permettant de voté sur les sondages."

Comme base de donnée nous avons utilisé Docker.

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
