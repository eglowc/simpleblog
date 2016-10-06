package com.eglowc.simpleblog.web;

import com.eglowc.simpleblog.models.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.springframework.http.HttpStatus.NO_CONTENT;


/**
 * @author eglowc<eglowc@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OwnerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    private Owner getInitiateOwner() {
        Owner owner = new Owner();
        owner.setEmail("eglowc@gmail.com");
        owner.setPassword("12341234");
        owner.setSignature("eglowc");
        return owner;
    }

    @Test
    public void getOwner() throws Exception {
        ResponseEntity<Owner> result = this.restTemplate.getForEntity("/owner", Owner.class);

        assertThat("Owner 가 없으면 204 NO_CONTENT 를 반환한다", result.getStatusCode(), is(equalTo(NO_CONTENT)));
        assertThat("Owner 는 null 이다", result.getBody(), is(nullValue()));
        System.out.println(result);
    }


}