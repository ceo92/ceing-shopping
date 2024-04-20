package ceing.ceing;

import ceing.ceing.domain.Item;
import ceing.ceing.domain.Member;
import ceing.ceing.repository.ItemRepositoryImplJpa;
import ceing.ceing.repository.LoginTempRepository;
import ceing.ceing.repository.MemberRepository;
import ceing.ceing.web.login.LoginDto;
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
    private final ItemRepositoryImplJpa itemRepository;
    private final MemberRepository memberRepository;
    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initItems() {
        log.info("test data init");
        Item item1 = new Item("GalaxyBook", 2500000, 5);
        Item item2 = new Item("MacBook", 4000000, 10);
        itemRepository.save(item1);
        itemRepository.save(item2);

        Member member1 = new Member("lee" , "청와대로 13번길", "01012345678" , "aaa" , "aaa");
        Member member2 = new Member("kim" , "도산대로 12번길", "01000220332" , "bbb" , "bbb");
        memberRepository.save(member1);
        memberRepository.save(member2);

    }
}
