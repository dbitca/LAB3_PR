package com.example.lab33333.Service;
import com.example.lab33333.models.Object;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class ServiceClass {
    private List<Object> objectList = new CopyOnWriteArrayList<>();
    private int idCount = 1;

    public Object addObject(Object object) {
        object.setId(idCount);
        objectList.add(object);
        idCount++;
        return object;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    //to modify get object according to ID
    public Object getObject(int objectId) {
        int id = 0;
        for (Object o : objectList) {
            if (o.getId() == objectId) {
                id = objectList.indexOf(o);
                break;
            }
        }
        return objectList.get(id);
    }

    public Object updateObject(int Id, Object object) {
        int id = 0;
        for (Object o : objectList) {
            if (o.getId() == Id) {
                o.setName(object.getName());
                id = objectList.indexOf(o);
            }
        }
        return objectList.get(id);
    }

    public void deleteObject(int Id) {
        for (Object o : objectList) {
            if (o.getId() == Id) {
                objectList.remove(o);
            }
        }
    }
}
