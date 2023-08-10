# redward-petclinic

- Closes #2.  closes issue.
- OJO multi Module al hacer refactor:
  - Ojo con la ruta al hacer refactoR!! needs package and route 
  como en app origina con artifact inverted
    (com.example.redwardpetclinic)

- maven-release-plugin with developer connection
```
mvn release:prepare
mvn:release:perform
```

Beware el dataload (boostrap se hace en el modulo web no el de datos) , pure model.