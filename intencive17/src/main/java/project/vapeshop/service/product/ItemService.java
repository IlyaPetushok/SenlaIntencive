package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IItemDao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.type.CategoryType;
import project.vapeshop.entity.product.Item;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private IItemDao dao;
    private ModelMapper modelMapper;

    public ItemService() {
    }

    @Autowired
    public ItemService(IItemDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public ItemDTOFullInfo showItem(int id) {
        return modelMapper.map(dao.selectObject(id), ItemDTOFullInfo.class);
    }

    public List<ItemDTOInfoForCatalog> showItems() {
        return dao.selectObjects().stream()
                .map(item -> modelMapper.map(item, ItemDTOInfoForCatalog.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemDTOFullInfo addItem(ItemDTOFullInfo itemDTO) {
        return modelMapper.map(dao.insertObject(modelMapper.map(itemDTO, Item.class)), ItemDTOFullInfo.class);
    }

    @Transactional
    public List<ItemDTOFullInfo> addItems(List<ItemDTOFullInfo> itemDTO) {
        List<Item> items = dao.insertObjects((itemDTO.stream()
                .map(itemDTOFullInfo -> modelMapper.map(itemDTOFullInfo, Item.class))
                .collect(Collectors.toList())));
        return items.stream()
                .map(item -> modelMapper.map(item, ItemDTOFullInfo.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    @Transactional
    public ItemDTOFullInfo updateItem(ItemDTOFullInfo itemDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(itemDTOFullInfo, Item.class)), ItemDTOFullInfo.class);
    }


    public List<ItemDTOInfoForCatalog> showItemByCategory(String nameCategory){
        List<Item> items =dao.selectFindByCategory(CategoryType.getTypeValue(nameCategory));
        return items.stream()
                .map(item -> modelMapper.map(item,ItemDTOInfoForCatalog.class))
                .collect(Collectors.toList());
    }
}
