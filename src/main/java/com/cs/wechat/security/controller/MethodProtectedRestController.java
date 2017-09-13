package com.cs.wechat.security.controller;

import com.cs.wechat.pojo.dto.PwdInfo;
import com.cs.wechat.security.entity.User;
import com.cs.wechat.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jonsy
 *
 */
@RestController
@RequestMapping("protected")
public class MethodProtectedRestController {

    @Autowired
    UserService userService;
    /**
     * This is an example of some different kinds of granular restriction for endpoints. You can use the built-in SPEL expressions
     * in @PreAuthorize such as 'hasRole()' to determine if a user has access. Remember that the hasRole expression assumes a
     * 'ROLE_' prefix on all role names. So 'ADMIN' here is actually stored as 'ROLE_ADMIN' in database!
     **/
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getProtectedGreeting() {
        return ResponseEntity.ok("Greetings from admin protected method!");
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User get(@PathVariable Integer id){
        return userService.get(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String add(@RequestBody User user) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        //userService.save(user);
        return "success";
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String changePwd(@RequestBody PwdInfo pwdInfo) {
        return userService.changePwd(pwdInfo);
    }


}