package com.bntu.fitr.poit.zholudev.diplom.service;

import com.bntu.fitr.poit.zholudev.diplom.entity.University;

public interface UniversityService extends EntityService<University> {

    University getBySpecialityId(Long specialityId);
}
