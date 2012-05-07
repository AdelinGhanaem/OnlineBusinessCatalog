package com.myonlinebd.catalog.server;

import com.myonlinebd.catalog.server.domain.Response;
import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * author webmaster1803@gmail.com
 */
public class ResponseLocatorTest {

    private ResponseLocator locator = new ResponseLocator();

    @Test
    public void shouldCreateAResponseObject() {
        Response response = locator.create(Response.class);
        assertThat(response, notNullValue());

    }

    @Test
    public void shouldReturnResponseClass() {

    }
}
