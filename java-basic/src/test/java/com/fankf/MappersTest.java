package com.fankf;

import com.fankf.mapstruct.Person;
import com.fankf.mapstruct.PersonToUserMapper;
import com.fankf.mapstruct.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fankunfeng
 * 2021-04-28 18:14
 */
@SpringBootTest
public class MappersTest {

    /**
     * @author fankunfeng
     * 2021-04-28 17:47
     */
    @Test
    public void test() {
        Person person = new Person(18, "zs");
        User user = PersonToUserMapper.INSTANCE.personToUser(person);
        System.out.println(user);
    }

}
