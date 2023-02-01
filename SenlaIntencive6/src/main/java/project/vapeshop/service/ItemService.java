package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.annotation.Transaction;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Item;
import project.vapeshop.holder.ConnectionHolder;
import project.vapeshop.mapper.impl.product.ItemForCatalogMapper;
import project.vapeshop.mapper.impl.product.ItemFullInfoMapper;

import java.sql.Connection;
import java.util.List;

@Service
public class ItemService {
    Dao<Item> dao;
    ItemForCatalogMapper itemForCatalogMapper;
    ItemFullInfoMapper itemFullInfoMapper;
    ConnectionHolder connectionHolder;

    @Autowired
    public ItemService(Dao<Item> dao, ItemForCatalogMapper itemForCatalogMapper, ItemFullInfoMapper itemFullInfoMapper, ConnectionHolder connectionHolder) {
        this.dao = dao;
        this.itemForCatalogMapper = itemForCatalogMapper;
        this.itemFullInfoMapper = itemFullInfoMapper;
        this.connectionHolder = connectionHolder;
    }

    public ItemDTOFullInfo showItem(int id) {
        return itemFullInfoMapper.toDTO(dao.selectObject(id));
    }

    public List<ItemDTOInfoForCatalog> showItems() {
        return itemForCatalogMapper.toDTOs(dao.selectObjects());
    }

    @Transaction
    public boolean addItem(ItemDTOFullInfo itemDTO) {
        return dao.insertObject(itemFullInfoMapper.toEntity(itemDTO));
    }

    public boolean addItems(List<ItemDTOFullInfo> itemDTO) {
        return dao.insertObjects(itemFullInfoMapper.toEntities(itemDTO));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public ItemDTOInfoForCatalog updateItem(ItemDTOFullInfo itemDTOFullInfo) {
        return itemForCatalogMapper.toDTO(dao.update(itemFullInfoMapper.toEntity(itemDTOFullInfo)));
    }
}
