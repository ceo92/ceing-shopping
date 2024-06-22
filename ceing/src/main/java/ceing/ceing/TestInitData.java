package ceing.ceing;

import ceing.ceing.domain.Address;
import ceing.ceing.domain.Item;
import ceing.ceing.domain.Member;
import ceing.ceing.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Component
public class TestInitData {
    private final MemberRepository memberRepository;
    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initItems() {
        log.info("test data init");

        Member member1 = new Member("lee" , new Address("경수대로 932" , "18093"), "01012345678" , "aaa" , "aaa");
        Member member2 = new Member("kim" , new Address("도산대로 539" , "25873"), "01012346677" , "bbb" , "bbb");
        memberRepository.save(member1);
        memberRepository.save(member2);

    }
}
