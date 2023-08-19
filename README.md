# redward-petclinic
- ==status==
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/friedelredward/redward-petclinic/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/friedelredward/redward-petclinic/tree/main)

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

> tip: to DI:: ..private final ...Service; Alt+Enter> add Constructor parameter.

### [Thymeleaf_CheatSheet](https://github.com/engma/thymeleaf-cheat-sheet)
- thymelaf template have inheritance so BEWARE of the html sintax and structure!!!!

### [(How to manage ENV variables  PDF_here)](https://github.com/friedelredward/redward-petclinic/blob/main/ExternalPropertiesOverview.pdf)
- Also spring Cloud Config as alternative
- DOCs Externalized Configuration : https://docs.spring.io/spring-boot/docs/2.4.3/reference/html/spring-boot-features.html#boot-features-external-config

### JPA
[(101  PDF_here)]("https://github.com/friedelredward/redward-petclinic/blob/main/JPA+Entity+Relationships.pdf")

- Spring data JPA uses a framework like hibernate to 
enhance the persistence API.
- Declaring an Implementation *For the same service* will produce:
![img.png](img.png)
  - so it's very important to declare 1 primary or set the profiles functinality 
  as intended in the beginning
````java
@Service
@Profile("springdatajpa") //< ---this is not gonna be invoked when not active.profile 
public class OwnerJPAService implements OwnerService { /*...*/}
````
-------------
### Lombok
 Common utilities through annotations like getters and setters loggers etc
- CUTS  down boilerplate code
  [(Lombok PDF_here)]("https://github.com/friedelredward/redward-petclinic/blob/main/OverviewOfLombok.pdf")
- val, var, @NonNull @Cleanup(will close on finally block) @Getter @Setter @ToString @EqualsAndHashCode
- @NoArgsConstructor @AllArgConstructor @Data is a combo of all with @RequiredArgsConstructor.
- @Value: like data but all fields are final and private
- @Builder: implments a builder pattern
- @SneakyThrows
- @Syncronized
- @Getter(lazy=true) for expensive getters (activates a cache)
- @Log and @Slf4j (better) or logback is by default from Spring
- Lombok with 2 way binding might create Stack overflow
because circular reference in ``hashCode()`` pej. so we might
want to exclude thos from hash code generation from _@Data_, only in one side of the 
relation, not both(in the smaller 1) pej ``@EqualsAndHashCode(exclude = {"recipe"})`` .
- Please check _/recipies_ lombok-refactor *working* branch.

----------

### Testing

[(intro PDF_here)]("https://github.com/friedelredward/redward-petclinic/blob/main/IntroTestingSpring.pdf")
(test CircleCI)

- Mockito: ``@ExtendWith(MockitoExtension.class)``
   - ``@Mock  OwnerRepository ownerRepository;``
   - ``@InjectMocks  OwnerJPAService service;``
- MockMvc  for testing controllers:
```` 
mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
//then
    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(ownersSet);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }
- ````




