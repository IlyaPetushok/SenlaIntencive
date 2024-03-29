package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Item;
import project.vapeshop.mapper.impl.product.ItemForCatalogMapper;
import project.vapeshop.mapper.impl.product.ItemFullInfoMapper;
import java.util.List;

@Service
public class ItemService {
    Dao<Item,Integer> dao;
    ItemForCatalogMapper itemForCatalogMapper;
    ItemFullInfoMapper itemFullInfoMapper;

    @Autowired
    public ItemService(Dao<Item,Integer> dao, ItemForCatalogMapper itemForCatalogMapper, ItemFullInfoMapper itemFullInfoMapper) {
        this.dao = dao;
        this.itemForCatalogMapper = itemForCatalogMapper;
        this.itemFullInfoMapper = itemFullInfoMapper;
    }

    public ItemDTOFullInfo showItem(int id) {
        return itemFullInfoMapper.toDTO(dao.getByIdObject(id));
    }

    public List<ItemDTOInfoForCatalog> showItems() {
        return itemForCatalogMapper.toDTOs(dao.gelAllObjects());
    }

    public boolean addItem(ItemDTOFullInfo itemDTO) {
        return dao.createObject(itemFullInfoMapper.toEntity(itemDTO));
    }

    public boolean addItems(List<ItemDTOFullInfo> itemDTO) {
        return dao.createObjects(itemFullInfoMapper.toEntities(itemDTO));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public ItemDTOInfoForCatalog updateItem(ItemDTOFullInfo itemDTOFullInfo) {
        return itemForCatalogMapper.toDTO(dao.update(itemFullInfoMapper.toEntity(itemDTOFullInfo)));
    }
}
