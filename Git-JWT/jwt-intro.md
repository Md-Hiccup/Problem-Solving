# Structure of a JWT
## JSON Web Token example:

`eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ0b3B0YWwuY29tI iwiZXhwIjoxNDI2NDIwODAwLCJodHRwOi8vdG9wdGFsLmNvbS9qd3RfY2xhaW1zL2lzX2FkbWluI jp0cnVlLCJjb21wYW55IjoiVG9wdGFsIiwiYXdlc29tZSI6dHJ1ZX0.yRQYnWzskCZUxPwaQupWk iUzKELZ49eM7oWxAQK_ZXw`

Since there are 3 parts separated by a ., each section is created differently. We have the 3 parts which are:

-   header
-   payload
-   signature

`<base64-encoded header>.<base64-encoded payload>.<base64-encoded signature>`

## Header
The JWT Header declares that the encoded object is a JSON Web Token (JWT) and the JWT is a JWS that is MACed using the HMAC SHA-256 algorithm. For example:
```
{
    “alg”: “HS256”,
    “typ”: “JWT”
}
```
**"alg"** is a string and specifies the algorithm used to sign the token.

**"typ"** is a string for the token, defaulted to **"JWT"**. Specifies that this is a JWT token.

## Payload (Claims)
A claim or a payload can be defined as a statement about an entity that contians security information as well as additional meta data about the token itself.

Following are the claim attributes :
-   iss: The issuer of the token

-   sub: The subject of the token

-   aud: The audience of the token

-   qsh: query string hash

-   exp: Token expiration time defined in Unix time

-   nbf: “Not before” time that identifies the time before which the JWT must not be accepted for processing

-   iat: “Issued at” time, in Unix time, at which the token was issued

-   jti: JWT ID claim provides a unique identifier for the JWT


## Signature
Signature

JSON Web Signatre specification are followed to generate the final signed token. JWT Header, the encoded claim are combined, and an encryption algorithm, such as HMAC SHA-256 is applied. The signatures's secret key is held by the server so it will be able to verify existing tokens.

# Popular Libraries for JWT
Java [atlassian-jwt](https://bitbucket.org/atlassian/atlassian-jwt/) and [jsontoken](https://code.google.com/p/jsontoken/)

Python [pyjwt](https://github.com/jpadilla/pyjwt)

Node.js [node-jwt-simple](https://github.com/hokaccha/node-jwt-simple)

Ruby [ruby-jwt](https://github.com/progrium/ruby-jwt)

PHP [firebase php-jwt](https://github.com/firebase/php-jwt) and [luciferous jwt](https://github.com/luciferous/jwt)

.NET [jwt](https://github.com/johnsheehan/jwt)

Haskell [haskell-jwt](http://hackage.haskell.org/package/jwt)

## Advantages of Token Based Approach
-   JWT approach allows us to make AJAX calls to any server or domain. Since the HTTP header is used to transmit the user information.

-   Their is no need for having a separate session store on the server. JWT itself conveys the entire information.

-   Server Side reduces to just an API and static assets(HTML, CSS, JS) can be served via a CDN.

-   The authentication system is mobile ready, the token can be generated on any device.

-   Since we have eliminated the need for cookies, we no more need to protect against the cross site requesets.

-   API Keys provide either-or solution, whereas JWT provide much granular control, which can be inspected for any debugging purpose.

-   API Keys depend on a central storage and a service. JWT can be self-issued or an external service can issue it with allowed scopes and expiration.

# Creating a JWT in Python
Encoding a payload
```
>>> import jwt
>>> encoded = jwt.encode({'some': 'payload'}, 'secret', algorithm='HS256')
'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzb21lIjoicGF5bG9hZCJ9.4twFt5NiznN84AWoo1d7KO1T_yoc0Z6XOpOVswacPZg'
```

Decoding a payload on the server
```
>>> jwt.decode(encoded, 'secret', algorithms=['HS256'])
{'some': 'payload'}
```