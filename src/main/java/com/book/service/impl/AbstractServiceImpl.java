package com.book.service.impl;

import com.book.common.DateUtils;
import com.book.common.OptionalUtils;
import com.book.dao.AbstractDao;
import com.book.entity.Abstract;
import com.book.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhao Jinyan
 * @date 2019/4/3 21:04
 */
@Service
public class AbstractServiceImpl implements AbstractService {

    private final AbstractDao dao;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public AbstractServiceImpl(AbstractDao dao) {
        this.dao = dao;
    }

    @Override
    public long save(String content) {
        Abstract abstractContent = new Abstract().setContent(content);
        dao.insert(abstractContent);
        return abstractContent.getId();
    }

    @Override
    public long save(long id, String content) {
        if(id == 0){
            return 0;
        }
        Abstract abstractContent = dao.selectById(id);
        if(abstractContent.getContent().equals(content)){
            return id;
        }
        if(OptionalUtils.isBlank(content)){
            dao.deleteById(id);
            return 0;
        }
        abstractContent.setContent(content);
        dao.updateById(abstractContent);
        return id;
    }
}
