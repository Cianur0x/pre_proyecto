package org.iesvdm.preproyectoapirest.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.preproyectoapirest.domain.Task;
import org.iesvdm.preproyectoapirest.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = {"", "/"}, params = {"!search", "!order", "!page", "!size", "!deadline", "!isChecked", "!tagId", "!id", "!start", "!end"})
    public List<Task> all() {
        log.info("Accediendo a todos las tareas");
        return this.taskService.all();
    }

    @GetMapping(value = {"", "/"}, params = {"!page", "!size", "!deadline", "!isChecked", "!tagId", "!id", "!start", "!end"})
    public List<Task> all(@RequestParam("search") Optional<String> findOpt,
                          @RequestParam("order") Optional<String> orderOpt) {
        log.info("Accediendo a todas las tareas con filtros");
        return this.taskService.all(findOpt, orderOpt);
    }

    @GetMapping(value = {"", "/"}, params = {"!search", "!order", "!page", "!size", "!isChecked", "!tagId", "!start", "!end"})
    public List<Task> allByDeadline(@RequestParam("deadline") String deadline, @RequestParam("id") Long userId) {
        log.info("Accediendo a todas las tareas según fecha");
        return this.taskService.getTaskByDeadline(deadline, userId);
    }

    @GetMapping(value = {"", "/"}, params = {"!search", "!order", "!page", "!size", "!deadline", "!start", "!end"})
    public List<Task> allByIsChecked(@RequestParam("isChecked") Boolean isChecked, @RequestParam("tagId") Long tagId, @RequestParam("id") Long userId) {
        log.info("Accediendo a todas las tareas según isChecked & tagId");
        return this.taskService.getTaskByIsChecked(isChecked, tagId, userId);
    }

    @GetMapping(value = {"", "/"}, params = {"!search", "!order", "!page", "!size", "!deadline", "!isChecked", "!start", "!end"})
    public List<Task> allByTagId(@RequestParam("tagId") Long tagId, @RequestParam("id") Long userId) {
        log.info("Accediendo a todas las tareas según tagId");
        return this.taskService.getAllTaskByTagId(tagId, userId);
    }

    @GetMapping(value = {"", "/"}, params = {"!search", "!order", "!page", "!size", "!deadline", "!isChecked"})
    public List<Task> allByMonth(@RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("id") Long userId) {
        log.info("Accediendo a todas las tareas por comienzo y fin de mes");
        return this.taskService.getTaskByMonth(start, end, userId);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "page", defaultValue = "0") int page,
                                                   @RequestParam(value = "size", defaultValue = "3") int size) {
        log.info("Accediendo a tareas con paginación");
        Map<String, Object> responseAll = this.taskService.all(page, size);
        return ResponseEntity.ok(responseAll);
    }

    @PostMapping({"", "/"})
    public Task newTask(@RequestBody Task task) {
        return this.taskService.save(task);
    }

    @GetMapping("/{id}")
    public Task one(@PathVariable("id") Long id) {
        return this.taskService.one(id);
    }

    @PutMapping("/{id}")
    public Task replaceTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return this.taskService.replace(id, task);

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        this.taskService.delete(id);
    }
}
