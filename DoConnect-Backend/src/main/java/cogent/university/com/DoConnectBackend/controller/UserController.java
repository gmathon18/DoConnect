package cogent.university.com.DoConnectBackend.controller;

import cogent.university.com.DoConnectBackend.entity.AuthRequest;
import cogent.university.com.DoConnectBackend.entity.User;
import cogent.university.com.DoConnectBackend.service.UserService;
import cogent.university.com.DoConnectBackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String welcome(){
        return "Welcome User";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest request) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e){
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(request.getUsername());
    }

    //Add user
    @PostMapping("/addUser")
    public User addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    //Get All Users
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    //Get User By ID
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);

    }

    //Get User By Name
    @GetMapping("/getByName/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return userService.getByName(name);
    }

    //Get User By type
    @GetMapping("/getAllByUserType/{userType}")
    public List<User> getAllByUserType(@PathVariable("userType") String userType){
        return userService.getAllByUserType(userType);
    }

    //Update User
    @PutMapping("/updateUser/{id}")
    public User updateUserById(@RequestBody User user,
                               @PathVariable("id") int id){
        return userService.updateUser(user, id);
    }


}