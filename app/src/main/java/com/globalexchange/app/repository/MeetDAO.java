package com.globalexchange.app.repository;
//

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.mapper.MeetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//
//
@Repository
@RequiredArgsConstructor
public class MeetDAO{
    private final MeetMapper meetMapper;

    public List<MeetVO> meetSelectAll(Criteria criteria){
        return meetMapper.meetSelectAll(criteria);
    }
    public List<MeetVO> categoryMeetSelectAll(Criteria criteria,String meetLearningLang){
        return meetMapper.categoryMeetSelectAll(criteria, meetLearningLang);
    }
    public int getTotal(){
        return meetMapper.getTotal();
    }

    public int categoryGetTotal(String meetLearningLang) {
        return meetMapper.categoryGetTotal(meetLearningLang);
    }

    //작성자 정보 가져오기
    public MemberVO writerInfo(Long memberNumber){
        return meetMapper.writerInfo(memberNumber);
    }

    //meet 게시글 등록
    public void insertRequest(MeetDTO meetDTO){
        meetMapper.insertRequest(meetDTO);
    }

    //meet 게시글 detail 이동
    public MeetVO selectMeetRequest(Long meetNumber){
        return meetMapper.selectMeetRequest(meetNumber);
    }

    //meet 게시글 update
    public void updateRequest(MeetDTO meetDTO){
        meetMapper.updateRequest(meetDTO);
    }
    //meet 게시글 delete
    public void deleteRequest(Long meetNumber){
        meetMapper.deleteRequest(meetNumber);
    }
    //meet 답글 select 페이지네이션
    public List<MeetAnswerVO> meetAnswerSelectAll(Long meetNumber, Criteria criteria){
        return meetMapper.meetAnswerSelectAll(meetNumber,criteria);
    }

    //meet 답글 갯수 세기
    public long meetAnswerCount(Long meetNumber){
        return meetMapper.meetAnswerCount(meetNumber);
    }
    //meet 답글 업데이트
    public void  meetAnswerUpdate(MeetAnswerVO meetAnswerVO){
         meetMapper.meetAnswerUpdate(meetAnswerVO);

    }
    //meet 답글 쓰기 인서트
    public void meetAnswerInsert(MeetAnswerVO meetAnswerVO){
        meetMapper.meetAnswerInsert(meetAnswerVO);
    }
    //meet 답글 코멘트 전체 불러오기
    public List<MeetAnswerCommentVO> meetAnswerCommentSelectAll (Long meetAnswerNumber){
        return meetMapper.meetAnswerCommentSelectAll(meetAnswerNumber);
    }

    // 답글이 없는 최신글 조회
    public List<MeetVO> findAllLatestNotAnsweredMeet(Criteria criteria){
        return meetMapper.selectAllLatestNotAnsweredMeet(criteria);
    }

    // 답글이 있는 최신글 조회
    public List<MeetVO> findAllLatestAnsweredMeet(Criteria criteria) {
        return meetMapper.selectAllLatestAnsweredMeet(criteria);
    }
    
    // meet 답글 삭제
    public void meetAnswerRemove(Long meetAnswerNumber){
        meetMapper.meetAnswerRemove(meetAnswerNumber);
    }
    //meet 댓글 코멘트 등록
    public void meetCommentInsert(MeetAnswerCommentVO meetAnswerCommentVO){
        meetMapper.meetCommentInsert(meetAnswerCommentVO);
    }
    //meet 댓글 코멘트 업데이트
    public void meetCommentUpdate(MeetAnswerCommentVO meetAnswerCommentVO){
        meetMapper.meetCommentUpdate(meetAnswerCommentVO);
    }
    //meet 댓글 코멘트 삭제
    public void meetCommentRemove(Long meetAnswerCommentNumber){
        meetMapper.meetCommentRemove(meetAnswerCommentNumber);
    }

    // 게시글 삭제
    public void removeMeet(Long meetNumber){
        meetMapper.deleteMeet(meetNumber);
    }
}
