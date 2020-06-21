package com.jpwhealth.controller;

import com.jpwhealth.domain.News;
import com.jpwhealth.domain.dto.NewsDetailedDto;
import com.jpwhealth.domain.dto.NewsDto;
import com.jpwhealth.domain.form.NewsForm;
import com.jpwhealth.domain.form.NewsFormUpdate;
import com.jpwhealth.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ApiOperation(value = "Lista o cadastro de notícias", notes = "Lista o cadastro de notícias da página", response = NewsDto.class, responseContainer = "List" )
    @GetMapping("/news")
    public ResponseEntity<?> getAll(Pageable pageable){
        return ResponseEntity.ok(newsService.getAll(pageable));
    }

    @ApiOperation(value = "Lista o cadastro de notícias por id", notes = "Lista o cadastro de um notícias específica", response = NewsDetailedDto.class, responseContainer = "Object" )
    @GetMapping("/news/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok(newsService.getById(id));
    }

    @ApiOperation(value = "Insere uma nova notícia", notes = "Insere o cadastro de uma nova notícia na nossa base de dados", response = NewsDto.class, responseContainer = "Object" )
    @PostMapping("/news")
    public ResponseEntity<NewsDto> register(@Valid @RequestBody NewsForm newsForm){
        News news = newsService.register(newsForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(new NewsDto(news));
    }

    @ApiOperation(value = "Atualiza o cadastro de uma notícia", notes = "Atualiza os dados cadastrais da notícia", response = NewsDto.class, responseContainer = "Object" )
    @PutMapping("/news")
    public ResponseEntity<NewsDto> update(@Valid @RequestBody NewsFormUpdate newsFormUpdate){
        return newsService.update(newsFormUpdate);
    }

    @ApiOperation(value = "Remove o cadastro de notícia", notes = "Remove o registro cadastral da notícia informada", response = ResponseEntity.class, responseContainer = "Object" )
    @DeleteMapping("/news/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return newsService.delete(id);
    }

}
