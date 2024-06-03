
# Simple Authentication Service

user can perform 2 actions: register and login.

Dependencies:   
- Spring Data JPA\
- Spring Web\
- H2 Database\
- Spring Security





## API Reference

#### Register user

```http
  POST /api/v1/user/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email` | `string` | **Required**. Your email |
| `password` | `string` | **Required**. Your password |


#### Get item

```http
  POST /api/v1/user/register
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `firstname`      | `string` | **Required**. firstName |
| `lastname`      | `string` | **Required**. lastName |
| `email`      | `string` | **Required**. email |
| `password`      | `string` | **Required**. password |



## Run Locally

Clone the project

```bash
  git clone git@github.com:StarFleet1334/SimpleAuthenticationAp.git
```

Go to the project directory

```bash
  cd AuthenticationApp
```


```bash
  run AuthenticationAppApplication.java
```

```


## Support

For support, email latariailia6@gmail.com 


