package com.eglowc.simpleblog.web;

import com.eglowc.simpleblog.dto.OwnerDto;
import com.eglowc.simpleblog.models.Owner;
import com.eglowc.simpleblog.models.support.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;


/**
 * @author eglowc<eglowc@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OwnerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;


    private Owner getInitiateOwner() {
        Owner owner = new Owner();
        owner.setEmail("eglowc@gmail.com");
        owner.setPassword("12341234");
        owner.setSignature("eglowc");
        return owner;
    }

    @Test
    public void getOwnerWhenNoContent() throws Exception {
        // given

        // when
        ResponseEntity result = this.restTemplate.getForEntity("/owner", OwnerDto.Read.class);

        // then
        assertThat("Owner 가 없으면 204 NO_CONTENT 를 반환한다", result.getStatusCode(), is(equalTo(NO_CONTENT)));
        assertThat("Owner 는 null 이다", result.getBody(), is(nullValue()));

    }

    @Test
    public void getOwnerWhenFindOwner() throws Exception {
        // given
        this.restTemplate.put("/owner/create", modelMapper.map(getInitiateOwner(), OwnerDto.Create.class));

        // when
        ResponseEntity<OwnerDto.Read> result = this.restTemplate.getForEntity("/owner", OwnerDto.Read.class);

        // then
        assertThat("Owner 가 있으면 200 OK", result.getStatusCode(), is(equalTo(OK)));
        assertThat("Owner 가 null 이 아니다", result.getBody(), is(notNullValue()));
        assertThat("Role.OWNER 역할을 갖는다", result.getBody().getRole(), is(equalTo(Role.OWNER)));

    }


}