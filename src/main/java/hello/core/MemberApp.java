package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //psvm + enter
    public static void main(String[] args) {
//        AppConfig appconfig = new AppConfig();
//        MemberService memberService = appconfig.memberService();

        //AppConfig의 환경설정 정보를 갖고 전부 스프링 빈에 넣고 객체를 관리해줌
        // 이제는 직접 찾지 않고 applicationContext 를 이용해서 찾아옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //"memberService"는 메서드명 (객체의 이름) 뒤의 MemberSerivce.class 는 반환타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}