package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private DiscountPolicy discountpolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public void OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //로미오와 줄리엣에서 로미오 역을 맡은 배우가 줄리엣 역을 맡을 배우를 고르는 것과 같음
    // DIP 위반! => 항상 추상화에 의존해라
    // discountpolicy는 인터페이스 => 직접 객체인 fixdiscountpolicy 생성
    // 의도한 바는, 지금의 OrderServiceImpl이 DiscountPolicy 라는 인터페이스에 의존하는 것.
    // 그러나, 현재 이미 구체화 되어 있는 RateDiscountPolicy에도 의존하고 있음.
    // 이렇게 의존 관계가 있으면, RateDiscountPolicy를 FixDiscountPolicy로 바꾸는 순간 아래의 소스 코드 전부를 바꿔야 함.
    // => 객체지향적이지 못함!
    // private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
