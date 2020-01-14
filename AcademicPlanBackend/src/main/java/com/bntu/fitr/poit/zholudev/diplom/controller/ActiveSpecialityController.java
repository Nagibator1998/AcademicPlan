package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ActiveSpeciality;
import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProject;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.ACTIVE_SPECIALITY_NAME)
public class ActiveSpecialityController extends EntityController<ActiveSpeciality> {

    EntityService<CourseProject> courseProjectService;

    @Autowired
    public ActiveSpecialityController(@Qualifier(EntityConstants.ACTIVE_SPECIALITY_NAME) EntityService<ActiveSpeciality> service,
                                      @Qualifier(EntityConstants.COURSE_PROJECT_NAME) EntityService<CourseProject> courseProjectService) {
        this.service = service;
        this.courseProjectService = courseProjectService;
    }

    @Override
    public ResponseEntity saveAll(@RequestBody List<ActiveSpeciality> activeSpecialities) {
        boolean isCourseProject = false;
        for (ActiveSpeciality activeSpeciality : activeSpecialities) {
            if (activeSpeciality.getCourseProject() != null) {
                isCourseProject = true;
                break;
            }
        }
        CourseProject courseProject = new CourseProject();
        if (isCourseProject) {
            courseProject = this.courseProjectService.save(courseProject);
        }
        for (ActiveSpeciality activeSpeciality : activeSpecialities) {
            if (activeSpeciality.getCourseProject() != null) {
                activeSpeciality.setCourseProject(courseProject);
            }
        }
        Iterable<ActiveSpeciality> savedActiveSpecialities = this.service.saveAll(activeSpecialities);
        return ResponseEntity.ok(savedActiveSpecialities);
    }

}


