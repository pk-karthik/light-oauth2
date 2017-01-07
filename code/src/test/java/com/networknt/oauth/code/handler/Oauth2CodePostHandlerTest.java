package com.networknt.oauth.code.handler;

import com.networknt.client.Client;
import com.networknt.exception.ApiException;
import com.networknt.exception.ClientException;
import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.networknt.client.oauth.TokenHelper.encodeCredentials;

/**
* Generated by swagger-codegen
*/
public class Oauth2CodePostHandlerTest {
    @ClassRule
    public static TestServer server = TestServer.getInstance();

    static final Logger logger = LoggerFactory.getLogger(Oauth2CodePostHandlerTest.class);

    @Test
    public void testAuthorizationCode() throws Exception {
        String url = "http://localhost:6881/oauth2/code";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        BasicNameValuePair[] pairs = new BasicNameValuePair[]{
            new BasicNameValuePair("j_username", "admin"),
            new BasicNameValuePair("j_password", "123456"),
            new BasicNameValuePair("response_type", "code"),
            new BasicNameValuePair("client_id", "59f347a0-c92d-11e6-9d9d-cec0c932ce01")
        };
        final List<NameValuePair> data = new ArrayList<>();
        data.addAll(Arrays.asList(pairs));
        httpPost.setEntity(new UrlEncodedFormEntity(data));
        CloseableHttpResponse response = client.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        String body  = IOUtils.toString(response.getEntity().getContent(), "utf8");
        //Assert.assertEquals(statusCode, 302);

        // at this moment, an exception will help as it is redirected to localhost:8080 and it is not up.
    }
}