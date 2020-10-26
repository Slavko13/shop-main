package ru.shop.dbtools.repositories;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.repository.CrudRepository;
import ru.shop.dbtools.models.user.Role;


public interface RoleRepo extends CrudRepository<Role, Code> {
}
