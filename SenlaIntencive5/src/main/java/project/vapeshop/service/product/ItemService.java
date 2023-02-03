package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.annotation.Transaction;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Item;
import project.vapeshop.holder.ConnectionHolder;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class ItemService {
    Dao<Item> dao;
    ModelMapper modelMapper;
    ConnectionHolder connectionHolder;

    @Autowired
    public ItemService(Dao<Item> dao, ModelMapper modelMapper, ConnectionHolder connectionHolder) {
        this.dao = dao;
        this.modelMapper = modelMapper;
        this.connectionHolder = connectionHolder;
    }


    public ItemDTOFullInfo showItem(int id) {
        return modelMapper.map(dao.selectObject(id), ItemDTOFullInfo.class);
    }

    public List<ItemDTOInfoForCatalog> showItems() {
        return dao.selectObjects().stream()
                .map(item -> modelMapper.map(item, ItemDTOInfoForCatalog.class))
                .toList();
    }

    @Transaction
    public boolean addItem(ItemDTOFullInfo itemDTO) {
        return dao.insertObject(modelMapper.map(itemDTO, Item.class));
    }

    public boolean addItems(List<ItemDTOFullInfo> itemDTO) {
        return dao.insertObjects((itemDTO.stream().map(itemDTOFullInfo -> modelMapper.map(itemDTOFullInfo, Item.class)).toList()));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public ItemDTOInfoForCatalog updateItem(ItemDTOFullInfo itemDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(itemDTOFullInfo, Item.class)), ItemDTOInfoForCatalog.class);
    }
}
