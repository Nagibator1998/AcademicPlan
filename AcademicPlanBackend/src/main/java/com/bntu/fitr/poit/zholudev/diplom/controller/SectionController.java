package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Section;
import com.bntu.fitr.poit.zholudev.diplom.entity.Topic;
import com.bntu.fitr.poit.zholudev.diplom.service.SectionService;
import com.bntu.fitr.poit.zholudev.diplom.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.SECTION_NAME)
public class SectionController extends EntityController<Section, SectionService> {

    @Autowired
    public SectionController(SectionService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public ResponseEntity saveAll(@RequestBody List<Section> sections){
        List<Section> savedSections = new ArrayList<>();
        for(Section section : sections) {
            List<Topic> topics = new ArrayList<>(section.getTopics());
            section.setTopics(null);
            section = this.service.save(section);
            for(Topic topic : topics){
                topic.setSectionId(section.getId());
            }
            section.setTopics(topics);
            savedSections.add(this.service.update(section));
        }
        return ResponseEntity.ok(savedSections);
    }

}
