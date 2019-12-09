# PUT Request (modifying an existing Value) 

Use of Java 8 Map.

In this approach, A PUT Request can also be used to Create a new entry in case the passed id DOES NOT Exist in the DB.

```java
@PutMapping("/student/{id}")
public Student modifyValue(@RequestBody Student newStudent, @PathVariable Long id){
    return studentRepository.findById(id)
            .map(student -> {
                student.setName(newStudent.getName());
                student.setDob(newStudent.getDob());
                return studentRepository.save(student);
            })
            .orElseGet(() -> {
                newStudent.setId(id);
                return studentRepository.save(newStudent);
            });
}
```