package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Item;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private Dao<Item, Integer> dao;
    private ModelMapper modelMapper;

    public ItemService() {
    }

    @Autowired
    public ItemService(Dao<Item, Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public ItemDTOFullInfo showItem(int id) {
        Item item=dao.selectObject(id);
        return modelMapper.map(dao.selectObject(id), ItemDTOFullInfo.class);
    }

    public List<ItemDTOInfoForCatalog> showItems() {
        List<Item> items=dao.selectObjects();
        return dao.selectObjects().stream()
                .map(item -> modelMapper.map(item, ItemDTOInfoForCatalog.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemDTOFullInfo addItem(ItemDTOFullInfo itemDTO) {
        ItemDTOFullInfo itemDTOFullInfo=modelMapper.map(dao.insertObject(modelMapper.map(itemDTO, Item.class)), ItemDTOFullInfo.class);
        return itemDTOFullInfo;
    }

    public List<ItemDTOFullInfo> addItems(List<ItemDTOFullInfo> itemDTO) {
        List<Item> items = dao.insertObjects((itemDTO.stream()
                .map(itemDTOFullInfo -> modelMapper.map(itemDTOFullInfo, Item.class))
                .collect(Collectors.toList())));
        return items.stream()
                .map(item -> modelMapper.map(item, ItemDTOFullInfo.class))
                .collect(Collectors.toList());
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public ItemDTOFullInfo updateItem(ItemDTOFullInfo itemDTOFullInfo) {
        ItemDTOFullInfo itemDTO=modelMapper.map(dao.update(modelMapper.map(itemDTOFullInfo, Item.class)), ItemDTOFullInfo.class);
        return itemDTO;
    }
}