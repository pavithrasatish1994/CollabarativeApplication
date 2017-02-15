package com.niit.OrgValleyBackend.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.OrgValleyBackend.dao.UsersDao;
import com.niit.OrgValleyBackend.daoimpl.UsersDaoImpl;
import com.niit.OrgValleyBackend.model.Users;

@RestController
public class UsersController {
@Autowired
Users users;
@Autowired
UsersDao usersDao;


//----------------------------------------------FETCH ALL USERS---------------------------------------------

@RequestMapping(value = "/users", method = RequestMethod.GET)
public ResponseEntity<List<Users>> list() {
    List<Users> userslst = usersDao.list();
    
    if(userslst.isEmpty()){
        return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
        //You many decide to return HttpStatus.NOT_FOUND
    }
    return new ResponseEntity<List<Users>>(userslst, HttpStatus.OK);
}

//---------------------------------------------FETCH ONE USER--------------------------------------------------
@RequestMapping(value = "/users/dologs/{id}/{pwd}", method = RequestMethod.GET)
public ResponseEntity<Users> getUser(@PathVariable("id") int id,@PathVariable("pwd") String pwd) {


	System.out.println("Fetching User with id "+id);
    users = usersDao.getUser(id);
    if (users == null) {
        System.out.println("User with id  not found");
        return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Users>(users, HttpStatus.OK);
}

//--------------------------------------------INSERT-------------------------------------------------------------
@RequestMapping(value = "/users/insert", method = RequestMethod.POST )
public ResponseEntity<Void> createUser(@ModelAttribute("users") Users user, @RequestBody Users users,   UriComponentsBuilder ucBuilder) {
       System.out.println("Doneeeeeeeeeeeeeeeeee Here "+users.getLogin_id());
       
    usersDao.insertORupdate(users);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(users.getLogin_id()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
}

//------------------------------------------------DELETE --------------------------------------------------------
 
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Users> deleteUser(@PathVariable("id") int id) {
    System.out.println("Fetching & Deleting User with id " + id);
    usersDao.delUsers(id);
    return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
}
@RequestMapping(value = "/user", method = RequestMethod.GET)
public ResponseEntity<Users> testing() {
    System.out.println("Fetching & Deleting User with id ");
//    usersDao.delUsers(id);
    return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
}

}
