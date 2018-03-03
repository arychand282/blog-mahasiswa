package com.projectside.blogmahasiswa.controller.api;

import com.projectside.blogmahasiswa.domain.User;
import com.projectside.blogmahasiswa.dto.UserDto;
import com.projectside.blogmahasiswa.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import java.util.Optional;

import static org.springframework.data.domain.PageRequest.of;

@RestController
@RequestMapping(path = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE) // map only GET requests
    public ResponseEntity<UserDto> addNewUser (@Valid @RequestBody UserDto userDto) {
        User user = toModel(userDto);
        user = userService.save(user);
        userDto = toDto(user);
        userDto.setRespCode("OK200");
        userDto.setRespMessage("Success to Creating");
        userDto.setRespResult("Y");
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping(value = "/all")
    public Page<UserDto> getAllUsers(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "10") int size,
                                  @RequestParam(name = "direction", defaultValue = "ASC") Sort.Direction direction,
                                  @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return userService.findAll(of(page, size, direction, sortBy)).map(this::toDto);
    }

    @GetMapping(value = "/detail/{id}")
    UserDto getDetailUser(@PathVariable String id) {
        return userService.findById(id).map(this::toDto).orElseThrow(NotFoundException::new);
    }

    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    private User toModel(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

}
