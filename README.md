
# Spring Security

This project covers the basic SpringBoot appliaction having the below files:

1. Added a spring security feature to protect user from csrf and enable login and logout by default
2. Self configure login and logout 


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