package com.globalexchange.app.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DiaryDAOTest {

    @Autowired
    private DiaryDAO diaryDAO;

    @Test
    void saveDiaryPartner() {
        diaryDAO.saveDiaryPartner(2L, 4L);
    }
}