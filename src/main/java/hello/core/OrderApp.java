package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();
        OrderService orderService = appconfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = "+order);
    }
}
