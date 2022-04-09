# Security DB version

## Recommended approach:

 * checkout security-db-starter branch. The branch contains unsecured simple Book storage example
 * use included docker-compose to spin up database

## Notes
 * Users and Roles are created manually
 * Use https://bcrypt-generator.com/ with round = 1 to hash password to hash passwords

## Explanation
The purpose of the Security DB Demo Example is to demonstrate simple secure way of using **username / password** in a Rest Based Application.

HTTP web based applications are required to send authentication data each time the request is made. This means, such an application is required to store authentication data in browser, so they can be used for subsequent requests.
The web browser is prone to vulnerabilities which allows attackers to retrieve sensitive information. Storing sensitive data, such as **username / password**, is for this reason considered a security hole. 

The simplest way of overcoming the issue is to exchange **username / password** combination for unique meaningless token. This way, only meaningless token is stored in a web application.
Important property of the token is its expiration time. The expiration time is stored in a backend database and must be validated each time the request is made. After token expiration, using such a token must result in request authentication failure.

Token expiration can be extended each time the application makes request. This means that token will be invalidated only after some time of inactivity. 
The developer must be aware that this introduces security issue since attacker can potentially make periodic request to application to keep token from expiration.
The decision about the approach must be decided based on the application security requirements.

Token based approach allows backend application to log out the user by simple deleting token from token table. 

 


