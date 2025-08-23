# Shine API Documentation

This project uses Swagger/OpenAPI for API documentation.

## Accessing Swagger UI

After starting the application, you can access the Swagger UI at:

```
http://localhost:8080/api/swagger-ui.html
```

The OpenAPI specification is available at:

```
http://localhost:8080/api/api-docs
```

## Features

- Interactive API documentation
- Try out API endpoints directly from the browser
- Detailed information about request parameters and response models

## Authentication

Authentication has been removed from this application. All endpoints are now accessible without authentication.

## Available APIs

The following APIs are documented:

- **Societe API**: Manage company entities
- **Site API**: Manage site entities
- **Tier API**: Manage tier entities
- **Adresse API**: Manage address entities
- **Currency API**: Manage currency entities
- **ZoneDistribution API**: Manage distribution zones
- **And more...**

## Development

### Adding Documentation to Controllers

To add documentation to a controller, use the following annotations:

```java
@Tag(name = "Entity Name", description = "Description of the API")
public class EntityController {

    @Operation(summary = "Operation summary", description = "Detailed description")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success response description"),
        @ApiResponse(responseCode = "404", description = "Not found description")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityDto> getEntity(
            @Parameter(description = "Parameter description") @PathVariable Integer id) {
        // Method implementation
    }
}
```

### Required Dependencies

The project uses the following dependencies for OpenAPI documentation:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```
