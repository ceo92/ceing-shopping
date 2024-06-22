package ceing.ceing.formatter;

import ceing.ceing.domain.Address;
import ceing.ceing.domain.Member;
import java.text.ParseException;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

@Slf4j
public class AddressFormatter implements Formatter<Address> {

  @Override
  public Address parse(String text, Locale locale) throws ParseException {
    log.info("null 관련 문제 발생 시 AddressFormatter 뒤지자 ");
    return null;
  }

  @Override
  public String print(Address address, Locale locale) {
    return address.getRoadNameAddress() + address.getZipCode();
  }
}
