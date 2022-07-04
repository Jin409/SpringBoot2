package hello.core.member;

public class MemberServiceImpl implements MemberService{

//    public static void main(String[] args) {
//
//    }

    // 추상화에만 의존하는 것
    private final MemberRepository memberRepository;

    // Repository의 구현체가 뭐가 들어갈지를 생성자를 통해서 주입시켜줌.
    // setter
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long MemberId) {
        return null;
    }
}
