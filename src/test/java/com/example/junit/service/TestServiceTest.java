package com.example.junit.service;

import com.example.junit.payload.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

/**
 * @author PM
 * @Created 06/06/2023
 * <p>
 * created by sayr G
 */

@SpringBootTest
@AutoConfigureMockMvc
class TestServiceTest {

    @Autowired
    TestService service;

    @Autowired
    private MockMvc mvc;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Test
    @Disabled
    @DisplayName("pahtama hr, ma run nae ohn")
    public void firstTest() {
        Assertions.assertEquals("HW", service.greet());
    }

    @Test
    public void secondTest() {
        TestService service1 = Mockito.mock(TestService.class);
        Mockito.when(service1.greet()).thenReturn("Abcd");
        Assertions.assertEquals("HW", service1.greet());
//      mvc.perform().andExpect()
    }

    @Test
    public void thirdTest() {
        TestService service1 = Mockito.mock(TestService.class);
        service1.greet(); // dr ko comment pate lite yin false mhr;
        verify(service1).greet(); //greet ko call htr tr loh verify tr;
    }

    @Test
    public void test4() {
        TestService service1 = Mockito.mock(TestService.class);
        service1.greet(); //
        verifyNoInteractions(service1); //greet ko ma call htr wo loh verify tr
        // ma hote wo dr ka whole mock ko ma call htr wo loh verify tr
        //greet ko ma call htr wo loh verify chin yin you use verify(services,times(0)).greet(); ae lo call tr
    }

    @Test
    public void test5() {
        TestService service1 = Mockito.mock(TestService.class);
        service1.greet(); //
        verify(service1, times(1)).greet(); //greet ko ma call htr wo loh verify tr
    }

    @Test
    public void test6() {
        TestService testService = Mockito.mock(TestService.class);
        testService.greet();
//        testService.greet();
        testService.sell();
        InOrder order = inOrder(testService);
        order.verify(testService).greet();
//        order.verify(testService).greet();
        order.verify(testService).sell();
// dr ko nrr m ll wo greet and sell pl so ya tl but greet greet and sell  so m ya tok wo
    }

    @Test
    public void test7() {
        TestService testService = Mockito.mock(TestService.class);
        Mockito.when(testService.greet()).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, testService::greet);
    }

    @Test
    public void test8() {
        Assertions.assertEquals(anyString(), service.buy(anyString()));
        // any string ka bl string nae m so a sin pyay lr test tr
    }

    @Test
    public void test9() {
        Assumptions.assumeTrue(activeProfile.equals("prod"));
        Assertions.assertEquals("a","b"); // ma run mae test
        //how to get profile, you can also do with some smart profile annotations.
    }

//    @ActiveProfiles("") active profiles ka only applicable to class level, bl profile shi yin run ml pop

    @EnabledIf(value = "")
    //@IfProfileValue(name="name.test",value = "test") // ifprofilevalue ka only for junit4 tae
    @Test
    //dr ka po strong tl, dev mha ma hote wo , profile value ka br phyt mha run ml so tr myo
    public void test10() {
        Assertions.assertEquals("A", "B");
    }


}