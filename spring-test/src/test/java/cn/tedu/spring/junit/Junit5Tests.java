package cn.tedu.spring.junit;

import org.junit.jupiter.api.*;

/*
 * 独立使用 JUnit5
 */
public class Junit5Tests {

    /**
     * 在全部测试案例之前执行，建议是静态方法
     */
    @BeforeAll
    static void beforeAll(){
        System.out.println("Junit5Tests.beforeAll");
    }

    /**
     * 在全部测试案例之后执行，建议是静态方法
     */
    @AfterAll
    static void afterAll(){
        System.out.println("Junit5Tests.afterAll");
    }

    /**
     * 在每个测试案例之前执行
     */
    @BeforeEach
    void beforeEach(){
        System.out.println("Junit5Tests.beforeEach");
    }

    /**
     * 在每个测试案例之后执行
     */
    @AfterEach
    void afterEach(){
        System.out.println("Junit5Tests.afterEach");
    }

    @Test
    void hello(){
        System.out.println("Hello World!");
    }

    @Test
    void demo(){
        System.out.println("Junit5Tests.demo");
    }

}
