# User API Spec

## Register User
- Desc : Endpoint to register a user

- Endpont : POST /api/users

Request Body : 
```json
{
    "username" : "username1",
    "password" : "password123
}
```

Response Body (Success) : 
```json
{
    "status"        : 200,
    "message"       : "OK",
    "data"          : {
        "users_id"      : 1
        "username"      : "username1",
    },
    "errors"        : null,
    "request_id"    : "1234-5678-qwert-asdf" 
}
```

Response Body (Failed) : 
```json
{
    "status"        : 500,
    "message"       : "Internal Server Error",
    "data"          : null,
    "errors"        : {
        "message"       : "Username Already Taken!"
    },
    "request_id"    : "1234-5678-qwert-asdf"
}
```

## Login User

## Get User

## Update User

## Logout User