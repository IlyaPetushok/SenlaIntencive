package project.vapeshop.mapper;

import java.util.List;

public interface Mapper<T,C> {
    C toDTO(T t);
    List<C> toDTOs(List<T> tList);
    T toEntity(C c);
    List<T> toEntities(List<C> cList);
}
