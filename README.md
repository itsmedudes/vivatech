# Otp Generate Application



## Installation & Run

run this command in your pc
```bash
  git clone https://github.com/itsmedudes/vivatech.git
```

Before running the API server, you should update the database config inside the application.properties file.
Update the port number, username and password as per your local database config.
```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3307/vivatech;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   
```

## API Root Endpoint

`https://localhost:8888/user`

`https://localhost:8888/verifyotp`

`https://localhost:8888/login`

## API Module Endpoints

### User Module


* `POST /users` : Register ( Create New Account ) 
* `POST /verifyotp` : Verification ( verify via OTP) 
* `POST /login`: Login ( Login a user ) 

### Sample API Response
Request Body for Create a User

```
{

    "name" : "jhon Doe",
    "mobile" : "9910236659",
    "password" : "admin1234"
}

```
Response Body

```
{
  "otp":"251236"
}
```

Request Body for OTP Verification

```
{
    "mobile" : "9910236659",
    "otp" : "733374"
}

```
Response Body

```
{
    "message":"Successfully Verified"
}
```

Request Body for Login

```
{
    "mobile":"9910236659",
    "password" : "admin1234"
}

```
Response Body

```
{
    "id": 5,
    "name": "jhon Doe",
    "mobile": "9910236659",
    "otp": "733374",
    "created_at": "2023-11-17T08:56:21.534+00:00",
    "updated_at": null,
    "_verified": true
}
```


