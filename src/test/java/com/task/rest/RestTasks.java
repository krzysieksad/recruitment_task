package com.task.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.OptionalInt;

import static org.junit.Assert.assertEquals;

public class RestTasks {
    private static long maxId; //variable for 'addCommentForPostId' test

    @Test
    public void returnMaxUserId() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        List<String> userIds = root.findValuesAsText("userId");

        OptionalInt max = userIds.stream()
                .mapToInt(Integer::parseInt)
                .max();

        if (max.isPresent()) {
            assertEquals(10, max.getAsInt());
        }
    }

    @Test
    public void returnMaxIdForUserId() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts?userId=7";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        List<String> ids = root.findValuesAsText("id");

        OptionalInt max = ids.stream()
                .mapToInt(Integer::parseInt)
                .max();

        if (max.isPresent()) {
            assertEquals(70, max.getAsInt());
            maxId = max.getAsInt();
        }
    }

    @Test
    public void addCommentForPostId() throws IOException {
        String url = "https://jsonplaceholder.typicode.com/comments";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", "first.last@example.com");
        map.add("postId", Long.toString(maxId));
        map.add("name", "Post name");
        map.add("body", "Post body");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        assertEquals("first.last@example.com", root.findValue("email").asText());
        assertEquals(70, root.findValue("postId").asInt());
        assertEquals(501, root.findValue("id").asInt());
        assertEquals("Post name", root.findValue("name").asText());
        assertEquals("Post body", root.findValue("body").asText());
    }
}
