package hello.servelet.basic.request.domain.member;

import hello.servelet.domain.member.Member;
import hello.servelet.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository= MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }
    // 테스트 전체 실행시 테스트 마다 실행 순서는 보장 X
    // 위 코드 작성시 하나의 테스트 종료시 clearStore로 클리어해줌
    // 그래서 전체 코드 실행시 오류가 발생하지 않는다

    @Test
    void save() {
        // given
        Member member = new Member("hello", 20);
        // when
        Member savedMember = memberRepository.save(member);
        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 21);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);


    }
}
