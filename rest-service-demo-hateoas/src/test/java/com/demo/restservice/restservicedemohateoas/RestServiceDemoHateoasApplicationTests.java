package com.demo.restservice.restservicedemohateoas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collector;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestServiceDemoHateoasApplicationTests {

	@Mock
	private List list;


	@Test
	public void contextLoads() {
		Mockito.when(list.size()).thenReturn(5).thenReturn(10);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("coco");
		Mockito.when(list.contains("young")).thenReturn(true);
		Mockito.when(list.isEmpty()).thenReturn(false);

		Assert.assertEquals(5,list.size());
		Assert.assertEquals(10,list.size());
		Assert.assertEquals("coco",list.get(100));
		Assert.assertEquals("coco",list.get(-1));
		Assert.assertTrue(list.contains("young"));
		Assert.assertFalse(list.isEmpty());

	}

	@Test
	public void testStream() {
	}

}

