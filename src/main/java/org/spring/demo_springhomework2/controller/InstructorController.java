package org.spring.demo_springhomework2.controller;
import org.spring.demo_springhomework2.model.entity.Instructor;
import org.spring.demo_springhomework2.model.request.InstructorRequest;
import org.spring.demo_springhomework2.model.response.ApiResponse;
import org.spring.demo_springhomework2.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {
private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors (@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Instructor> instructors = instructorService.getAllInstructors(size, page);
        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder().success(true).status(HttpStatus.OK).message("Instructors Fetch Successfully!!").payload(instructors).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @GetMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById (@PathVariable("instructor-id") Long instructorId){
        Instructor instructor = instructorService.getInstructorById(instructorId);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder().success(true).status(HttpStatus.OK).message("Instructor Fetch Successfully!!").payload(instructor).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> CreateInstructor (@RequestBody InstructorRequest request){
    Instructor instructor = instructorService.createInstructor(request);
    ApiResponse<Instructor>  response = ApiResponse.<Instructor>builder().success(true).status(HttpStatus.CREATED).message("Instructor Create Successfully!!").payload(instructor).timestamp(Instant.now()).build();
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(@PathVariable("instructor-id") Long instructorId, @RequestBody InstructorRequest request) {
        Instructor instructor = instructorService.updateInstructorById(instructorId, request);
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder().success(true).status(HttpStatus.OK).message("Instructor updated successfully!").payload(instructor).timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Void>> deleteInstructorById(@PathVariable("instructor-id") Long instructorId) {
        instructorService.deleteInstructorById(instructorId);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true).status(HttpStatus.OK).message("Instructor deleted successfully!").timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }

}
