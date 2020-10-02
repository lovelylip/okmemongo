package com.okme.fam.repository.impl;

import com.okme.fam.domain.User;
import com.okme.fam.repository.UserRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MongoTemplate mongoTemplate;

    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveTicket(String ticket, String userName, String jwt){
        String sql = "UPDATE jhi_user SET TICKET = :ticket, jwt = :jwt  WHERE login = :userName";
        Query query = new Query();
        query.addCriteria(Criteria.where("login").is(userName));
        Update update = new Update();
        update.set("TICKET", ticket);
        update.set("jwt", jwt);
        mongoTemplate.updateMulti(query, update, User.class);

//        User user = mongoTemplate.findOne(
//            Query.query(Criteria.where("login").is(userName)), User.class);
//        user.setTicket(ticket);
//        user.setJwt(jwt);
//        mongoTemplate.save(user);
    }
}
