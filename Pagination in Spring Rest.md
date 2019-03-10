
    PAGINATION
    1-you need to extend the PagingAndSortingRepository<T,ID> 


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
    
    //#this method exsist in PagingAndSortingInterface.
    public Page findAll(Pageable pageable); 
}

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;
    
    public Page<Product> getUserPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}

@RestController
public class ProductController {
    
    @Autowired
    ProductService productServie;
    
    @GetMapping("/...")
    public List<Product> getPage(Pageable pageable) {
        //pageable object is created by spring boot autoConfiguration just like Model,ModelMap
        return productServie.getUserPage(pageable).getContent();
    }
}

    URL QUERY DEFAULT NAMES
    page: to specify page number,
    limit: to specify how many results to return on a page,
    sort: to specify the query method parameter on which to sort
    
    EXAMPLE
    http://localhost:8080/api/demo/categories/products?page=1&limit=5
    
    To change the names of the query parameters:



    SORTING
    Spring Data REST also recognizes sorting parameters that will use the Repository sorting support
    sort=the name of the property
    
    http://localhost:8080/api/demo/products?page=1&limit=3&sort=family
    
    You can control the direction of the sort by specifying a URL parameter composed of the property name plus .dir 
    http://localhost:8080/api/demo/categories/products?page=2&limit=5&sort=name&name.dir=desc
    or
    http://localhost:8080/people/search/nameStartsWith?name=K&sort=name,desc
    



@Override
protected void configureRepositoryRestConfiguation(RepositoryRestConfiguration config) {
    config.setPageParamName("p")
        .setLimitParamName("lim")
        .setSortParamName("s");
    change url to http://localhost:8080/api/demo/categories/products?p=1&lim=4
}


    Previous and Next Links
    Each paged response will return links to the previous and next pages of results based on the current page. 
    
    {
        "rel":people.next,
        "href":" http://localhost:8080/api/demo/categories/products?page=2&limit=5"
    }


    NEXT AND PREV    
    with Spring Boot Data Rest that useing full hateoas
    1-just create a repository like that
    
        @RepositoryRestResource(path = "user",collectionResourceRel = "user")
        public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
        }

    and result of a real application is :
    
{

    "_embedded": {
        "user": [
            {
                "name": "aa",
                "family": "ali",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/user/1"
                    },
                    "user": {
                        "href": "http://localhost:8080/user/1"
                    }
                }
            },
            {
                "name": "aa",
                "family": "sd",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/user/2"
                    },
                    "user": {
                        "href": "http://localhost:8080/user/2"
                    }
                }
            }
        ]
    },
    "_links": {
        "first": {
            "href": "http://localhost:8080/user?page=0&size=2"
        },
        "self": {
            "href": "http://localhost:8080/user{&sort}",
            "templated": true
        },
        "next": {
            "href": "http://localhost:8080/user?page=1&size=2"
        },
        "last": {
            "href": "http://localhost:8080/user?page=11&size=2"
        },
        "profile": {
            "href": "http://localhost:8080/profile/user"
        }
    },
    "page": {
        "size": 2,
        "totalElements": 24,
        "totalPages": 12,
        "number": 0
    }

}



At the top, we see _links:
	1-The self link serves up the whole collection with some options.
	2-The next link points to the next page, assuming the same page size.
	3-At the bottom is extra data about the page settings, including the size of a page, total elements, total pages, and the page number you are currently viewing.



