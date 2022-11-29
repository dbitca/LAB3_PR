package com.example.lab33333;
import com.example.lab33333.models.Object;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class ServiceClass {
    private List<Object> objectList = new CopyOnWriteArrayList<>();
    private int idCount = 1;

    public Object addObject(Object object){
        object.setId(idCount);
        objectList.add(object);
        idCount++;
        return object;
    }

    public List<Object> getObjectList (){
        return objectList;
    }

    public int getObjectListSize(){
        return objectList.size();
    }
//to modify get object according to ID
    public Object getObject(int objectId){
        return objectList.stream().filter(c -> c.getId() == objectId).findFirst().get();
    }

    public Object updateObject(int Id, Object object){
        objectList.stream().forEach(c -> {
            if(c.getId() == Id){
                c.setName(object.getName());
            }
        });
        return objectList.stream().filter(c-> c.getId() == Id).findFirst().get();
    }

    public void deleteObject(int Id){
        objectList.stream().forEach(c->{
            if(c.getId() == Id){
                objectList.remove(c);
            }
        });
    }
}
