package com.okme.fam.repository;

public interface UserRepositoryCustom {
    void saveTicket(String ticket, String userName, String jwt);
}
