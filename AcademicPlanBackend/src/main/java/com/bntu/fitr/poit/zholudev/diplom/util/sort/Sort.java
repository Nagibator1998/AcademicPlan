package com.bntu.fitr.poit.zholudev.diplom.util.sort;

import org.apache.poi.util.ArrayUtil;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.List;

public class Sort {

    public static void sortListByFieldAscending(List list, String fieldName) throws Exception{
        if(CollectionUtils.isEmpty(list)){
            return;
        }
        String[] splitFields = fieldName.split("\\.");
        if(splitFields.length == 0){
            splitFields = new String[]{fieldName};
        }
        for(int i = 0; i < list.size(); i++) {
            Long value1 = (Long) getFieldValue(splitFields, list.get(i));
            for(int j = i; j < list.size(); j++){
                Long value2 = (Long) getFieldValue(splitFields, list.get(j));
                if(value2 < value1){
                    Object temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }

        }
    }

    private static Object getFieldValue(String[] fields, Object object) throws Exception{
        Field field = object.getClass().getDeclaredField(fields[0]);
        field.setAccessible(true);
        Object newObject = field.get(object);
        if(fields.length > 1) {
            String[] newFields = new String[fields.length - 1];
            for (int i = 0; i < newFields.length; i++) {
                newFields[i] = fields[i+1];
            }
            return getFieldValue(newFields, newObject);
        }
        return newObject;
    }

}
