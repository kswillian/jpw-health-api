package com.jpwhealth.controller;

import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.dto.TopicDetailedDto;
import com.jpwhealth.domain.dto.TopicDto;
import com.jpwhealth.domain.form.TopicForm;
import com.jpwhealth.domain.form.TopicFormUpdate;
import com.jpwhealth.service.TopicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "Lista o cadastro de topicos", notes = "Lista o cadastro de topicos", response = TopicDto.class, responseContainer = "List" )
    @GetMapping("/topic")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(topicService.getAll());
    }

    @ApiOperation(value = "Lista o cadastro de topicos por id", notes = "Lista o cadastro de topicos", response = TopicDetailedDto.class, responseContainer = "List" )
    @GetMapping("/topic/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok(topicService.getById(id));
    }

    @ApiOperation(value = "Insere um novo topico", notes = "Insere um novo topico na nossa base de dados", response = TopicDto.class, responseContainer = "List" )
    @PostMapping("/topic")
    public ResponseEntity<TopicDto> register(@Valid @RequestBody TopicForm topicForm){
        Topic topic = topicService.register(topicForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TopicDto(topic));
    }

    @ApiOperation(value = "Atualiza o cadastro de um topico", notes = "Atualiza os dados cadastrais do topico", response = TopicDto.class, responseContainer = "List" )
    @PutMapping("/topic")
    public ResponseEntity<TopicDto> update(@Valid @RequestBody TopicFormUpdate topicFormUpdate){
        return topicService.update(topicFormUpdate);
    }

    @ApiOperation(value = "Remove o cadastro de um topico", notes = "remove o registro cadastral do topico informado", response = ResponseEntity.class, responseContainer = "List" )
    @DeleteMapping("/topic/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return topicService.delete(id);
    }

}
