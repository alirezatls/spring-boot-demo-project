What Are Projections?

It is a common practice to use Domain Transfer Objects in REST API design as a method of separating the API from its underlying model. you may want to restrict what is visible to clients.


1-we define our JPA Class
    
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String family;
}

2-restrict our User JPA object, and not Return the id or name

@Projection(name="userEx", type=User.class)
public interface UserExcerpt {
    String getId();
    String getFamily();
}

3-create your Spring Data JPA repository:

@RepositoryResrResource(excerptProjection=User.class)
public interface UserRepository extends CrudRepository<User,Long> {
    
}

4-The projection is then called as: projection=userEx

"http://localhost:8080/user/1?projection=userEx"

5-result is:

{

    "id": "1",
    "family": "ali",
    "_links": {
        "self": {
            "href": "http://localhost:8080/user/1"
        },
        "user": {
            "href": "http://localhost:8080/user/1{?projection}",
            "templated": true
        }
    }

}

