# KDA Rest API

## Build
```
mvn clean install
```

## Run Spring boot
```
mvn spring-boot:run
```

## Test Local
```
curl localhost:8080/v1/health
```


## Cloud Foundary Deploy
```
cf login
mvn clean package && cf push 
```

## Cloud Foundary KDA API
```
https://kda.cfapps.io/webjars/swagger-ui/index.html?url=/api/swag
```

## Azure Webapp Deploy
```
az login
mvn clean package azure-webapp:deploy
````

## Azure KDA API
```
https://apiapp-kda-dev-ase-kda-announcement-api.azurewebsites.net/webjars/swagger-ui/index.html?url=/api/swag
```
