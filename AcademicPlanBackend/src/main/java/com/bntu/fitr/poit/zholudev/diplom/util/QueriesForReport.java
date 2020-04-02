package com.bntu.fitr.poit.zholudev.diplom.util;

import com.bntu.fitr.poit.zholudev.diplom.entity.ExplanatoryNote;
import com.bntu.fitr.poit.zholudev.diplom.entity.University;

public interface QueriesForReport {

    University getUniversityByExplanatoryNote(ExplanatoryNote explanatoryNote);
}
