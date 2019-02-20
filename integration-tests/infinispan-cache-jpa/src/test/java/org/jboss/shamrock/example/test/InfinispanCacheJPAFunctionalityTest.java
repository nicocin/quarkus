package org.jboss.shamrock.example.test;

import io.restassured.RestAssured;
import org.jboss.shamrock.test.junit.ShamrockTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

/**
 * Test connecting Hibernate ORM to H2.
 * The H2 database server is run in JVM mode, the Hibernate based application
 * is run in both JVM mode and native mode (see also test in subclass).
 */
@ShamrockTest
public class InfinispanCacheJPAFunctionalityTest {

    @Test
    public void testCacheJPAFunctionalityFromServlet() {
        RestAssured.when().get("/infinispan-cache-jpa/testfunctionality").then().body(is("OK"));
    }

    @Test
    public void testEntityMemoryObjectCountOverride() {
        RestAssured.when()
                .get("/infinispan-cache-jpa/memory-object-count/com.example.EntityA")
                .then().body(is("200"));
    }

    @Test
    public void testEntityExpirationMaxIdleOverride() {
        RestAssured.when()
                .get("/infinispan-cache-jpa/expiration-max-idle/com.example.EntityB")
                .then().body(is("86400"));
    }

}
