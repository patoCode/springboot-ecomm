package f5.software.ecomm.infraestructure.mapper;

import f5.software.ecomm.domain.User;
import f5.software.ecomm.infraestructure.entity.UserEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings(
        {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastname", target = "lastname"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "cellphone", target = "cellphone"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "created", target = "created")
        }
    )
    User toUser(UserEntity entity);
    Iterable<User> toUsers(Iterable<UserEntity> users);

    @InheritConfiguration
    UserEntity toUserEntity(User u);

}
