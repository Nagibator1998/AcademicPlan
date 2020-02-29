package com.bntu.fitr.poit.zholudev.diplom.service;

import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProject;

public interface CourseProjectService extends EntityService<CourseProject> {
    CourseProject getByExplanatoryNoteId(Long explanatoryNoteId);
}
