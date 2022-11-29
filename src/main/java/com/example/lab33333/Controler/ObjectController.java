package com.example.lab33333.Controler;
import com.example.lab33333.models.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.lab33333.Service.ServiceClass;

@RestController
@RequestMapping("/object")
public class ObjectController {

    @Autowired
    private ServiceClass objectService;
    //Logger log = LoggerFactory.getLogger(ObjectController.class);
    //method to add customer to a list
    @PostMapping("/addObject")
    public Object addObject(@RequestBody Object object){
        System.out.println("Object was added through post method");
        return objectService.addObject(object);
    }
    //method to retrieve full object list
    @GetMapping("/getObjectList")
    public List<Object> getObjects(){
        System.out.println("Service sent full list of Objects");
    return objectService.getObjectList();
    }
    //method to retrieve object by Id
    @GetMapping("/getObject/{Id}")
    public Object getObject(@PathVariable("Id") int Id){
        System.out.println("Service sent object with id: " + Id);
        return objectService.getObject(Id);
    }
    //method to update object
    @PutMapping("/updateObject/{Id}")
    public Object updateObject(@PathVariable("Id") int Id, @RequestBody Object object){
        System.out.println("Service updated object with id: "+ Id);
        return objectService.updateObject(Id,object);
    }

    @DeleteMapping("/deleteObject/{Id}")
        public void deleteCustomer(@PathVariable("Id") int Id){
        System.out.println("Service deleted object with id: " + Id);
        objectService.deleteObject(Id);
    }
}
