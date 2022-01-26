# Multi modules and services project with Apollo Android 2 sample

This is a minimalist sample of a project with several modules and services using [Apollo Android 2](https://www.apollographql.com/docs/kotlin/v2).

It contains 3 modules:

- `graphqlSchema`
  - Contains the GraphQL schema for 2 services
  - Defines 1 query for each service
- `feature1`
  - Depends on `graphqlSchema` 
  - Defines 1 additional query for each service
- `app`
  - Depends on `graphqlSchema` and `feature1`
