# Developer, Organization API with Rate Limit

http://localhost:8080/api/v1/developers

http://localhost:8080/api/v1/organizations

##### Set a header with ``User-Name`` with request.

##### Sample Error code if limit exceed:

```
{
       "errorCode": "RATE_LIMIT_EXCEED",
       "message": "Rate limit exceed",
       "suppressed": [],
       "localizedMessage": "Rate limit exceed"
   }
```

#### The logic is can be extracted in separate jar file and can be re-used as below configuration.
Configuration for application : 

##### 1. Add below properties to application.properties
```
ratelimit.enabled=true
ratelimit.timespan=MINUTE
ratelimit.defaultLimit=10 #

ratelimit.configList[0].userName=user1
ratelimit.configList[0].api=/api/v1/developers
ratelimit.configList[0].limit=5

ratelimit.configList[1].userName=user1
ratelimit.configList[1].api=/api/v1/organizations
ratelimit.configList[1].limit=4

ratelimit.configList[2].userName=user2
ratelimit.configList[2].api=/api/v1/developers
```

##### 2. Implement ``WebMvcConfigurer`` and add ``RateLimitInterceptor``

```
private RateLimitInterceptor rateLimitInterceptor;

    public WebConfig(@Autowired RateLimitInterceptor rateLimitInterceptor) {
        this.rateLimitInterceptor = rateLimitInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimitInterceptor).addPathPatterns(Arrays.asList("/api/v1/**"));
    }
```

##### 3. Add exception handler to controller advice.

```
@ExceptionHandler
public ResponseEntity<RateLimitException> handlerRateLimitException(RateLimitException e) {
    return new ResponseEntity(e, HttpStatus.TOO_MANY_REQUESTS);
}
```

#### Build application:
``mvn clean package``

#### Run application:
``mvn spring-boot:run`` OR ``java -jar ./target/userapi-0.0.1-SNAPSHOT.jar``


#### Request With invalid user : 
A header ``User-Name`` should present in request and that has to be valid, then a request will process else will get error message for invalid request.

##### Request With Valid User: A request with valid user will process once rate limit check is done.

#### Approach Used for rate limit: 

For each request with user+API first check for a limit in config list. 
If no limit found then set limit to default limit. Also, if default limit is also not present throw error.
Now, When there is a limit found then use below steps

I created a ``KeyStore`` which is combination of ``user + API``. Also, a ``ValueStore`` object which holds limit and first request time.
When a first request comes when create keystore using user and api. Then check in store(is a ``ConcurrentHashMap``). 
If no value present, or it is first request. Then store value store with limit ``1`` and current time as initial time.

For second request check if limit is exceed or not and check is rate limit time span passed or not.

if limit is exceed and time span for reset limit not passed then throw ``new RateLimitException("Rate limit exceed", RateLimitException.ERROR_CODE)``.
Otherwise, Check if time span passed then reset limit and set initial time to current time.

Now, If time span not passed then increase rate limit and update store with a new limit.

For Data store used Concurrent HasMap, But we can use cache like memcache or radish.
For key, value used KeyStore and ValueStore. Which will give O(n) to get value from map.

There can be one improvement, we can create a map to store limit as value and key (User+API). So, In this case we don't have to iterate config list to find limit on each API level limit.
 









