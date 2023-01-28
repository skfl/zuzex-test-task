# Zuzex test task
Test task for Java junior  back-end developer in Zuzex Software Development Company

# Implementation of the Spring-Boot CRUD application

#### A ) Designing a small database in which the types of one-to-one, one-to-many, many-to-many relationships will be implemented. The database should be normalized according to the first three NFS.

1. All residents of the city have a passport.
2. Residents of the city may own one or more houses or not own at all. The house may have one or more owners or not at all.
3. A resident of a city may have one or several cars or not at all, but a car can have exactly one owner.

#### B) Implementation of interaction with the database via ORM (Hibernate as the most popular solution). It is desirable to connect the database in-memory (H2 for example)
#### C) Implement the basic CRUDs for the created models, taking into account the limitations of the database.

1. When creating a resident of the city, create a passport (wrap it in a transaction).
2. You cannot create or delete a passport via the API.
3. When a resident is deleted, his passport and cars are deleted, the lists of homeowners are updated (wrapped in a transaction).
4. When deleting a house, the lists of the owners of the houses are updated (wrap in a transaction).

### Response format:

- getting an object: the object(s) in the body;
- adding an object: the status of the addition and the object in the body;
- object change: the status of the change and the object in the body;
- deletion: deletion status.
- Implement exception handling.
  1. Create a hierarchy of custom exceptions (or use existing ones) covering the main error cases.
  2. Create an exception handler (RestControllerAdvice + ExceptionHandler)

### It is also advisable to add:
Add custom methods to the API.
- Get all the cars owned by a certain resident of the city (via a named request).
- Get all the owners of houses located on a certain street (via the @Query annotation using jpql).
- Get passport data of all men whose last name begins with a certain letter (via @Query annotation using native sql).
