package project.vapeshop.service.impl;

import org.example.annotation.Autowired;
import org.example.annotation.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.service.ServiceInterface;

@Component
public class AddProductService implements ServiceInterface {
    Dao dao;

    @Override
    public void execute() {
        dao.execute();
    }

    @Autowired
    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
