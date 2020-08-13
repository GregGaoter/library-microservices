# Library Microservices

## Contexte

Ce projet est une application simple basée sur une architecture microservices, afin de comprendre les concepts liés à l'optimisation d'une architecture microservices.

## Optimisation de l'architecture

L'architecture microservices est optimisée avec les éléments suivants :

- **Feign** : permet de faire communiquer les microservices
- **Spring Cloud Config** : permet d'externaliser et de centraliser la configuration de l'application
- **Eureka** : tient un registre de toutes les instances des microservices disponibles
- **Ribbon** : permet d'équilibrer la charge côté client entre les instances d'un microservice
- **Zuul** : permet d'avoir un point d'entrée unique de l'application, tous les apples vers les microservices passent par Zuul
- **Spring Cloud Security** : permet de sécuriser l'accès à l'API Gateway Zuul
- **Sleuth** : permet d'identifier de façon unique chaque requêtes à travers les microservices
- **Zipkin** : permet de centraliser et d'organiser les requêtes identifiées par Sleuth
- **Spring Actuator** : permet de fournir des données supplémentaires sur des aspects d'un microservice
- **Spring Admin** : permet de regrouper tous les retours de Spring Actuator dans une seule interface

## Installation

### Prérequis

| Description           | Technologie | Version |
| --------------------- | ----------- | ------- |
| Langage               | Java        | 11      |
| Production logicielle | Maven       | 3.6.1   |
| Code versionning      | Git         | 2.22.0  |

## Exécution

### Exécution depuis un IDE

1.  Importer tous les projet Maven. Par exemple pour Eclipse :  
    `File -> Import... -> Maven -> Existing Maven Projects`
2.  Lancer les microservices dans cet ordre :
    1.  config-server
    2.  discovery-server
    3.  zuul-server
    4.  zipkin-server-2.12.9-exec.jar
    5.  spring-admin
    6.  books
    7.  clientui
3.  Depuis un navigateur Web, accéder aux URL suivantes :
    1.  localhost:2002 -->> Eureka : liste des instances des microservices
    2.  localhost:2000/books/books/2 -->> Zuul : point d'entrée unique de l'application

**Remarque** : la configuration de l'application est centralisée dans le repository https://github.com/GregGaoter/library-config

