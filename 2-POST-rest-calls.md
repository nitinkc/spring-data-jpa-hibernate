#POST Rest Calls

### Saving a new Entry

in Controller Class
```java
@PostMapping("/student")
public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student){
    System.err.println("###################################### POST Begins ######################################");
    Student savedStud = studentRepository.save(student);
    System.err.println("###################################### POST Ends ######################################");
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedStud.getId())
            .toUri();
    
    return (ResponseEntity<Object>) ResponseEntity.created(location).build();
}
```

In Postman, create a POST call

{{address}}{{port}}/api/jpa/student

with Request Body RAW and JSON
```json
{
"name": "Nitin",
"dob": "2019-12-08T01:19:11.760+0000"
}
```

See notes of the Restful Web

Returns 200 OK

Returns 201 Created
