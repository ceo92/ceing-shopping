package ceing.ceing.formatter;

import ceing.ceing.domain.Member;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class MemberFormatter implements Formatter<Member> {
    @Override
    public Member parse(String text, Locale locale) throws ParseException {
        return new Member();
    }

    @Override
    public String print(Member member, Locale locale) {
        return member.toString();
    }
}
