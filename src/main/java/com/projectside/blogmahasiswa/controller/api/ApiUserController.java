//package com.projectside.blogmahasiswa.controller.api;
//
//import com.projectside.blogmahasiswa.domain.Role;
//import com.projectside.blogmahasiswa.domain.User;
//import com.projectside.blogmahasiswa.dto.UserDto;
//import com.projectside.blogmahasiswa.service.PrivilegeService;
//import com.projectside.blogmahasiswa.service.UserService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.ws.rs.NotFoundException;
//
//import java.text.SimpleDateFormat;
//import java.util.Optional;
//
//import static org.springframework.data.domain.PageRequest.of;
//
//@RestController
//@RequestMapping(path = "/api/v1/user")
//public class ApiUserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PrivilegeService privilegeService;
//
//    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE) // map only GET requests
//    public ResponseEntity<UserDto> addNewUser (@Valid @RequestBody UserDto userDto) {
//        User user = toModel(userDto);
//        user = userService.save(user);
//        userDto = toDto(user);
//        userDto.setRespCode("OK200");
//        userDto.setRespMessage("Success to Creating");
//        userDto.setRespResult("Y");
//        return ResponseEntity.ok().body(userDto);
//    }
//
//    @GetMapping(value = "/all")
//    public Page<UserDto> getAllUsers(@RequestParam(name = "page", defaultValue = "0") int page,
//                                  @RequestParam(name = "size", defaultValue = "10") int size,
//                                  @RequestParam(name = "direction", defaultValue = "ASC") Sort.Direction direction,
//                                  @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
//        return userService.findAll(of(page, size, direction, sortBy)).map(this::toDto);
//    }
//
//    @CrossOrigin
//    @GetMapping(value = "/detail/{id}")
//    public UserDto getDetailUser(@PathVariable String id) {
//        return userService.findById(id).map(this::toDto).orElseThrow(NotFoundException::new);
//    }
//
//    private UserDto toDto(User user) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
//
//        UserDto userDto = new UserDto();
//        BeanUtils.copyProperties(user, userDto);
//        userDto.setRole(user.getRole().getId());
//        userDto.setPrivilegeName(user.getRole().getName());
//        return userDto;
//    }
//
//    private User toModel(UserDto userDto) {
//        User user = new User();
//        Role role = privilegeService.findById(userDto.getRole()).get();
//        BeanUtils.copyProperties(userDto, user);
//        user.setRole(role);
//        return user;
//    }
//
//}
