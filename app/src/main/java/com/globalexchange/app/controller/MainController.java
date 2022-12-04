package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.service.MainService;
import com.globalexchange.app.service.MemberObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/main/*")
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MemberObjectificationService memberObjectificationService;
    private final MainService mainService;

    // 메인 페이지
    @GetMapping("/main")
    public void main(HttpServletRequest request, Model model){

        // 세션에 정보가 있는 경우
        if(request.getSession().getAttribute("memberNumber") != null){
            Long memberNumber = (Long) request.getSession().getAttribute("memberNumber");
            model.addAttribute("member", memberObjectificationService.show(memberNumber));
        }

        model.addAttribute("latestAnsweredMeetList", mainService.showAllLatestAnsweredMeet());
        model.addAttribute("latestNotAnsweredMeetList", mainService.showAllLatestNotAnsweredMeet());
        model.addAttribute("latestAnsweredLodgingList", mainService.showAllLatestAnsweredLodging());
        model.addAttribute("latestNotAnsweredLodgingList", mainService.showAllLatestNotAnsweredLodging());
    }

}
