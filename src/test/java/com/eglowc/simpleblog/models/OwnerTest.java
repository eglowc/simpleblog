package com.eglowc.simpleblog.models;

import com.eglowc.simpleblog.models.support.Role;
import com.eglowc.simpleblog.repository.OwnerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * @author eglowc<eglowc@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles(value = "dev")
public class OwnerTest {

    @Autowired
    private OwnerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void shouldSaveOwner() throws Exception {
        // given
        Owner persistOwner = new Owner();
        persistOwner.setEmail("eglowc@gmail.com");
        persistOwner.setPassword("12341234");
        persistOwner.setSignature("eglowc");
        repository.save(persistOwner);

        // when
        Optional<Owner> owner = repository.findByEmail("eglowc@gmail.com");

        // then
        assertThat("ID는 0보다 큰 새로운 숫자가 생성된다.", owner.map(Owner::getId).orElse(0L), is(greaterThan(0L)));
        assertThat("Roel 기본값은 UNKNOWN 이다.", owner.map(Owner::getRole).orElse(null), is(equalTo(Role.UNKNOWN)));
        assertNotEquals("created 값은 자동생성 되어야 합니다.", Optional.empty(), owner.map(Owner::getCreated));
    }
}