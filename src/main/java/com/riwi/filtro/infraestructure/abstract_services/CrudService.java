package com.riwi.filtro.infraestructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.filtro.Util.enums.SortType;

public interface CrudService <RQ,RS,ID> {
    RS create(RQ request);
    RS get (ID id);
    RS update(RQ request, ID id);
    void delete(ID id);
    Page<RS> getAll(int page, int size, SortType sort);
}
