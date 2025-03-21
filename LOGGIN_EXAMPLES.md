# Logging Examples

This document contains examples of log outputs from various operations in the ELK Stack application.

## User Registration
```json
{
  "@timestamp": [
    "2025-03-12T06:38:51.139Z"
  ],
  "application": [
    "elk-stack"
  ],
  "application.keyword": [
    "elk-stack"
  ],
  "class": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "class.keyword": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "level": [
    "INFO"
  ],
  "level.keyword": [
    "INFO"
  ],
  "line": [
    "?"
  ],
  "line.keyword": [
    "?"
  ],
  "logger": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "logger.keyword": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "message": [
    "User registered successfully. User ID: *****"
  ],
  "message.keyword": [
    "User registered successfully. User ID: *****"
  ],
  "method": [
    "?"
  ],
  "method.keyword": [
    "?"
  ],
  "pid": [
    "32699"
  ],
  "pid.keyword": [
    "32699"
  ],
  "thread": [
    "http-nio-8080-exec-6"
  ],
  "thread.keyword": [
    "http-nio-8080-exec-6"
  ],
  "_id": "KnoTiZUBbJ5tZMXyzQF6",
  "_index": "spring-logs-2025.03.12",
  "_score": null
}
```
```json
{
  "@timestamp": "2025-03-12T06:38:51.139Z",
  "level": "INFO",
  "logger": "com.fayupable.elkstack.service.UserService",
  "message": "User registered successfully. User ID: *****"
}
```

## Login Process
```json

{
  "@timestamp": [
    "2025-03-12T06:39:44.241Z"
  ],
  "application": [
    "elk-stack"
  ],
  "application.keyword": [
    "elk-stack"
  ],
  "class": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "class.keyword": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "level": [
    "INFO"
  ],
  "level.keyword": [
    "INFO"
  ],
  "line": [
    "?"
  ],
  "line.keyword": [
    "?"
  ],
  "logger": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "logger.keyword": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "message": [
    "Logging in user with email: Marcia_Schaden@gmail.com"
  ],
  "message.keyword": [
    "Logging in user with email: Marcia_Schaden@gmail.com"
  ],
  "method": [
    "?"
  ],
  "method.keyword": [
    "?"
  ],
  "pid": [
    "32699"
  ],
  "pid.keyword": [
    "32699"
  ],
  "thread": [
    "http-nio-8080-exec-5"
  ],
  "thread.keyword": [
    "http-nio-8080-exec-5"
  ],
  "_id": "K3oUiZUBbJ5tZMXynAHm",
  "_index": "spring-logs-2025.03.12",
  "_score": null
}
```

```json

{
  "@timestamp": [
    "2025-03-12T06:39:44.622Z"
  ],
  "application": [
    "elk-stack"
  ],
  "application.keyword": [
    "elk-stack"
  ],
  "class": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "class.keyword": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "level": [
    "INFO"
  ],
  "level.keyword": [
    "INFO"
  ],
  "line": [
    "?"
  ],
  "line.keyword": [
    "?"
  ],
  "logger": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "logger.keyword": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "message": [
    "User logged in successfully. User ID: *****"
  ],
  "message.keyword": [
    "User logged in successfully. User ID: *****"
  ],
  "method": [
    "?"
  ],
  "method.keyword": [
    "?"
  ],
  "pid": [
    "32699"
  ],
  "pid.keyword": [
    "32699"
  ],
  "thread": [
    "http-nio-8080-exec-5"
  ],
  "thread.keyword": [
    "http-nio-8080-exec-5"
  ],
  "_id": "LHoUiZUBbJ5tZMXyngFd",
  "_index": "spring-logs-2025.03.12",
  "_score": null
}
```

```json
{
  "@timestamp": "2025-03-12T06:38:51.139Z",
  "level": "INFO",
  "logger": "com.fayupable.elkstack.service.UserService",
  "message": "User registered successfully. User ID: *****"
}
```


## Update Role Operation
```json
{
  "@timestamp": [
    "2025-03-12T06:36:43.315Z"
  ],
  "application": [
    "elk-stack"
  ],
  "application.keyword": [
    "elk-stack"
  ],
  "class": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "class.keyword": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "level": [
    "INFO"
  ],
  "level.keyword": [
    "INFO"
  ],
  "line": [
    "?"
  ],
  "line.keyword": [
    "?"
  ],
  "logger": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "logger.keyword": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "message": [
    "Admin ID: 6647b5e8-1e63-43ce-b8d9-2ab25365cc6d is updating role for user ID: 72c0f8c2-da4f-4783-8c2e-3e9175f4f654 to role: ROLE_ADMIN"
  ],
  "message.keyword": [
    "Admin ID: 6647b5e8-1e63-43ce-b8d9-2ab25365cc6d is updating role for user ID: 72c0f8c2-da4f-4783-8c2e-3e9175f4f654 to role: ROLE_ADMIN"
  ],
  "method": [
    "?"
  ],
  "method.keyword": [
    "?"
  ],
  "pid": [
    "32699"
  ],
  "pid.keyword": [
    "32699"
  ],
  "thread": [
    "http-nio-8080-exec-2"
  ],
  "thread.keyword": [
    "http-nio-8080-exec-2"
  ],
  "_id": "J3oRiZUBbJ5tZMXy2gEc",
  "_index": "spring-logs-2025.03.12",
  "_score": null
}
```

```json

{
  "@timestamp": [
    "2025-03-12T06:36:43.366Z"
  ],
  "application": [
    "elk-stack"
  ],
  "application.keyword": [
    "elk-stack"
  ],
  "class": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "class.keyword": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "level": [
    "INFO"
  ],
  "level.keyword": [
    "INFO"
  ],
  "line": [
    "?"
  ],
  "line.keyword": [
    "?"
  ],
  "logger": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "logger.keyword": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "message": [
    "Role updated successfully for user ID: 72c0f8c2-da4f-4783-8c2e-3e9175f4f654"
  ],
  "message.keyword": [
    "Role updated successfully for user ID: 72c0f8c2-da4f-4783-8c2e-3e9175f4f654"
  ],
  "method": [
    "?"
  ],
  "method.keyword": [
    "?"
  ],
  "pid": [
    "32699"
  ],
  "pid.keyword": [
    "32699"
  ],
  "thread": [
    "http-nio-8080-exec-2"
  ],
  "thread.keyword": [
    "http-nio-8080-exec-2"
  ],
  "_id": "KHoRiZUBbJ5tZMXy2gFQ",
  "_index": "spring-logs-2025.03.12",
  "_score": null
}


```

```json
{
  "@timestamp": "2025-03-12T06:36:43.315Z",
  "level": "INFO",
  "logger": "com.fayupable.elkstack.service.UserService",
  "message": "Admin ID: 6647b5e8-1e63-43ce-b8d9-2ab25365cc6d is updating role for user ID: 72c0f8c2-da4f-4783-8c2e-3e9175f4f654 to role: ROLE_ADMIN"
}
{
  "@timestamp": "2025-03-12T06:36:43.366Z",
  "level": "INFO",
  "logger": "com.fayupable.elkstack.service.UserService",
  "message": "Role updated successfully for user ID: 72c0f8c2-da4f-4783-8c2e-3e9175f4f654"
}
```

# User Logout Process

```json

{
  "@timestamp": [
    "2025-03-12T06:40:34.426Z"
  ],
  "application": [
    "elk-stack"
  ],
  "application.keyword": [
    "elk-stack"
  ],
  "class": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "class.keyword": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "level": [
    "INFO"
  ],
  "level.keyword": [
    "INFO"
  ],
  "line": [
    "?"
  ],
  "line.keyword": [
    "?"
  ],
  "logger": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "logger.keyword": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "message": [
    "User logged out successfully"
  ],
  "message.keyword": [
    "User logged out successfully"
  ],
  "method": [
    "?"
  ],
  "method.keyword": [
    "?"
  ],
  "pid": [
    "32699"
  ],
  "pid.keyword": [
    "32699"
  ],
  "thread": [
    "http-nio-8080-exec-7"
  ],
  "thread.keyword": [
    "http-nio-8080-exec-7"
  ],
  "_id": "LXoViZUBbJ5tZMXyYAH5",
  "_index": "spring-logs-2025.03.12",
  "_score": null
}
```

```json
{
  "@timestamp": [
    "2025-03-12T06:40:34.425Z"
  ],
  "application": [
    "elk-stack"
  ],
  "application.keyword": [
    "elk-stack"
  ],
  "class": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "class.keyword": [
    "c.fayupable.elkstack.service.UserService"
  ],
  "level": [
    "INFO"
  ],
  "level.keyword": [
    "INFO"
  ],
  "line": [
    "?"
  ],
  "line.keyword": [
    "?"
  ],
  "logger": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "logger.keyword": [
    "com.fayupable.elkstack.service.UserService"
  ],
  "message": [
    "Processing logout request"
  ],
  "message.keyword": [
    "Processing logout request"
  ],
  "method": [
    "?"
  ],
  "method.keyword": [
    "?"
  ],
  "pid": [
    "32699"
  ],
  "pid.keyword": [
    "32699"
  ],
  "thread": [
    "http-nio-8080-exec-7"
  ],
  "thread.keyword": [
    "http-nio-8080-exec-7"
  ],
  "_id": "LnoViZUBbJ5tZMXyYAH5",
  "_index": "spring-logs-2025.03.12",
  "_score": null
}
```

```json
{
  "@timestamp": "2025-03-12T06:40:34.425Z",
  "level": "INFO",
  "logger": "com.fayupable.elkstack.service.UserService",
  "message": "Processing logout request"
}
```
```json
{
  "@timestamp": "2025-03-12T06:40:34.426Z",
  "level": "INFO",
  "logger": "com.fayupable.elkstack.service.UserService",
  "message": "User logged out successfully"
}
```