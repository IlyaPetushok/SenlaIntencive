package project.vapeshop.dao.impl;

import org.example.annotation.Autowired;
import org.example.annotation.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.models.ParametersHolder;

@Component
public class CatalogProduct implements Dao {
    @Autowired
    ParametersHolder parametersHolder;
    @Override
    public void execute() {
        System.out.println(parametersHolder.getSomeText());
    }
}
