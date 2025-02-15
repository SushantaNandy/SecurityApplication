
# Spring Security

This project covers the basic SpringBoot appliaction having the below files:

1. Added a spring security feature to protect user from csrf and enable login and logout by default
2. Self configure login and logout 
3. Created a User Entity which implements UserDetails(spring security) to grand authority, getPassword and username.
4. Created a repo parallel to it to store or fetch data from db (UserRepository).
5. Created a UserService to load User By UserName else throws an runtime exception(ResourceNotFoundException).
6. Created a FilterChain in WebSecureConfig to implements all the lists of filters in ongoing current request.
   ![SecurityFilterChain](SecurityApplication/src/main/resources/static/images/securityFilterChain.jpeg)
7. Used request Machers for endpoints for -public routings like (/posts. /public/**) we are permitting them all.
8. Autheniticated other requests than above mention public routes.
9. Used formLogin() that loads the FormLoginConfigure class that loads login page to authenticate based on username and password.
10. We have use csrf protection and for now we have remove session based authentification and made the session STATELESS.
11. All the above feature added in class WebSecureConfig.
12. 

![InternalFlowOfSpringSecurity](SecurityApplication/src/main/resources/static/images/InternalFlowOfSpringSecurity.jpeg)
![DetailedFlowOfSpringSecurity](SecurityApplication/src/main/resources/static/images/zommedFlow.jpeg)

## API Reference

#### Create a new Post based on provided title and description in Body

```http
  POST http://127.0.0.1:8080/posts
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `jSON body` | `string` | **Required** title and dsecription |

#### Get all Posts

```http
  GET http://127.0.0.1:8080/posts
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| null      |          | **Required**. Fetch All the Posts |


#### Get all Posts based on postId

```http
  GET http://127.0.0.1:8080/posts/{postId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| postId    |Integer   | **Required**. Fetch Post based on the PostId|

#### Get all the changes based on postId only for Admin Panel

```http
  GET http://127.0.0.1:8080/audit/post/{postId}
```
| Parameter | Type     | Description                                    |
| :-------- | :------- |:-----------------------------------------------|
| postId    |Integer   | **Required**. Fetch Changes based on the PostId|



## Authors

- [@sushantanandy](https://www.linkedin.com/in/sushantanandy/)
## API Reference

#### Get all items

```http
  POST http://127.0.0.1:8080/posts
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `jSON body` | `string` | **Required** title and dsecription |

#### Get item

```http
  GET http://127.0.0.1:8080/posts
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| null      |          | **Required**. Fetch All the Posts |

```http
  GET http://127.0.0.1:8080/posts/{postId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| postId    |Integer   | **Required**. Fetch Post based on the PostId|

## Authors

- [@sushantanandy](https://www.linkedin.com/in/sushantanandy/)