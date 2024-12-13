# Custom JWT Transformer

This repository contains a sample custom JWT transformer for WSO2 API Manager (APIM) version 4.1.0. The transformer modifies incoming JWT [roles](https://github.com/SameeraSI/custom-jwt-transformer/blob/e448918877842203f0fdc0d48f59128a9d785350/src/main/java/org/wso2/custom/transformer/test/ExtendedJWTTransformer.java#L33) claim as needed, specifically converting the [roles](https://github.com/SameeraSI/custom-jwt-transformer/blob/e448918877842203f0fdc0d48f59128a9d785350/src/main/java/org/wso2/custom/transformer/test/ExtendedJWTTransformer.java#L33) claim from an array to a string if the token's [issuer](https://github.com/SameeraSI/custom-jwt-transformer/blob/e448918877842203f0fdc0d48f59128a9d785350/src/main/java/org/wso2/custom/transformer/test/ExtendedJWTTransformer.java#L32) is http://localhost:8080/realms/master.

Example Transformation
If the incoming JWT contains the following roles claim:

```
"roles": [
    "default-roles-master",
    "offline_access",
    "uma_authorization"
]
```
The transformer will convert it to:

```
"roles": "default-roles-master offline_access uma_authorization"
```
This repository serves as an example, and you can customize the transformer to modify any claims as per your requirements.

## Prerequisites
- WSO2 API Manager 4.1.0
- Maven build tool

## How to Use
Build the Project
Use Maven to build the project:
```
mvn clean install
```

## Deploy the JAR File
After building, locate the generated JAR file in the target folder.
Copy the JAR file to the ```<API-M_HOME>/repository/components/dropins directory```

## Restart the Server
Restart the WSO2 API Manager to apply the changes.

## References
[JWT Claim Transformation Documentation](https://apim.docs.wso2.com/en/4.1.0/design/api-security/oauth2/access-token-types/jwt-tokens/#jwt-claim-transformation)
